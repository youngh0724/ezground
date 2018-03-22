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
	//Mapper��� ���ڿ��� ���ȭ(final��)���� �����Ͽ� �ߺ������� ���� �ʵ����ߴ�.
	private final String mapperRoot = "com.ezground.teamproject.team.TeamMapper.";
	
	//�Է°��� ���ϰ��� Ȯ���ϱ����� �ΰű�� ���
	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
	
	public List<Team> teamSelectList(){
		logger.debug("teamSelectList() ����Ȯ��");
		//mapper�� id�� selectMovieList�� �������� �����Ű�� ������� �����Ѵ�.		
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectList");
	}
	
	public List<Team> teamSelectPage(Map map) {
		logger.debug("teamSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectPage", map);
	}
	
	public int teamSelectTotalCount() {
		logger.debug("totalCount() ����Ȯ��"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectCount");	
	}

}
