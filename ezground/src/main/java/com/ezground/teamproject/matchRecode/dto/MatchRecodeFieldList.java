package com.ezground.teamproject.matchRecode.dto;

public class MatchRecodeFieldList {
	
	private int facilityNo;
	private String facilityName;
	private int fieldNo;
	private int fieldName;
		
	@Override
	public String toString() {
		return "MatchRecodeFieldList [facilityNo=" + facilityNo + ", facilityName=" + facilityName + ", fieldNo="
				+ fieldNo + ", fieldName=" + fieldName + "]";
	}
	public int getFacilityNo() {
		return facilityNo;
	}
	public void setFacilityNo(int facilityNo) {
		this.facilityNo = facilityNo;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public int getFieldNo() {
		return fieldNo;
	}
	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}
	public int getFieldName() {
		return fieldName;
	}
	public void setFieldName(int fieldName) {
		this.fieldName = fieldName;
	}
	
}
