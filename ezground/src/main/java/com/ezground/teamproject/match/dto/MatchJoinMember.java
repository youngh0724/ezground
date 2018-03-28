package com.ezground.teamproject.match.dto;

import org.springframework.stereotype.Repository;

@Repository
public class MatchJoinMember {
	
	private int matchNoticeNo;
	private int memberNo;
	private int teamNo;
	private String homeAway;
		
	public MatchJoinMember() {
		super();
	}
	public MatchJoinMember(int matchNoticeNo, int memberNo, int teamNo, String homeAway) {
		super();
		this.matchNoticeNo = matchNoticeNo;
		this.memberNo = memberNo;
		this.teamNo = teamNo;
		this.homeAway = homeAway;
	}
	@Override
	public String toString() {
		return "MatchJoinMember [matchNoticeNo=" + matchNoticeNo + ", memberNo=" + memberNo + ", teamNo=" + teamNo
				+ ", homeAway=" + homeAway + "]";
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
}
