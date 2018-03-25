package com.ezground.teamproject.member.dto;

public class MemberLogin {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberLevel;
		
	public MemberLogin() {
		super();
	}
	public MemberLogin(int memberNo, String memberId, String memberPw, String memberLevel) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberLevel = memberLevel;
	}
	@Override
	public String toString() {
		return "MemberLogin [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberLevel=" + memberLevel + "]";
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
}
