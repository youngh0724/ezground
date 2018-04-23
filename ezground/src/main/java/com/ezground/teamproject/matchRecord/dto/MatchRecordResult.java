package com.ezground.teamproject.matchRecord.dto;

public class MatchRecordResult {

	private String vsTeamName;
	private String score;
	private String winLose;
	
	
	@Override
	public String toString() {
		return "MatchRecordResult [vsTeamName=" + vsTeamName + ", score=" + score + ", winLose=" + winLose + "]";
	}
	public String getVsTeamName() {
		return vsTeamName;
	}
	public void setVsTeamName(String vsTeamName) {
		this.vsTeamName = vsTeamName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getWinLose() {
		return winLose;
	}
	public void setWinLose(String winLose) {
		this.winLose = winLose;
	}	
}
