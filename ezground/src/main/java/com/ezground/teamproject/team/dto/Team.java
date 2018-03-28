package com.ezground.teamproject.team.dto;

import java.util.Date;

public class Team {
	private int teamNo;
	private int sportEntriesNo;
	private String teamName;
	private String teamRegion;
	private String teamAges;
	private String teamLevel;
	private String teamIntro;
	private int teamWin;
	private int teamDraw;
	private int teamLose;
	private int teamVictoryPoint;
	private int teamGameCount;
	private Date teamCreatedDate;
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public int getSportEntriesNo() {
		return sportEntriesNo;
	}
	public void setSportEntriesNo(int sportEntriesNo) {
		this.sportEntriesNo = sportEntriesNo;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamRegion() {
		return teamRegion;
	}
	public void setTeamRegion(String teamRegion) {
		this.teamRegion = teamRegion;
	}
	public String getTeamAges() {
		return teamAges;
	}
	public void setTeamAges(String teamAges) {
		this.teamAges = teamAges;
	}
	public String getTeamLevel() {
		return teamLevel;
	}
	public void setTeamLevel(String teamLevel) {
		this.teamLevel = teamLevel;
	}
	public String getTeamIntro() {
		return teamIntro;
	}
	public void setTeamIntro(String teamIntro) {
		this.teamIntro = teamIntro;
	}
	public int getTeamWin() {
		return teamWin;
	}
	public void setTeamWin(int teamWin) {
		this.teamWin = teamWin;
	}
	public int getTeamDraw() {
		return teamDraw;
	}
	public void setTeamDraw(int teamDraw) {
		this.teamDraw = teamDraw;
	}
	public int getTeamLose() {
		return teamLose;
	}
	public void setTeamLose(int teamLose) {
		this.teamLose = teamLose;
	}
	public int getTeamVictoryPoint() {
		return teamVictoryPoint;
	}
	public void setTeamVictoryPoint(int teamVictoryPoint) {
		this.teamVictoryPoint = teamVictoryPoint;
	}
	public int getTeamGameCount() {
		return teamGameCount;
	}
	public void setTeamGameCount(int teamGameCount) {
		this.teamGameCount = teamGameCount;
	}
	public Date getTeamCreatedDate() {
		return teamCreatedDate;
	}
	public void setTeamCreatedDate(Date teamCreatedDate) {
		this.teamCreatedDate = teamCreatedDate;
	}
	@Override
	public String toString() {
		return "Team [teamNo=" + teamNo + ", sportEntriesNo=" + sportEntriesNo + ", teamName=" + teamName
				+ ", teamRegion=" + teamRegion + ", teamAges=" + teamAges + ", teamLevel=" + teamLevel + ", teamIntro="
				+ teamIntro + ", teamWin=" + teamWin + ", teamDraw=" + teamDraw + ", teamLose=" + teamLose
				+ ", teamVictoryPoint=" + teamVictoryPoint + ", teamGameCount=" + teamGameCount + ", teamCreatedDate="
				+ teamCreatedDate + "]";
	}
	

}
