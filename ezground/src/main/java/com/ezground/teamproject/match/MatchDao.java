package com.ezground.teamproject.match;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.match.dto.MatchJoinMember;
import com.ezground.teamproject.match.dto.MatchNotice;
import com.ezground.teamproject.match.dto.MatchNoticeAndMatchJoinMember;
import com.ezground.teamproject.match.dto.MatchNoticeFullcalendarEvent;
import com.ezground.teamproject.member.dto.MemberLogin;

@Repository
public class MatchDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchDao.class);
	
	//매퍼 루트를 반복에서 쓰게 되므로 변경불가능한 파이널로 변수 선언하여 방복기록을 피한다.
	private final String mapperRoot = "com.ezground.teamproject.match.MatchMapper.";
	
	//매개변수 값과 일치하는 하나의 팀 번호를 조회한다.
	public Integer teamNoSelectOne(Map<String, Object> map) {		
		logger.debug("teamNoSelectOne() sportEntryNo = {}", map.get("sportEntriesNo"));	
		
		return sqlSessionTemplate.selectOne(mapperRoot+"teamNoSelectOne", map);
	}
	
	//매치공고 정보를 입력한다.
	public int matchNoticeInsert(MatchNotice matchNotice) {
		logger.debug("matchNoticeInsert() matchNotice = {}", matchNotice);	
		
		return sqlSessionTemplate.insert(mapperRoot+"matchNoticeInsert", matchNotice);		
	}
	
	//매치에 맴버 참가 신청(입력)을 한다.
	public int matchJoinMemberInsert(MatchJoinMember matchJoinMember) {
		logger.debug("matchJoinMemberInsert() matchJoinMember = {}", matchJoinMember);	
		
		return sqlSessionTemplate.insert(mapperRoot+"matchJoinMemberInsert", matchJoinMember);		
	}
	
	//매치공고 리스트를 조회한다.(매개변수에따라 매치종류에따른 조회기능)
	public List<MatchNotice> matchSelectList(MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember){
		logger.debug("matchSelectList() matchNoticeAndMatchJoinMember = {}", matchNoticeAndMatchJoinMember);
				
		return sqlSessionTemplate.selectList(mapperRoot+"matchSelectList", matchNoticeAndMatchJoinMember);
	}
	
	//하나의 매치공고 정보를 조회한다.
	public MatchNotice matchSelectOne(int matchNoticeNo) {
		logger.debug("matchSelectOne() matchNoticeNo = {}", matchNoticeNo);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"matchSelectOne", matchNoticeNo);		
	}
	
	//매치참가 맴버의 아이디 리스트를 조회한다.
	public List<MemberLogin> matchJoinMemberSelectList(MatchJoinMember matchJoinMember) {
		logger.debug("matchJoinMemberSelectList() matchJoinMember = {}", matchJoinMember);
		
		return sqlSessionTemplate.selectList(mapperRoot+"matchJoinMemberSelectList", matchJoinMember);
	}
	
	//매치에서 home팀의 팀번호를 조회한다.
	public int matchNoticeSelectHomeAway(int matchNoticeNo) {
		logger.debug("matchNoticeSelectHomeAway() matchNoticeNo = {}", matchNoticeNo);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"matchNoticeSelectHomeAway", matchNoticeNo);
	}
	
	//매치공고 리스트를 조회한다.(매개변수에따라 매치종류에따른 조회기능)
	public List<MatchNoticeFullcalendarEvent> matchSelectListfullcalendar(Map<String, Object> map){
		logger.debug("matchSelectList() matchKindsSearchWord = {}", map.get("matchKindsSearchWord"));

		return sqlSessionTemplate.selectList(mapperRoot+"matchSelectListfullcalendar", map);
	}
	
	//매치에 참가중인 맴버인지 조회하는 메서드
	public MatchJoinMember isMatchJoinMember(Map<String, Object> map) {
		logger.debug("isMatchJoinMember() matchNoticeNo = {}", map.get("matchNoticeNo"));
		
		return sqlSessionTemplate.selectOne(mapperRoot+"isMatchJoinMember", map);
	}
	
	//매치에 참가 취소하는 메서드
	public Integer matchJoinMemberDelete(Map<String, Object> map) {
		logger.debug("matchJoinMemberDelete() matchNoticeNo = {}", map.get("matchNoticeNo"));
		
		return sqlSessionTemplate.delete(mapperRoot+"matchJoinMemberDelete", map);
	}
	
	// 매치 공고 정보를 다른팀이 검색할수 있도록 상태값을 바꾸는 메서드
	public int matchNoticeNotice(int matchNoticeNo) {
		logger.debug("matchNoticeNotice() matchNoticeNo = {}", matchNoticeNo);
		
		return sqlSessionTemplate.update(mapperRoot+"matchNoticeNotice", matchNoticeNo);		
	}
	
	// 매치 공고 정보를 매치 완료로  상태값을 바꾸는 메서드
	public int matchNoticePermit(int matchNoticeNo) {
		logger.debug("matchNoticePermit() matchNoticeNo = {}", matchNoticeNo);

		return sqlSessionTemplate.update(mapperRoot + "matchNoticePermit", matchNoticeNo);
	}
	
	//원정팀 신청 맴버의 상태값을 바꾸는 매서드
	public int matchRequestHomeTeam(MatchJoinMember matchJoinMember) {
		logger.debug("matchRequestHomeTeam() matchJoinMember = {}", matchJoinMember);
		
		return sqlSessionTemplate.update(mapperRoot+"matchRequestHomeTeam", matchJoinMember);
	}
	
	//
	public int matchRequestedAwayTeamNo(MatchJoinMember matchJoinMember) {
		logger.debug("matchRequestedAwayTeamNo() matchJoinMember = {}", matchJoinMember);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"matchRequestedAwayTeamNo", matchJoinMember);
	}
	
}
