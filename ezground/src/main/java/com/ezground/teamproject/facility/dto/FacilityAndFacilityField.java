package com.ezground.teamproject.facility.dto;

public class FacilityAndFacilityField {
	private int fieldNo;
	private int facilityNo;
	private String fieldName;
	private String fieldPeopleNumber;
	private String fieldSize;
	private String facilityAddress;
	private String fieldPrice;
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
	public String getFieldPeopleNumber() {
		return fieldPeopleNumber;
	}
	public void setFieldPeopleNumber(String fieldPeopleNumber) {
		this.fieldPeopleNumber = fieldPeopleNumber;
	}
	public String getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(String fieldSize) {
		this.fieldSize = fieldSize;
	}
	public String getFacilityAddress() {
		return facilityAddress;
	}
	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}
	public String getFieldPrice() {
		return fieldPrice;
	}
	public void setFieldPrice(String fieldPrice) {
		this.fieldPrice = fieldPrice;
	}
	@Override
	public String toString() {
		return "FacilityAndFacilityField [fieldNo=" + fieldNo + ", facilityNo=" + facilityNo + ", fieldName="
				+ fieldName + ", fieldPeopleNumber=" + fieldPeopleNumber + ", fieldSize=" + fieldSize
				+ ", fieldAddress=" + facilityAddress + ", fieldPrice=" + fieldPrice + "]";
	}
	

}
