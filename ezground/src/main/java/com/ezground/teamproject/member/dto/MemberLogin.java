package com.ezground.teamproject.member.dto;

public class MemberLogin {
	
	private String memberId;
	private String memberPw;
	private String memberLevel;
		
	
	public MemberLogin() {
		super();
	}
	public MemberLogin(String memberId, String memberPw, String memberLevel) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberLevel = memberLevel;
	}
	@Override
	public String toString() {
		return "MemberLogin [memberId=" + memberId + ", memberPw=" + memberPw + ", memberLevel=" + memberLevel + "]";
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
	
	
}
