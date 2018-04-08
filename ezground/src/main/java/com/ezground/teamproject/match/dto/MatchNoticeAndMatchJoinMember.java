package com.ezground.teamproject.match.dto;

public class MatchNoticeAndMatchJoinMember {
	
	private int matchNoticeNo;
	private String matchExpectedDay;
	private int sportEntriesNo;
	private String matchKinds;
	private String matchNoticeStatus;
	private int matchMemberCount;
	private String homeAway;	
	private int teamNo;
	
	public MatchNoticeAndMatchJoinMember() {
		super();
	}
	public MatchNoticeAndMatchJoinMember(int matchNoticeNo, String matchExpectedDay, int sportEntriesNo,
			String matchKinds, String matchNoticeStatus, int matchMemberCount, String homeAway, int teamNo) {
		super();
		this.matchNoticeNo = matchNoticeNo;
		this.matchExpectedDay = matchExpectedDay;
		this.sportEntriesNo = sportEntriesNo;
		this.matchKinds = matchKinds;
		this.matchNoticeStatus = matchNoticeStatus;
		this.matchMemberCount = matchMemberCount;
		this.homeAway = homeAway;
		this.teamNo = teamNo;
	}
	@Override
	public String toString() {
		return "MatchNoticeAndMatchJoinMember [matchNoticeNo=" + matchNoticeNo + ", matchExpectedDay="
				+ matchExpectedDay + ", sportEntriesNo=" + sportEntriesNo + ", matchKinds=" + matchKinds
				+ ", matchNoticeStatus=" + matchNoticeStatus + ", matchMemberCount=" + matchMemberCount + ", homeAway="
				+ homeAway + ", teamNo=" + teamNo + "]";
	}
	public int getMatchNoticeNo() {
		return matchNoticeNo;
	}
	public void setMatchNoticeNo(int matchNoticeNo) {
		this.matchNoticeNo = matchNoticeNo;
	}
	public String getMatchExpectedDay() {
		return matchExpectedDay;
	}
	public void setMatchExpectedDay(String matchExpectedDay) {
		this.matchExpectedDay = matchExpectedDay;
	}
	public int getSportEntriesNo() {
		return sportEntriesNo;
	}
	public void setSportEntriesNo(int sportEntriesNo) {
		this.sportEntriesNo = sportEntriesNo;
	}
	public String getMatchKinds() {
		return matchKinds;
	}
	public void setMatchKinds(String matchKinds) {
		this.matchKinds = matchKinds;
	}
	public String getMatchNoticeStatus() {
		return matchNoticeStatus;
	}
	public void setMatchNoticeStatus(String matchNoticeStatus) {
		this.matchNoticeStatus = matchNoticeStatus;
	}
	public int getMatchMemberCount() {
		return matchMemberCount;
	}
	public void setMatchMemberCount(int matchMemberCount) {
		this.matchMemberCount = matchMemberCount;
	}
	public String getHomeAway() {
		return homeAway;
	}
	public void setHomeAway(String homeAway) {
		this.homeAway = homeAway;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}		
}
