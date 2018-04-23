package com.ezground.teamproject.matchRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezground.teamproject.matchRecord.dto.MatchRecordFieldList;
import com.ezground.teamproject.matchRecord.dto.MatchRecordInfo;
import com.ezground.teamproject.matchRecord.dto.MatchRecordResult;
import com.ezground.teamproject.matchRecord.dto.MatchScoreRecord;
import com.ezground.teamproject.reservation.dto.Reservation;

@Service
public class MatchRecordService {

	@Autowired
	private MatchRecordDao matchRecordDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecordService.class);
	
	public List<MatchRecordFieldList> matchRecordBusinessSelectList(int memberNo, Date reservationDay){
		logger.debug("matchRecordBusinessSelectList() memberNo = {}", memberNo);
		logger.debug("matchRecordBusinessSelectList() reservationDay = {}", reservationDay);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("reservationDay", reservationDay);		
		
		List<MatchRecordFieldList> matchRecodeFieldList = matchRecordDao.matchRecordBusinessSelectList(map);
		logger.debug("matchRecordBusinessSelectList() matchRecodeFieldList = {}", matchRecodeFieldList);
			
		return matchRecodeFieldList;		
	}
	
	//리스트 화면에서 날짜로 검색했을때 
	public List<MatchRecordFieldList> matchRecordBusinessSelectList(int memberNo, String reservationDay){
		logger.debug("matchRecordBusinessSelectList() memberNo = {}", memberNo);
		logger.debug("matchRecordBusinessSelectList() reservationDay = {}", reservationDay);
		
		if(reservationDay.equals("")) {
			reservationDay = null;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("reservationDay", reservationDay);		
		
		List<MatchRecordFieldList> matchRecodeFieldList = matchRecordDao.matchRecordBusinessSelectList(map);
		logger.debug("matchRecordBusinessSelectList() matchRecodeFieldList = {}", matchRecodeFieldList);
			
		return matchRecodeFieldList;		
	}
	
	//진행된 경기의 내용을 기록하기위한 폼화면으로 이동시 필요한 정보를 조회하는 메서드
	public Map<String, Object> matchRecordBusinessInsert(int reservationNo) {
		logger.debug("matchRecodeBusinessInsert() reservationNo = {}", reservationNo);
		
		//예약 번호로 예약 정보 조회
		Reservation reservation = matchRecordDao.reservationSelectOne(reservationNo);
		logger.debug("matchRecodeBusinessInsert() reservation = {}", reservation);
		
		//예약정보중 매치공고번호로 매치참여맴버 리스트조회
		List<MatchRecordInfo> matchJoinMemberList = matchRecordDao.matchJoinMemberSelectList(reservation.getMatchNoticeNo());
		logger.debug("matchRecodeBusinessInsert() matchJoinMemberList = {}", matchJoinMemberList);
		
		List<MatchScoreRecord> MatchScoreRecordList = matchRecordDao.matchScoreRecordSelectList(reservationNo);
		logger.debug("matchRecodeBusinessInsert() MatchScoreRecordList = {}", MatchScoreRecordList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reservation", reservation);
		map.put("matchJoinMemberList", matchJoinMemberList);
		map.put("MatchScoreRecordList", MatchScoreRecordList);
		
		return map; 
		
	}
		
	public int matchRecordBusinessInsert(MatchScoreRecord matchScoreRecord) {
		logger.debug("matchRecodeBusinessInsert() matchScoreRecode = {}", matchScoreRecord);
			
		int row = matchRecordDao.matchRecordBusinessInsert(matchScoreRecord);	
		logger.debug("matchRecodeBusinessInsert() row = {}", row);
		
		return row;
	}
	
	//
	public int matchRecordBusinessDelete(int scoreNo) {
		logger.debug("matchRecordBusinessDelete() scoreNo = {}", scoreNo);
		
		int row = matchRecordDao.matchRecordBusinessDelete(scoreNo);
		logger.debug("matchRecordBusinessDelete() row = {}", row);
		
		return row;
	}
	
	//
	public List<MatchRecordResult> matchRecordResultListSelect(List<Integer> list, int teamNo){
		
		List<MatchRecordResult> resultList = new ArrayList<MatchRecordResult>();
		
		for(int i=0; i < list.size(); i++) {
			List<Integer> teamNoList = matchRecordDao.matchRecordResultListSelect(list.get(i));
			
			int myGoal = 0;
			int yourGoal = 0;
			int yourTeamNo = 0;
			
			for(int j=0; j < teamNoList.size(); j++) {
				if(teamNoList.get(j) == teamNo) {
					myGoal += 1;
				} else {
					yourGoal += 1;	
					yourTeamNo = teamNoList.get(j);
				}
			}
			
			String vsTeamName = matchRecordDao.matchTeamNameSelect(yourTeamNo);
			logger.debug("matchRecordResultListSelect() vsTeamName = {}", vsTeamName);
			
			String score = myGoal + " : "+ yourGoal;
			String winLose = null;
			if(myGoal > yourGoal) {
				winLose = "승";
			} else if(myGoal == yourGoal) {
				winLose = "무";
			} else if(myGoal < yourGoal) {
				winLose = "패";
			}
			MatchRecordResult matchRecordResult = new MatchRecordResult();
			matchRecordResult.setVsTeamName(vsTeamName);
			matchRecordResult.setScore(score);
			matchRecordResult.setWinLose(winLose);
			
			resultList.add(matchRecordResult);
		}
		return resultList;
	}
	
	//
	public Map<String, Object> matchRecordWinLose(List<MatchRecordResult> resultList){
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		int win = 0;
		int lose = 0;
		int draw = 0;
		for(int i=0; i < resultList.size(); i++) {
			if(resultList.get(i).getWinLose().equals("승")) {
				win += 1;
			} else if(resultList.get(i).getWinLose().equals("무")) {
				draw += 1;
			}else if(resultList.get(i).getWinLose().equals("패")) {
				lose += 1;
			}
		}
		
		map.put("record", resultList.size());
		map.put("win", win);
		map.put("lose", lose);
		map.put("draw", draw);	
		
		return map;
	}
	
	
	//팀 전적 조회하는 요청 처리
	public Map<String, Object> matchRecordResultList(int teamNo) {
		logger.debug("matchRecordResultList() teamNo = {}", teamNo);
		
		//팀 번호로 매치결과가 있는 매치번호 리스트를 생성한다.
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("teamNo", teamNo);
		List<Integer> list = matchRecordDao.matchRecordListMatchNoticeNoByTeam(paraMap);
		logger.debug("matchRecordResultList() list = {}", list);
		
		//리스트의  각각의 매치 결과를 판별한다
		List<MatchRecordResult> resultList = matchRecordResultListSelect(list, teamNo);
		logger.debug("matchRecordResultList() resultList = {}", resultList);
		
		//팀번호로 팀이름을 조회한다.
		String myTeamName = matchRecordDao.matchTeamNameSelect(teamNo);
		logger.debug("matchRecordResultList() myTeamName = {}", myTeamName);
		
		//판별된 매치 결과리스트를 전적형태로 변환한다.
		Map<String, Object> map = matchRecordWinLose(resultList);
		map.put("myTeamName", myTeamName);
		
		return map;
	}
	
	//맴버 개인의 전적 조회하는 요청 처리
	public Map<String, Object> matchRecordResultList(int teamNo, int memberNo) {
		logger.debug("matchRecordResultList() teamNo = {}", teamNo);
		logger.debug("matchRecordResultList() memberNo = {}", memberNo);
		
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("teamNo", teamNo);
		paraMap.put("memberNo", memberNo);
		
		//팀 번호로 매치결과가 있는 매치번호 리스트를 생성한다.		
		List<Integer> list = matchRecordDao.matchRecordListMatchNoticeNoByTeam(paraMap);
		logger.debug("matchRecordResultList() list = {}", list);
				
		//리스트의  각각의 매치 결과를 판별한다
		List<MatchRecordResult> resultList = matchRecordResultListSelect(list, teamNo);
		logger.debug("matchRecordResultList() resultList = {}", resultList);
				
		//팀번호로 팀이름을 조회한다.
		String myTeamName = matchRecordDao.matchTeamNameSelect(teamNo);
		logger.debug("matchRecordResultList() myTeamName = {}", myTeamName);
				
		//판별된 매치 결과리스트를 전적형태로 변환한다.
		Map<String, Object> map = matchRecordWinLose(resultList);
		map.put("resultList", resultList);
		
		return map;
	}
}
