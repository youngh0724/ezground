package com.ezground.teamproject.matchRecord.dto;

public class MatchRecordInfo {
	
	private int matchJoinMemberNo;
	private int matchNoticeNo;
	private int memberNo;
	private int teamNo;
	private String homeAway;
	private String memberName;
	
	
	@Override
	public String toString() {
		return "MatchRecodeInfo [matchJoinMemberNo=" + matchJoinMemberNo + ", matchNoticeNo=" + matchNoticeNo
				+ ", memberNo=" + memberNo + ", teamNo=" + teamNo + ", homeAway=" + homeAway + ", memberName="
				+ memberName + "]";
	}
	public int getMatchJoinMemberNo() {
		return matchJoinMemberNo;
	}
	public void setMatchJoinMemberNo(int matchJoinMemberNo) {
		this.matchJoinMemberNo = matchJoinMemberNo;
	}
	public int getMatchNoticeNo() {
		return matchNoticeNo;
	}
	public void setMatchNoticeNo(int matchNoticeNo) {
		this.matchNoticeNo = matchNoticeNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public String getHomeAway() {
		return homeAway;
	}
	public void setHomeAway(String homeAway) {
		this.homeAway = homeAway;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}	
}
