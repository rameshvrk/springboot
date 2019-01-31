package com.panalpina.sci.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.panalpina.sci.constants.CommonConstants;



/**
 * Utility class
 * 
 * @author Cybage
 *
 */
public class Util {
	public static final Logger _logger = LogManager.getLogger(Util.class);
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public Util() {
	}

	public static Collection<?> initializeCollection(Collection<?> coll) {
//		_logger.debug("Invoked initializeCollection method");
		if ((coll != null) && (!coll.isEmpty())) {
			coll.iterator().hasNext();
		}
		return coll;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static List<?> reverseList(List<?> coll) {
//		_logger.debug("Invoked reverseCollection method");
		if (coll != null) {
			Collections.reverse(coll);
		}
		return coll;
	}

	public static int getDaysBetween(Date dateEarly, Date dateLater) {
//		_logger.debug("Invoked getDaysBetween method");
		int diffInDays = (int) ((dateLater.getTime() - dateEarly.getTime()) / 86400000L);
		return diffInDays;
	}

	public static String getTrimString(String str) {
		return str.trim();
	}

	public static Object callGetter(Field field, Object obj) {
//		_logger.debug("Invoked callGetter method");
		Object getObj = null;
		String actualFieldName = field.getName();
		String prop = Character.toUpperCase(actualFieldName.charAt(0))
				+ (actualFieldName.length() > 1 ? actualFieldName.substring(1) : "");
		String _fieldGetter = "get" + prop;
		try {
			Method m = obj.getClass().getMethod(_fieldGetter, new Class[0]);
			getObj = m.invoke(obj, (Object[]) null);
		} catch (Exception e) {
			if (_logger.isDebugEnabled()) {
				_logger.debug(e);
			}
		}
		String typeName = field.getType().getSimpleName();
		if (("Set".equalsIgnoreCase(typeName)) || ("List".equalsIgnoreCase(typeName))) {
			Collection<?> coll = (Collection<?>) getObj;
			initializeCollection(coll);
		}
		return getObj;
	}

	public static String getObjectValue(Object obj) {
//		_logger.debug("Invoked getObjectValue method");

		if (obj == null) {
			return CommonConstants.BLANK;
		}
		String value = null;
		if ((obj instanceof Boolean)) {
			value = ((Boolean) obj).toString();
		} else if ((obj instanceof Byte)) {
			value = ((Byte) obj).toString();
		} else if (((obj instanceof Character)) || (obj.getClass().toString().equalsIgnoreCase("char"))) {
			value = ((Character) obj).toString();
		} else if (((obj instanceof Short)) || (obj.getClass().toString().equalsIgnoreCase("short"))) {
			value = ((Short) obj).toString();
		} else if (((obj instanceof Integer)) || (obj.getClass().toString().equalsIgnoreCase("int"))) {
			value = ((Integer) obj).toString();
		} else if (((obj instanceof Long)) || (obj.getClass().toString().equalsIgnoreCase("long"))) {
			value = ((Long) obj).toString();
		} else if (((obj instanceof Float)) || (obj.getClass().toString().equalsIgnoreCase("float"))) {
			value = ((Float) obj).toString();
		} else if (((obj instanceof Double)) || (obj.getClass().toString().equalsIgnoreCase("double"))) {
			value = ((Double) obj).toString();
		} else if ((obj instanceof BigDecimal)) {
			value = ((BigDecimal) obj).toString();
		} else {
			value = obj.toString();
		}
		return value;
	}

	public static String convertDateStringToAnotherDateString(String stringdate, String stringdateformat, String returndateformat) {
//		_logger.debug("Invoked convertDateStringToAnotherDateString method");
		try {
            Date date = new SimpleDateFormat(stringdateformat).parse(stringdate);
            String returndate = new SimpleDateFormat(returndateformat).format(date);
            return returndate;
        } catch (ParseException e) {
        	_logger.error("ParseException in convertDateStringToAnotherDateString:", e);
            return stringdate;
        }
	}
	
	public static boolean isStringEmpty(String key){
		return (null == key || key.isEmpty());
	}
	
	public static boolean isCollectionEmpty(Collection<?> key){
		return (null == key || key.isEmpty());
	}

	public static long getDays(String inputDateStr) {
		SimpleDateFormat myFormat = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DDMMYYYY);

		long diff = 0;
		if(isStringEmpty(inputDateStr)){
			return diff;
		}
		try {
			Date startDate = myFormat.parse(inputDateStr);
			
			Date endDate = new Date();
			endDate = myFormat.parse(myFormat.format(endDate));
			
			diff = startDate.getTime() - endDate.getTime();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * @param inputDateStr
	 *            date string with format dd/MM/yyyy
	 * @return true if passed date is after the current date else false
	 */
	public static boolean isCurrentDateGreater(String inputDateStr) {
		SimpleDateFormat myFormat = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DDMMYYYY);

		boolean valid = false;
		if (isStringEmpty(inputDateStr)) {
			return valid;
		}
		try {
			Date startDate = myFormat.parse(inputDateStr);

			Date currentDate = new Date();
			currentDate = myFormat.parse(myFormat.format(currentDate));

			valid = currentDate.after(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	public static String dateToStringFormatter(Date date) {
		DateFormat df = new SimpleDateFormat(CommonConstants.DATE_PATTERN_EEEMMDDYYY);
		return df.format(date);
	}

	/**
	 * Method to convert date to string into user's TimeZone
	 * @param inputDate Input Date
	 * @param timeZone user's TimeZone as string
	 * @param dateFormat SimpleDateFormat string
	 * @return TimeZone specific converted string
	 */
/*	public static String convertDateToStringIntoUserTimezone(Date inputDate, String timeZone, String dateFormat){
		TimeZone zone = TimeZone.getTimeZone(timeZone);
		DateFormat format =  new SimpleDateFormat(dateFormat);
		format.setTimeZone(zone);
		String newDate = CommonConstants.BLANK;
		if(inputDate != null){
			newDate = format.format(inputDate);
		}
		return newDate;
	}*/

	public static String convertDateToStringIntoUserTimezone(Date inputDate, String timeZone, String dateFormat){
		TimeZone zone = TimeZone.getTimeZone(timeZone);
		DateFormat format =  new SimpleDateFormat(dateFormat);
		format.setTimeZone(zone);
		String newDate = "";
		if(inputDate != null){
			TimeZone  tz= TimeZone.getTimeZone(timeZone);
			long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
			long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
	                                  - TimeUnit.HOURS.toMinutes(hours);
			minutes = Math.abs(minutes);
			Calendar cl = Calendar.getInstance();
			cl.setTime(inputDate);

			cl.add(Calendar.HOUR, (int)hours);
			cl.add(Calendar.MINUTE, (int)minutes);

			Date calendarTime = cl.getTime();
			
			newDate = new SimpleDateFormat(dateFormat).format(calendarTime);
		}
		return newDate;

	}

	
	/**
	 * Method to convert date into user's TimeZone
	 * @param inputDate Input Date
	 * @param timeZone user's TimeZone as string
	 * @param dateFormat SimpleDateFormat string
	 * @return TimeZone specific converted string
	 * @throws ParseException 
	 */
/*	public static Date convertDateIntoUserTimezone(Date inputDate, String timeZone, String dateFormat){
		String newDate = convertDateToStringIntoUserTimezone(inputDate, timeZone, dateFormat);
		Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}*/
	public static Date convertDateIntoUserTimezone(Date inputDate, String timeZone, String dateFormat){
		Date calendarTime = null;
		if(inputDate != null){
			TimeZone  tz= TimeZone.getTimeZone(timeZone);
			long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
			long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
	                                  - TimeUnit.HOURS.toMinutes(hours);
			minutes = Math.abs(minutes);
			Calendar cl = Calendar.getInstance();
			cl.setTime(inputDate);
			cl.add(Calendar.HOUR, (int)hours);
			cl.add(Calendar.MINUTE, (int)minutes);
			calendarTime = cl.getTime();
		}
		return calendarTime;
	}

	/**
	 * Method to convert date into user's TimeZone
	 * @param inputDate Input Date
	 * @param timeZone user's TimeZone as string
	 * @param dateFormat SimpleDateFormat string
	 * @return TimeZone specific converted string
	 * @throws ParseException 
	 */
	public static Date convertStringToDateIntoUserTimezone(String inputDate, String timeZone, String dateFormat) {
		Date inputDateString = null;
		try {
			inputDateString = new SimpleDateFormat(dateFormat).parse(inputDate);
		} catch (ParseException e) {
		}
		
		return convertDateIntoUserTimezone(inputDateString, timeZone, dateFormat);
	}

	public static String convertStringToTimeZoneSpecificDateString(String inputDate, String timeZone, String dateFormat){
		
		TimeZone zone = TimeZone.getTimeZone(timeZone);
		DateFormat format = new SimpleDateFormat(dateFormat);
		String reformattedStr = null;
		
		if(inputDate != null && !CommonConstants.BLANK.equals(inputDate)){
			format.setTimeZone(zone);
			try {
				Date date = format.parse(inputDate);
				 reformattedStr = new SimpleDateFormat(dateFormat).format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return reformattedStr;
	}
	
	/**
	 * This method checks for valid email address format.
	 * @param emailId
	 * @return
	 */
	public static boolean validateEmail(String emailStr) {
		if( isStringEmpty(emailStr)) {
			return false;
		}
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static Date getUTCdatetimeAsDate(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String utcTime = sdf.format(date);
		
		Date dateToReturn = null;
		try {
			dateToReturn = new SimpleDateFormat(dateFormat).parse(utcTime);
		} catch (ParseException e) {
			 e.printStackTrace();
		}		
		return dateToReturn;
	}

	public static String getUTCdatetimeAsDateString(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String utcTime = sdf.format(date);
		return utcTime;
	}

	public static String getUTCdatetimeStringAsDateString(String inputDate, String dateFormat) {
		Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(inputDate);
		} catch (ParseException e) {
		}
		TimeZone zone = TimeZone.getTimeZone("UTC");
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		String reformattedStr = null;
		format.setTimeZone(zone);
		reformattedStr = format.format(date);
		return reformattedStr;
	}

	public static Date getUTCdatetimeStringAsDate(String inputDate, String dateFormat) {
        Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(inputDate);
		} catch (ParseException e) {
		}
		
		TimeZone zone = TimeZone.getTimeZone("UTC");
		SimpleDateFormat  format = new SimpleDateFormat(dateFormat);
		Date reformattedDate = null;
		String reformattedStr = null;
		format.setTimeZone(zone);
		reformattedStr = format.format(date);
		try {
			reformattedDate = new SimpleDateFormat(dateFormat).parse(reformattedStr);
		} catch (ParseException e) {
		}
		return reformattedDate;
	}
	
	public static Date getUTCDate(Object obj, String dateFormat){
		
		Date date=null;
		String dateStr = "";
		
		if(obj instanceof Date){
			date = (Date) obj;
		}else if(obj instanceof String){
			dateStr = (String) obj;
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		Calendar calendar = Calendar.getInstance();
		TimeZone fromTimeZone =  calendar.getTimeZone();

		TimeZone toTimeZone = TimeZone.getTimeZone("UTC");
		calendar.setTimeZone(fromTimeZone);
		calendar.setTime(date);
		calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
		 
		if (fromTimeZone.inDaylightTime(calendar.getTime())) {
		calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
		}
		calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
		 
		if (toTimeZone.inDaylightTime(calendar.getTime())) {
		calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		}
		return calendar.getTime();
	}
	
	public static String appendHtml(String value){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html><head>");
		stringBuilder.append(value);
		stringBuilder.append("</head></html>");
		return stringBuilder.toString();
	}
	
	public static String getCamelCaseRoleName(String userRole) {
		String userRoleName = "";
		switch (userRole) {
		case CommonConstants.MANAGER:
			userRoleName = "Manager";
			break;
		case CommonConstants.QACORDINATOR:
			userRoleName = "QA Coordinator";
			break;
		case CommonConstants.VENDOR:
			userRoleName = "Vendor";
			break;
		case CommonConstants.AUDITOR:
			userRoleName = "Quality inspector";
			break;
		}
		return userRoleName;
	}
	
}