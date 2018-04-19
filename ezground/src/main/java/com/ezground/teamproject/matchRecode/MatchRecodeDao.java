package com.ezground.teamproject.matchRecode;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.match.dto.MatchJoinMember;
import com.ezground.teamproject.matchRecode.dto.MatchRecodeFieldList;
import com.ezground.teamproject.reservation.dto.Reservation;


@Repository
public class MatchRecodeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecodeDao.class);
	
	//매퍼 루트를 반복에서 쓰게 되므로 변경불가능한 파이널로 변수 선언하여 방복기록을 피한다.
	private final String mapperRoot = "com.ezground.teamproject.matchRecode.MatchRecodeMapper.";
	
	//매개변수 값과 일치하는 하나의 팀 번호를 조회한다.
	public List<MatchRecodeFieldList> matchRecodeBusinessSelectList(Map<String, Object> map) {		
		logger.debug("matchRecodeBusinessSelectList() map = {}", map);	
			
		return sqlSessionTemplate.selectList(mapperRoot+"matchRecodeBusinessSelectList", map);
	}
	
	//예약 번호로 매치공고번호를 조회한다.
	public Reservation matchNoticeSelectOne(int reservationNo) {
		logger.debug("matchNoticeSelectOne() reservationNo = {}", reservationNo);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"matchNoticeSelectOne", reservationNo);
	}
	
	public List<MatchJoinMember> matchJoinMemberSelectList(int matchNoticeNo){
		logger.debug("matchJoinMemberSelectList() matchNoticeNo = {}", matchNoticeNo);
		
		return sqlSessionTemplate.selectList(mapperRoot+"matchJoinMemberSelectList", matchNoticeNo);
	}
	

}
