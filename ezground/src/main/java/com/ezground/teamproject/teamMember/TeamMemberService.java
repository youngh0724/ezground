package com.ezground.teamproject.teamMember;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.teamMember.dto.TeamMember;

@Service
@Transactional
public class TeamMemberService {
	
	@Autowired
	private TeamMemberDao teamMemberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamMemberService.class);
	
	public void teamMemberInsert(TeamMember teamMember) {
		logger.debug("teamMemberInsert() MemberNo = {}", teamMember.getMemberNo());
		
		teamMember.setMemberNo(teamMember.getMemberNo());
		teamMember.setTeamNo(teamMember.getTeamNo());
		teamMember.setTeamMemberLevelNo(teamMember.getTeamMemberLevelNo());
		teamMember.setTeamMemberJoinDate(teamMember.getTeamMemberJoinDate());
		
		teamMemberDao.teamMemberInsert(teamMember);
	}
	
	
}
