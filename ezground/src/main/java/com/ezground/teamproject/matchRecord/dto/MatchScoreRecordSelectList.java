package com.ezground.teamproject.matchRecord.dto;

public class MatchScoreRecordSelectList {
	
	private int scoreNo;
	private int reservationNo;
	private int matchNoticeNo;
	private String scoreSet;
	private String scoreGame;
	private String scoreTime;
	private String scoreRecord;
	private String memberName;
		
	@Override
	public String toString() {
		return "MatchScoreRecordSelectList [scoreNo=" + scoreNo + ", reservationNo=" + reservationNo
				+ ", matchNoticeNo=" + matchNoticeNo + ", scoreSet=" + scoreSet + ", scoreGame=" + scoreGame
				+ ", scoreTime=" + scoreTime + ", scoreRecord=" + scoreRecord + ", memberName=" + memberName + "]";
	}
	public int getScoreNo() {
		return scoreNo;
	}
	public void setScoreNo(int scoreNo) {
		this.scoreNo = scoreNo;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public int getMatchNoticeNo() {
		return matchNoticeNo;
	}
	public void setMatchNoticeNo(int matchNoticeNo) {
		this.matchNoticeNo = matchNoticeNo;
	}
	public String getScoreSet() {
		return scoreSet;
	}
	public void setScoreSet(String scoreSet) {
		this.scoreSet = scoreSet;
	}
	public String getScoreGame() {
		return scoreGame;
	}
	public void setScoreGame(String scoreGame) {
		this.scoreGame = scoreGame;
	}
	public String getScoreTime() {
		return scoreTime;
	}
	public void setScoreTime(String scoreTime) {
		this.scoreTime = scoreTime;
	}
	public String getScoreRecord() {
		return scoreRecord;
	}
	public void setScoreRecord(String scoreRecord) {
		this.scoreRecord = scoreRecord;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
