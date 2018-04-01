package com.ezground.teamproject.teamMember;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.team.TeamDao;
import com.ezground.teamproject.team.dto.Team;
import com.ezground.teamproject.teamMember.dto.TeamMember;

@Repository
public class TeamMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "com.ezground.teamproject.teamMember.TeamMemberMapper.";

	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
	
	public int teamMemberInsert(TeamMember teamMember) {
		logger.debug("teamMemberInsert() teamMember = {}", teamMember);
		
		return sqlSessionTemplate.insert(mapperRoot+"teamMemberInsert", teamMember);
	}
	
	//멤버에게 팀 삭제 권한이 있는지 확인하기 위한 조회 기능
	public TeamMember teamMemberSelect(Map map) {
		logger.debug("teamMemberSelect() teamMember = {}", map);		
		return sqlSessionTemplate.selectOne(mapperRoot+"teamMemberSelect", map);
	}
}
