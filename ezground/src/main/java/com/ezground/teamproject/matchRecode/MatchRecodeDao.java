package com.ezground.teamproject.matchRecode;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MatchRecodeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecodeDao.class);
	
	//매퍼 루트를 반복에서 쓰게 되므로 변경불가능한 파이널로 변수 선언하여 방복기록을 피한다.
	private final String mapperRoot = "com.ezground.teamproject.matchRecode.MatchRecodeMapper.";
	
	//매개변수 값과 일치하는 하나의 팀 번호를 조회한다.
	public Integer facilityNoSelectOne(int memberNo) {		
		logger.debug("facilityNoSelectOne() memberNo = {}", memberNo);	
			
		return sqlSessionTemplate.selectOne(mapperRoot+"facilityNoSelectOne", memberNo);
	}
	
	public Map<String, Object> matchRecodeSelectList() {			
			
		return sqlSessionTemplate.selectList(mapperRoot+"facilityNoSelectOne", memberNo);
	}
}
