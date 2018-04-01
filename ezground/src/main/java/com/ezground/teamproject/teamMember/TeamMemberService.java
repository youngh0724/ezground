package com.ezground.teamproject.teamMember;

import java.util.HashMap;
import java.util.Map;

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
	
	public void teamMemberInsert(TeamMember teamMember, HttpSession session, int teamNo) {
		logger.debug("teamMemberInsert() MemberNo = {}", teamMember.getMemberNo());
		logger.debug("teamMemberInsert() TeamNo = {}", teamNo);	
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		teamMember.setMemberNo(memberNo);
		teamMember.setTeamNo(teamNo);
		teamMember.setTeamMemberLevelNo(2);		
		
		teamMemberDao.teamMemberInsert(teamMember);
	}
	

	
}
