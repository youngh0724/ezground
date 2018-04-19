package com.ezground.teamproject.facility.dto;

import java.sql.Time;
import java.util.Date;

public class FacilityCalendar {

	private int calendarNo;
	private int facilityNo;
	private int fieldNo;
	private Time calendarStartTime;
	private Time calendarEndTime;
	private String calendarDate;
	private String calendarStatus;
	private Date calendarWriteDate;
	public int getCalendarNo() {
		return calendarNo;
	}
	public void setCalendarNo(int calendarNo) {
		this.calendarNo = calendarNo;
	}
	public int getFacilityNo() {
		return facilityNo;
	}
	public void setFacilityNo(int facilityNo) {
		this.facilityNo = facilityNo;
	}
	public int getFieldNo() {
		return fieldNo;
	}
	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}
	public Time getCalendarStartTime() {
		return calendarStartTime;
	}
	public void setCalendarStartTime(Time calendarStartTime) {
		this.calendarStartTime = calendarStartTime;
	}
	public Time getCalendarEndTime() {
		return calendarEndTime;
	}
	public void setCalendarEndTime(Time calendarEndTime) {
		this.calendarEndTime = calendarEndTime;
	}
	public String getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(String calendarDate) {
		this.calendarDate = calendarDate;
	}
	public String getCalendarStatus() {
		return calendarStatus;
	}
	public void setCalendarStatus(String calendarStatus) {
		this.calendarStatus = calendarStatus;
	}
	public Date getCalendarWriteDate() {
		return calendarWriteDate;
	}
	public void setCalendarWriteDate(Date calendarWriteDate) {
		this.calendarWriteDate = calendarWriteDate;
	}
}
