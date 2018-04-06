package com.ezground.teamproject.reservation.dto;

import java.util.Date;

public class Reservation {
	private int reservationNo;
	private int memberNo;
	private int facilityNo;
	private int fieldNo;
	private int calendarNo;
	private int teamNo;
	private int matchNo;
	private String reservationStatus;
	private Date reservationDate;
	private Date reservationCancelDate;
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
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public int getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Date getReservationCancelDate() {
		return reservationCancelDate;
	}
	public void setReservationCancelDate(Date reservationCancelDate) {
		this.reservationCancelDate = reservationCancelDate;
	}
	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", memberNo=" + memberNo + ", facilityNo=" + facilityNo
				+ ", fieldNo=" + fieldNo + ", calendarNo=" + calendarNo + ", teamNo=" + teamNo + ", matchNo=" + matchNo
				+ ", reservationStatus=" + reservationStatus + ", reservationDate=" + reservationDate
				+ ", reservationCancelDate=" + reservationCancelDate + "]";
	}
	

}
