package com.ezground.teamproject.facility.dto;

import java.util.List;

public class FacilityAndFacilityField {
	private int fieldNo;
	private int facilityNo;
	private String fieldName;
	private String fieldPeopleNumber;
	private String fieldSize;
	private String fieldPrice;
	private String facilityAddress;	
	private String facilityNotice;
	private String facilityDetail;
	private String facilityPrice;
	private String facilityRefund;
	private String facilityRule;
	private List<FacilityAndFacilitySub> subs;
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
	public String getFieldPrice() {
		return fieldPrice;
	}
	public void setFieldPrice(String fieldPrice) {
		this.fieldPrice = fieldPrice;
	}
	public String getFacilityAddress() {
		return facilityAddress;
	}
	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}
	public String getFacilityNotice() {
		return facilityNotice;
	}
	public void setFacilityNotice(String facilityNotice) {
		this.facilityNotice = facilityNotice;
	}
	public String getFacilityDetail() {
		return facilityDetail;
	}
	public void setFacilityDetail(String facilityDetail) {
		this.facilityDetail = facilityDetail;
	}
	public String getFacilityPrice() {
		return facilityPrice;
	}
	public void setFacilityPrice(String facilityPrice) {
		this.facilityPrice = facilityPrice;
	}
	public String getFacilityRefund() {
		return facilityRefund;
	}
	public void setFacilityRefund(String facilityRefund) {
		this.facilityRefund = facilityRefund;
	}
	public String getFacilityRule() {
		return facilityRule;
	}
	public void setFacilityRule(String facilityRule) {
		this.facilityRule = facilityRule;
	}
	public List<FacilityAndFacilitySub> getSubs() {
		return subs;
	}
	public void setSubs(List<FacilityAndFacilitySub> subs) {
		this.subs = subs;
	}
	@Override
	public String toString() {
		return "FacilityAndFacilityField [fieldNo=" + fieldNo + ", facilityNo=" + facilityNo + ", fieldName="
				+ fieldName + ", fieldPeopleNumber=" + fieldPeopleNumber + ", fieldSize=" + fieldSize + ", fieldPrice="
				+ fieldPrice + ", facilityAddress=" + facilityAddress + ", facilityNotice=" + facilityNotice
				+ ", facilityDetail=" + facilityDetail + ", facilityPrice=" + facilityPrice + ", facilityRefund="
				+ facilityRefund + ", facilityRule=" + facilityRule + ", subs=" + subs + "]";
	}
	
}
