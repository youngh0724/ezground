package com.ezground.teamproject.reservation.dto;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Reservation {
	private int reservationNo;
	private int memberNo;
	private int facilityNo;
	private int fieldNo;
	private int calendarNo;
	private int matchNoticeNo;
	private int teamNo;
	private String fieldName;
	private String fieldPrice;
	private String facilityAddress;
	private String calendarStartTime;
	private String calendarEndTime;	
	private Date calendarDate;
	private String sportEntriesNo;
	private String reservationStatus;
	private String reservationDate;
	private String reservationCancelDate;
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
	public int getCalendarNo() {
		return calendarNo;
	}
	public void setCalendarNo(int calendarNo) {
		this.calendarNo = calendarNo;
	}
	public int getMatchNoticeNo() {
		return matchNoticeNo;
	}
	public void setMatchNoticeNo(int matchNoticeNo) {
		this.matchNoticeNo = matchNoticeNo;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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
	public Date getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}
	public String getSportEntriesNo() {
		return sportEntriesNo;
	}
	public void setSportEntriesNo(String sportEntriesNo) {
		this.sportEntriesNo = sportEntriesNo;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationCancelDate() {
		return reservationCancelDate;
	}
	public void setReservationCancelDate(String reservationCancelDate) {
		this.reservationCancelDate = reservationCancelDate;
	}
	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", memberNo=" + memberNo + ", facilityNo=" + facilityNo
				+ ", fieldNo=" + fieldNo + ", calendarNo=" + calendarNo + ", matchNoticeNo=" + matchNoticeNo
				+ ", teamNo=" + teamNo + ", fieldName=" + fieldName + ", fieldPrice=" + fieldPrice
				+ ", facilityAddress=" + facilityAddress + ", calendarStartTime=" + calendarStartTime
				+ ", calendarEndTime=" + calendarEndTime + ", calendarDate=" + calendarDate + ", sportEntriesNo="
				+ sportEntriesNo + ", reservationStatus=" + reservationStatus + ", reservationDate=" + reservationDate
				+ ", reservationCancelDate=" + reservationCancelDate + "]";
	}
}