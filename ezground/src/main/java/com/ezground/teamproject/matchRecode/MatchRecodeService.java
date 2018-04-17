package com.ezground.teamproject.matchRecode;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchRecodeService {

	@Autowired
	private MatchRecodeDao matchRecodeDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecodeService.class);
	
	public Map<String, Object> matchRecodeSelectList(int memberNo, Date reservationDay){
		
		int facilityNo = matchRecodeDao.facilityNoSelectOne(memberNo)
		
		
		
		Map<String, Object> map = matchRecodeDao.matchRecodeSelectList();
		
	}
		
}
