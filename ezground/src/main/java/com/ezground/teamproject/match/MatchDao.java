package com.ezground.teamproject.match;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.match.dto.MatchNotice;

@Repository
public class MatchDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchDao.class);
	
	private final String mapperRoot = "com.ezground.teamproject.match.MatchMapper.";
	
	public int teamNoSelectOne(Map map) {
		
		logger.debug("teamNoSelectOne() entryNo = {}", map.get("entryNo"));	
		
		return sqlSessionTemplate.selectOne(mapperRoot+"teamNoSelectOne", map);
	}
	
	public int matchNoticeInsert(MatchNotice matchNotice) {
		
		return sqlSessionTemplate.insert(mapperRoot+"matchNoticeInsert", matchNotice);
		
	}
	
	public int matchJoinMemberInsertHomeTeam(Map map) {
		
		return sqlSessionTemplate.insert(mapperRoot+"matchJoinMemberInsertHomeTeam", map);
		
	}
	

}
