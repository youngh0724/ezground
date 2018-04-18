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
		
}
