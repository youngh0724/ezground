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
	//Mapper경로 문자열을 상수화(final로)시켜 선언하여 중복적으로 적지 않도록했다.
	private final String mapperRoot = "com.ezground.teamproject.team.TeamMapper.";
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
		
	public List<Team> teamSelectPage(Map map) {
		logger.debug("teamSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectPage", map);
	}
	
	public int teamSelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectCount");	
	}
	
	public Team teamSelectListDetail(int teamNo) {
		logger.debug("teamSelectListDetail() teamNo = {}", teamNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectListDetail", teamNo);
	}
	public int teamInsert(Team team) {
		logger.debug("teamInsert() team = {}", team);
		//team객체를 매개변수로 받아 db에 정보를 입력한다.
		return sqlSessionTemplate.insert(mapperRoot+"teamInsert", team);
	}
	
	//팀 한개를 업데이트 하기위해 한개의 팀을 선택해주는 쿼리문을 실행하는 메서드
	public Team teamSelectOneForUpdate(int teamNo) {
		logger.debug("teamSelectOneForUpdate() teamNo = {}", teamNo);
		//맵퍼에 매개변수와 일치하는 하나의 행을 찾아 team객체타입으로 리턴한다.		
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectOne", teamNo);
	}
	public int teamUpdate(Team team) {
		logger.debug("teamUpdate() team = {}", team);
		//team객체를 매개변수로 받아 db에 정보를 업데이트(수정)한다.
		return sqlSessionTemplate.update(mapperRoot+"teamUpdate", team);
	}
	public int teamDelete(int teamNo) {
		logger.debug("teamDelete() teamNo = {}", teamNo);
		//아이디를 입력받아 db에서 일치하는 정보를 삭제한다. 
		return sqlSessionTemplate.delete(mapperRoot+"teamDelete", teamNo);
	}
	
//팀 삭제를 위한 팀 멤버 우선 삭제
	public int teamDeleteMember(int teamNo) {
		logger.debug("teamDeleteMember() teamNo = {}", teamNo);
		
		return sqlSessionTemplate.delete(mapperRoot+"teamDeleteMember", teamNo);
	}
	//나의 팀 목록 조회
	public List<Team> teamSelectMyTeam(Map map) {
		logger.debug("teamSelectMyTeam() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectMyTeam() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectMyTeam() map.searchWord = {}", map.get("searchWord"));
		logger.debug("teamSelectMyTeam() map.memberNo = {}", map.get("memberNo"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectMyTeam", map);
	}
	//나의 팀 갯수 카운트
	public int myTeamSelectTotalCount(int memberNo) {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"myTeamSelectCount", memberNo);	
	}
	
	
}
