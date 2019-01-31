package com.panalpina.sci.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author cybage
 *
 */
public class DateUtil {

	private DateUtil() {

	}

	public static String getUpdatedStartAt(Calendar calendar) {
		final DateFormat mktDateRangeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		mktDateRangeFormat.setLenient(false);
		return mktDateRangeFormat.format(calendar.getTime());
	}

	public static String getUpdatedEndAt(Calendar calendar) {
		final DateFormat mktDateRangeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		mktDateRangeFormat.setLenient(false);
		return mktDateRangeFormat.format(calendar.getTime());
	}

	public static String getCreatedStartAt(Calendar calendar) {
		final DateFormat mktDateRangeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		mktDateRangeFormat.setLenient(false);
		return mktDateRangeFormat.format(calendar.getTime());
	}

	public static String getCreatedEndAt(Calendar calendar) {
		final DateFormat mktDateRangeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		calendar.setTime(new Date());
		mktDateRangeFormat.setLenient(false);
		return mktDateRangeFormat.format(calendar.getTime());
	}

	public static String getRepordDate(Date currentDate) {
		final DateFormat reportDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return reportDateFormat.format(currentDate);
	}

	public static String getCurrentTimestamp() {
		final DateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		return timeStampFormat.format(new Date());
	}

	public static Timestamp getSqlTimestamp() {
		/*final DateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		return timeStampFormat.format(new Date());*/
		Date now = new Date();
		Timestamp ts = new Timestamp(now.getTime());
		return ts;
	}

	public static Date getStartTime(String startTime) throws ParseException {
		final DateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		return timeStampFormat.parse(startTime);
	}

	public static String getStartTime(Date startTime) throws ParseException {
		final DateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		return timeStampFormat.format(startTime);
	}

	public static Date getDate(String date) throws ParseException {
		final DateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return timeStampFormat.parse(date);
	}

	public static String getCurrentDateTime() throws ParseException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formattert = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return now.format(formattert);
	}

}
