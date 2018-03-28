package com.ezground.teamproject.teamMember;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.member.dto.MemberLogin;
import com.ezground.teamproject.teamMember.dto.TeamMember;

@Service
@Transactional
public class TeamMemberService {
	
	@Autowired
	private TeamMemberDao teamMemberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamMemberService.class);
	
	public void teamMemberInsert(TeamMember teamMember, HttpSession session) {
		logger.debug("teamMemberInsert() MemberNo = {}", teamMember.getMemberNo());
			
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		teamMember.setMemberNo(memberNo);
		teamMember.setTeamNo(teamMember.getTeamNo());
		teamMember.setTeamMemberLevelNo(teamMember.getTeamMemberLevelNo());
		teamMember.setTeamMemberJoinDate(teamMember.getTeamMemberJoinDate());
		
		teamMemberDao.teamMemberInsert(teamMember);
	}
	
	
}
