package com.ezground.teamproject.member.dto;

import java.util.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberLevel;
	private String memberName;
	private String memberAge;
	private String memberGender;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Date memberJoinDate;
	private int memberPoint;
	private String memberWithdrawalStatus;
	
	public Member() {
		super();
	}
	public Member(int memberNo, String memberId, String memberPw, String memberLevel, String memberName,
			String memberAge, String memberGender, String memberPhone, String memberEmail, String memberAddress,
			Date memberJoinDate, int memberPoint, String memberWithdrawalStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberLevel = memberLevel;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberJoinDate = memberJoinDate;
		this.memberPoint = memberPoint;
		this.memberWithdrawalStatus = memberWithdrawalStatus;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberLevel="
				+ memberLevel + ", memberName=" + memberName + ", memberAge=" + memberAge + ", memberGender="
				+ memberGender + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberAddress="
				+ memberAddress + ", memberJoinDate=" + memberJoinDate + ", memberPoint=" + memberPoint
				+ ", memberWithdrawalStatus=" + memberWithdrawalStatus + "]";
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public Date getMemberJoinDate() {
		return memberJoinDate;
	}
	public void setMemberJoinDate(Date memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberWithdrawalStatus() {
		return memberWithdrawalStatus;
	}
	public void setMemberWithdrawalStatus(String memberWithdrawalStatus) {
		this.memberWithdrawalStatus = memberWithdrawalStatus;
	}
	
	
	
}
