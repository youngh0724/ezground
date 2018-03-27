package com.ezground.teamproject.match.dto;

public class MatchNotice {
	private int matchNoticeNo;
	private String matchExpectedDay;
	private String matchExpectedStartTime;
	private String matchExpectedEndTime;
	private int sportEntriesNo;
	private int memberNo;
	private String matchNoticeRegion;
	private String matchKinds;
	private String matchNoticeStatus;
	private int matchMemberCount;
	private String matchNoticeInsertDate;
	private String matchNoticeUpdateDate;
	private String matchFurtherInformation;	
	
	public MatchNotice() {
		super();
	}
	public MatchNotice(int matchNoticeNo, String matchExpectedDay, String matchExpectedStartTime,
			String matchExpectedEndTime, int sportEntriesNo, int memberNo, String matchNoticeRegion, String matchKinds,
			String matchNoticeStatus, int matchMemberCount, String matchNoticeInsertDate, String matchNoticeUpdateDate,
			String matchFurtherInformation) {
		super();
		this.matchNoticeNo = matchNoticeNo;
		this.matchExpectedDay = matchExpectedDay;
		this.matchExpectedStartTime = matchExpectedStartTime;
		this.matchExpectedEndTime = matchExpectedEndTime;
		this.sportEntriesNo = sportEntriesNo;
		this.memberNo = memberNo;
		this.matchNoticeRegion = matchNoticeRegion;
		this.matchKinds = matchKinds;
		this.matchNoticeStatus = matchNoticeStatus;
		this.matchMemberCount = matchMemberCount;
		this.matchNoticeInsertDate = matchNoticeInsertDate;
		this.matchNoticeUpdateDate = matchNoticeUpdateDate;
		this.matchFurtherInformation = matchFurtherInformation;
	}
	@Override
	public String toString() {
		return "MatchNotice [matchNoticeNo=" + matchNoticeNo + ", matchExpectedDay=" + matchExpectedDay
				+ ", matchExpectedStartTime=" + matchExpectedStartTime + ", matchExpectedEndTime="
				+ matchExpectedEndTime + ", sportEntriesNo=" + sportEntriesNo + ", memberNo=" + memberNo
				+ ", matchNoticeRegion=" + matchNoticeRegion + ", matchKinds=" + matchKinds + ", matchNoticeStatus="
				+ matchNoticeStatus + ", matchMemberCount=" + matchMemberCount + ", matchNoticeInsertDate="
				+ matchNoticeInsertDate + ", matchNoticeUpdateDate=" + matchNoticeUpdateDate
				+ ", matchFurtherInformation=" + matchFurtherInformation + "]";
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
	public String getMatchExpectedStartTime() {
		return matchExpectedStartTime;
	}
	public void setMatchExpectedStartTime(String matchExpectedStartTime) {
		this.matchExpectedStartTime = matchExpectedStartTime;
	}
	public String getMatchExpectedEndTime() {
		return matchExpectedEndTime;
	}
	public void setMatchExpectedEndTime(String matchExpectedEndTime) {
		this.matchExpectedEndTime = matchExpectedEndTime;
	}
	public int getSportEntriesNo() {
		return sportEntriesNo;
	}
	public void setSportEntriesNo(int sportEntriesNo) {
		this.sportEntriesNo = sportEntriesNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMatchNoticeRegion() {
		return matchNoticeRegion;
	}
	public void setMatchNoticeRegion(String matchNoticeRegion) {
		this.matchNoticeRegion = matchNoticeRegion;
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
	public String getMatchFurtherInformation() {
		return matchFurtherInformation;
	}
	public void setMatchFurtherInformation(String matchFurtherInformation) {
		this.matchFurtherInformation = matchFurtherInformation;
	}			
}
