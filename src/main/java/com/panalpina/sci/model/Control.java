package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Control database table.
 * 
 */
@Entity
@Table(name="t_Control")
@NamedQuery(name="Control.findAll", query="SELECT t FROM Control t")
public class Control implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Control_ID", unique=true, nullable=false)
	private int controlID;

	@Column(name="Business_Unit_ID", nullable=false, length=255)
	private String businessUnitID;

	@Column(name="Control_Type", length=50)
	private String controlType;

	@Column(name="Increment")
	private int increment;

	@Column(name="Prefix", length=10)
	private String prefix;

	@Column(name="Sequence_End", length=50)
	private String sequenceEnd;

	@Column(name="Sequence_Start", length=50)
	private String sequenceStart;

	@Column(name="Suffix", length=10)
	private String suffix;

	@Column(name="UDF1", precision=53)
	private double udf1;

	@Column(name="UDF2", precision=53)
	private double udf2;

	@Column(name="UDF3", precision=53)
	private double udf3;

	@Column(name="UDT1", length=30)
	private String udt1;

	@Column(name="UDT2", length=30)
	private String udt2;

	@Column(name="UDT3", length=30)
	private String udt3;

	public Control() {
	}


	public int getControlID() {
		return controlID;
	}


	public void setControlID(int controlID) {
		this.controlID = controlID;
	}


	public int getIncrement() {
		return this.increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}


	public String getBusinessUnitID() {
		return businessUnitID;
	}

	public void setBusinessUnitID(String businessUnitID) {
		this.businessUnitID = businessUnitID;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getSequenceEnd() {
		return sequenceEnd;
	}

	public void setSequenceEnd(String sequenceEnd) {
		this.sequenceEnd = sequenceEnd;
	}

	public String getSequenceStart() {
		return sequenceStart;
	}

	public void setSequenceStart(String sequenceStart) {
		this.sequenceStart = sequenceStart;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public double getUdf1() {
		return this.udf1;
	}

	public void setUdf1(double udf1) {
		this.udf1 = udf1;
	}

	public double getUdf2() {
		return this.udf2;
	}

	public void setUdf2(double udf2) {
		this.udf2 = udf2;
	}

	public double getUdf3() {
		return this.udf3;
	}

	public void setUdf3(double udf3) {
		this.udf3 = udf3;
	}

	public String getUdt1() {
		return this.udt1;
	}

	public void setUdt1(String udt1) {
		this.udt1 = udt1;
	}

	public String getUdt2() {
		return this.udt2;
	}

	public void setUdt2(String udt2) {
		this.udt2 = udt2;
	}

	public String getUdt3() {
		return this.udt3;
	}

	public void setUdt3(String udt3) {
		this.udt3 = udt3;
	}

}