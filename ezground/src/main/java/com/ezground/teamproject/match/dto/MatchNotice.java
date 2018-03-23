package com.ezground.teamproject.match.dto;

public class MatchNotice {
	private String calendar;
	private String time;
	private int teamNo;
	private String matchNoticeRegion;
	private String matchNoticeStatus;
	private int matchMemberCount;
	private String matchNoticeInsertDate;
	private String matchNoticeUpdateDate;
	
	
	public MatchNotice() {
		super();
	}
	public MatchNotice(String calendar, String time, int teamNo, String matchNoticeRegion, String matchNoticeStatus,
			int matchMemberCount, String matchNoticeInsertDate, String matchNoticeUpdateDate) {
		super();
		this.calendar = calendar;
		this.time = time;
		this.teamNo = teamNo;
		this.matchNoticeRegion = matchNoticeRegion;
		this.matchNoticeStatus = matchNoticeStatus;
		this.matchMemberCount = matchMemberCount;
		this.matchNoticeInsertDate = matchNoticeInsertDate;
		this.matchNoticeUpdateDate = matchNoticeUpdateDate;
	}
	@Override
	public String toString() {
		return "MatchNotice [calendar=" + calendar + ", time=" + time + ", teamNo=" + teamNo + ", matchNoticeRegion="
				+ matchNoticeRegion + ", matchNoticeStatus=" + matchNoticeStatus + ", matchMemberCount="
				+ matchMemberCount + ", matchNoticeInsertDate=" + matchNoticeInsertDate + ", matchNoticeUpdateDate="
				+ matchNoticeUpdateDate + "]";
	}
	public String getCalendar() {
		return calendar;
	}
	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public String getMatchNoticeRegion() {
		return matchNoticeRegion;
	}
	public void setMatchNoticeRegion(String matchNoticeRegion) {
		this.matchNoticeRegion = matchNoticeRegion;
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
	public String getMatchNoticeInsertDate() {
		return matchNoticeInsertDate;
	}
	public void setMatchNoticeInsertDate(String matchNoticeInsertDate) {
		this.matchNoticeInsertDate = matchNoticeInsertDate;
	}
	public String getMatchNoticeUpdateDate() {
		return matchNoticeUpdateDate;
	}
	public void setMatchNoticeUpdateDate(String matchNoticeUpdateDate) {
		this.matchNoticeUpdateDate = matchNoticeUpdateDate;
	}	
}
