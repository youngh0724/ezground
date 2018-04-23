package com.ezground.teamproject.matchRecord.dto;

public class MatchRecordFieldList {
	
	private int facilityNo;
	private String facilityName;
	private int fieldNo;
	private String fieldName;
	private int memberNo;
	private int matchNoticeNo;
	private int reservationNo;
	private String calendarStartTime;
	private String calendarEndTime;
	private String calendarDate;
	
	@Override
	public String toString() {
		return "MatchRecodeFieldList [facilityNo=" + facilityNo + ", facilityName=" + facilityName + ", fieldNo="
				+ fieldNo + ", fieldName=" + fieldName + ", memberNo=" + memberNo + ", matchNoticeNo=" + matchNoticeNo
				+ ", reservationNo=" + reservationNo + ", calendarStartTime=" + calendarStartTime + ", calendarEndTime="
				+ calendarEndTime + ", calendarDate=" + calendarDate + "]";
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
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getMatchNoticeNo() {
		return matchNoticeNo;
	}
	public void setMatchNoticeNo(int matchNoticeNo) {
		this.matchNoticeNo = matchNoticeNo;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getCalendarStartTime() {
		return calendarStartTime;
	}
	public void setCalendarStartTime(String calendarStartTime) {
		this.calendarStartTime = calendarStartTime;
	}
	public String getCalendarEndTime() {
		return calendarEndTime;
	}
	public void setCalendarEndTime(String calendarEndTime) {
		this.calendarEndTime = calendarEndTime;
	}
	public String getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(String calendarDate) {
		this.calendarDate = calendarDate;
	}		
}
