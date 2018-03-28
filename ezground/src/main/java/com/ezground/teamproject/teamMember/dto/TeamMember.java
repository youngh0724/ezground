package com.ezground.teamproject.teamMember.dto;

import java.util.Date;

public class TeamMember {
	private int teamMemberNo;
	private int teamNo;
	private int memberNo;
	private int teamMemberLevelNo;
	private Date teamMemberJoinDate;
	private Date teamMemberDropDate;
	public int getTeamMemberNo() {
		return teamMemberNo;
	}
	public void setTeamMemberNo(int teamMemberNo) {
		this.teamMemberNo = teamMemberNo;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getTeamMemberLevelNo() {
		return teamMemberLevelNo;
	}
	public void setTeamMemberLevelNo(int teamMemberLevelNo) {
		this.teamMemberLevelNo = teamMemberLevelNo;
	}
	public Date getTeamMemberJoinDate() {
		return teamMemberJoinDate;
	}
	public void setTeamMemberJoinDate(Date teamMemberJoinDate) {
		this.teamMemberJoinDate = teamMemberJoinDate;
	}
	public Date getTeamMemberDropDate() {
		return teamMemberDropDate;
	}
	public void setTeamMemberDropDate(Date teamMemberDropDate) {
		this.teamMemberDropDate = teamMemberDropDate;
	}
	@Override
	public String toString() {
		return "TeamMember [teamMemberNo=" + teamMemberNo + ", teamNo=" + teamNo + ", memberNo=" + memberNo
				+ ", teamMemberLevelNo=" + teamMemberLevelNo + ", teamMemberJoinDate=" + teamMemberJoinDate
				+ ", teamMemberDropDate=" + teamMemberDropDate + "]";
	}
	
}