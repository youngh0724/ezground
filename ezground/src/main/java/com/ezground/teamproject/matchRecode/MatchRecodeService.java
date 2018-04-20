package com.ezground.teamproject.matchRecode;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezground.teamproject.matchRecode.dto.MatchRecodeFieldList;
import com.ezground.teamproject.matchRecode.dto.MatchRecodeInfo;
import com.ezground.teamproject.reservation.dto.Reservation;

@Service
public class MatchRecodeService {

	@Autowired
	private MatchRecodeDao matchRecodeDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecodeService.class);
	
	public List<MatchRecodeFieldList> matchRecodeBusinessSelectList(int memberNo, Date reservationDay){
		logger.debug("matchRecodeBusinessSelectList() memberNo = {}", memberNo);
		logger.debug("matchRecodeBusinessSelectList() reservationDay = {}", reservationDay);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("reservationDay", reservationDay);		
		
		List<MatchRecodeFieldList> matchRecodeFieldList = matchRecodeDao.matchRecodeBusinessSelectList(map);
		logger.debug("matchRecodeBusinessSelectList() matchRecodeFieldList = {}", matchRecodeFieldList);
			
		return matchRecodeFieldList;		
	}
	
	//리스트 화면에서 날짜로 검색했을때 
	public List<MatchRecodeFieldList> matchRecodeBusinessSelectList(int memberNo, String reservationDay){
		logger.debug("matchRecodeBusinessSelectList() memberNo = {}", memberNo);
		logger.debug("matchRecodeBusinessSelectList() reservationDay = {}", reservationDay);
		
		if(reservationDay.equals("")) {
			reservationDay = null;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("reservationDay", reservationDay);		
		
		List<MatchRecodeFieldList> matchRecodeFieldList = matchRecodeDao.matchRecodeBusinessSelectList(map);
		logger.debug("matchRecodeBusinessSelectList() matchRecodeFieldList = {}", matchRecodeFieldList);
			
		return matchRecodeFieldList;		
	}
	
	//진행된 경기의 내용을 기록하기위한 폼화면으로 이동시 필요한 정보를 조회하는 메서드
	public Map<String, Object> matchRecodeBusinessInsert(int reservationNo) {
		logger.debug("matchRecodeBusinessInsert() reservationNo = {}", reservationNo);
		
		//예약 번호로 예약 정보 조회
		Reservation reservation = matchRecodeDao.reservationSelectOne(reservationNo);
		logger.debug("matchRecodeBusinessInsert() reservation = {}", reservation);
		
		//예약정보중 매치공고번호로 매치참여맴버 리스트조회
		List<MatchRecodeInfo> matchJoinMemberList = matchRecodeDao.matchJoinMemberSelectList(reservation.getMatchNoticeNo());
		logger.debug("matchRecodeBusinessInsert() matchJoinMemberList = {}", matchJoinMemberList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reservation", reservation);
		map.put("matchJoinMemberList", matchJoinMemberList);
		
		return map; 
		
	}
		
}
