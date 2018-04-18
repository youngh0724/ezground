package com.ezground.teamproject.team;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.team.dto.Team;

@Repository
public class TeamDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private final String mapperRoot = "com.ezground.teamproject.team.TeamMapper.";
	
	
	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
		
	public List<Team> teamSelectListByPage(Map map) {
		logger.debug("teamSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectPage", map);
	}
	
	public int teamSelectTotalCount() {
		logger.debug("totalCount() ����Ȯ��"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectCount");	
	}
	
	public Team teamSelectListDetail(int teamNo) {
		logger.debug("teamSelectListDetail() teamNo = {}", teamNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectListDetail", teamNo);
	}
	public int teamInsert(Team team) {
		logger.debug("teamInsert() team = {}", team);
		
		return sqlSessionTemplate.insert(mapperRoot+"teamInsert", team);
	}
	

	public Team teamSelectOneForUpdate(int teamNo) {
		logger.debug("teamSelectOneForUpdate() teamNo = {}", teamNo);
				
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectOne", teamNo);
	}
	public int teamUpdate(Team team) {
		logger.debug("teamUpdate() team = {}", team);
		
		return sqlSessionTemplate.update(mapperRoot+"teamUpdate", team);
	}
	public int teamDelete(int teamNo) {
		logger.debug("teamDelete() teamNo = {}", teamNo);
		
		return sqlSessionTemplate.delete(mapperRoot+"teamDelete", teamNo);
	}
	

	public int teamDeleteMember(int teamNo) {
		logger.debug("teamDeleteMember() teamNo = {}", teamNo);
		
		return sqlSessionTemplate.delete(mapperRoot+"teamDeleteMember", teamNo);
	}
	
	public List<Team> teamSelectMyTeam(Map map) {
		logger.debug("teamSelectMyTeam() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectMyTeam() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectMyTeam() map.searchWord = {}", map.get("searchWord"));
		logger.debug("teamSelectMyTeam() map.memberNo = {}", map.get("memberNo"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectMyTeam", map);
	}
	
	public int myTeamSelectTotalCount(int memberNo) {
		
		return sqlSessionTemplate.selectOne(mapperRoot+"myTeamSelectCount", memberNo);	
	}
	
	
}