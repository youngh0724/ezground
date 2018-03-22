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
	
	public List<Team> teamSelectList(){
		logger.debug("teamSelectList() 실행확인");
		//mapper에 id가 selectMovieList인 쿼리문을 실행시키고 결과값을 리턴한다.		
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectList");
	}
	
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

}
