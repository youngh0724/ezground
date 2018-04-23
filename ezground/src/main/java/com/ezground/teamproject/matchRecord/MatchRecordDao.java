package com.ezground.teamproject.matchRecord;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.matchRecord.dto.MatchRecordFieldList;
import com.ezground.teamproject.matchRecord.dto.MatchRecordInfo;
import com.ezground.teamproject.matchRecord.dto.MatchScoreRecord;
import com.ezground.teamproject.reservation.dto.Reservation;


@Repository
public class MatchRecordDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecordDao.class);
	
	//매퍼 루트를 반복에서 쓰게 되므로 변경불가능한 파이널로 변수 선언하여 방복기록을 피한다.
	private final String mapperRoot = "com.ezground.teamproject.matchRecord.MatchRecordMapper.";
	
	//매개변수 값과 일치하는 하나의 팀 번호를 조회한다.
	public List<MatchRecordFieldList> matchRecordBusinessSelectList(Map<String, Object> map) {		
		logger.debug("matchRecordBusinessSelectList() map = {}", map);	
			
		return sqlSessionTemplate.selectList(mapperRoot+"matchRecordBusinessSelectList", map);
	}
	
	//예약 번호로 매치공고번호를 조회한다.
	public Reservation reservationSelectOne(int reservationNo) {
		logger.debug("matchNoticeSelectOne() reservationNo = {}", reservationNo);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"reservationSelectOne", reservationNo);
	}
	
	public List<MatchRecordInfo> matchJoinMemberSelectList(int matchNoticeNo){
		logger.debug("matchJoinMemberSelectList() matchNoticeNo = {}", matchNoticeNo);
		
		return sqlSessionTemplate.selectList(mapperRoot+"matchJoinMemberSelectList", matchNoticeNo);
	}
	
	public int matchRecordBusinessInsert(MatchScoreRecord matchScoreRecord) {
		logger.debug("matchRecordBusinessInsert() matchScoreRecode = {}", matchScoreRecord);
		
		return sqlSessionTemplate.insert(mapperRoot+"matchRecordBusinessInsert", matchScoreRecord);	
	}
	
	public List<MatchScoreRecord> matchScoreRecordSelectList(int reservationNo){
		logger.debug("matchScoreRecordSelectList() reservationNo = {}", reservationNo);
		
		return sqlSessionTemplate.selectList(mapperRoot+"matchScoreRecordSelectList", reservationNo);
	}
	
	public int matchRecordBusinessDelete(int scoreNo) {
		logger.debug("matchRecordBusinessDelete() scoreNo = {}", scoreNo);
		
		return sqlSessionTemplate.delete(mapperRoot+"matchRecordBusinessDelete", scoreNo);
	}
	
	public List<Integer> matchRecordListMatchNoticeNoByTeam(Map<String, Object> map){
		logger.debug("matchRecordListMatchNoticeNoByTeam() map = {}", map);
		
		return sqlSessionTemplate.selectList(mapperRoot+"matchRecordListMatchNoticeNoByTeam", map);
	}
	
	public List<Integer> matchRecordResultListSelect(int matchNoticeNo){
		logger.debug("matchRecordResultListSelect() matchNoticeNo = {}", matchNoticeNo);
		
		return sqlSessionTemplate.selectList(mapperRoot+"matchRecordListTeamNo", matchNoticeNo);
	}
	
	public String matchTeamNameSelect(int yourTeamNo) {
		logger.debug("matchTeamNameSelect() yourTeamNo = {}", yourTeamNo);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"matchTeamNameSelect", yourTeamNo);
	}

}
