package com.ezground.teamproject.matchRecode.dto;

import java.util.Date;

public class MatchScoreRecode {
	
	private int scoreNo;
	private int reservationNo;
	private int matchNoticeNo;
	private int sportEntriesNo;
	private int teamNo;
	private int matchJoinMemberNo;
	private String scoreSet;
	private String scoreGame;
	private String scoreTime;
	private String scoreRecode;
	private int writeMemberNo;
	private Date scoreWriteTime;
	
	
	@Override
	public String toString() {
		return "MatchScoreRecode [scoreNo=" + scoreNo + ", reservationNo=" + reservationNo + ", matchNoticeNo="
				+ matchNoticeNo + ", sportEntriesNo=" + sportEntriesNo + ", teamNo=" + teamNo + ", matchJoinMemberNo="
				+ matchJoinMemberNo + ", scoreSet=" + scoreSet + ", scoreGame=" + scoreGame + ", scoreTime=" + scoreTime
				+ ", scoreRecode=" + scoreRecode + ", writeMemberNo=" + writeMemberNo + ", scoreWriteTime="
				+ scoreWriteTime + "]";
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
	public int getSportEntriesNo() {
		return sportEntriesNo;
	}
	public void setSportEntriesNo(int sportEntriesNo) {
		this.sportEntriesNo = sportEntriesNo;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public int getMatchJoinMemberNo() {
		return matchJoinMemberNo;
	}
	public void setMatchJoinMemberNo(int matchJoinMemberNo) {
		this.matchJoinMemberNo = matchJoinMemberNo;
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
	public String getScoreRecode() {
		return scoreRecode;
	}
	public void setScoreRecode(String scoreRecode) {
		this.scoreRecode = scoreRecode;
	}
	public int getWriteMemberNo() {
		return writeMemberNo;
	}
	public void setWriteMemberNo(int writeMemberNo) {
		this.writeMemberNo = writeMemberNo;
	}
	public Date getScoreWriteTime() {
		return scoreWriteTime;
	}
	public void setScoreWriteTime(Date scoreWriteTime) {
		this.scoreWriteTime = scoreWriteTime;
	}
}
