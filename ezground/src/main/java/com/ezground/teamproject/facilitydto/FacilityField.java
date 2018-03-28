package com.ezground.teamproject.facilitydto;

import java.sql.Timestamp;

public class FacilityField {
	
	private int fieldNo;
	private int facilityNo;
	private String fieldName;
	private String fieldSize;
	private String fieldPrice;
	private String fieldNumber;
	private Timestamp fieldWriteDate;
	
	public int getFieldNo() {
		return fieldNo;
	}
	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}
	public int getFacilityNo() {
		return facilityNo;
	}
	public void setFacilityNo(int facilityNo) {
		this.facilityNo = facilityNo;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(String fieldSize) {
		this.fieldSize = fieldSize;
	}
	public String getFieldPrice() {
		return fieldPrice;
	}
	public void setFieldPrice(String fieldPrice) {
		this.fieldPrice = fieldPrice;
	}
	public String getFieldNumber() {
		return fieldNumber;
	}
	public void setFieldNumber(String fieldNumber) {
		this.fieldNumber = fieldNumber;
	}
	public Timestamp getFieldWriteDate() {
		return fieldWriteDate;
	}
	public void setFieldWriteDate(Timestamp fieldWriteDate) {
		this.fieldWriteDate = fieldWriteDate;
	}
	
	
}
