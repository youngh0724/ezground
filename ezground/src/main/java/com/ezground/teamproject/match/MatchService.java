package com.ezground.teamproject.match;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.match.dto.MatchNotice;

@Service
@Transactional
public class MatchService {
	
	@Autowired
	private MatchDao matchDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchService.class);
	
	public int teamNoSelectOne(int entryNo, int memberNo) {
		
		logger.debug("teamNoSelectOne() memberNo = {}", memberNo);
		logger.debug("teamNoSelectOne() entryNo = {}", entryNo);
		
		Map map = new HashMap();
		map.put("entryNo", entryNo);
		map.put("memberNo", memberNo);
		
		int teamNo = matchDao.teamNoSelectOne(map);
				
		return teamNo;
	}
	
	public void matchNoticeInsert(MatchNotice matchNotice, int memberNo) {
		
		matchDao.matchNoticeInsert(matchNotice);
		
		int generatedMatchNoticeNo = matchNotice.getMatchNoticeNo();		
		int teamNo = matchNotice.getTeamNo();
		String homeAway = "home";
		Map map = new HashMap();
		map.put("generatedMatchNoticeNo", generatedMatchNoticeNo);
		map.put("teamNo", teamNo);
		map.put("memberNo", memberNo);
		map.put("homeAway", homeAway);
		
		matchDao.matchJoinMemberInsertHomeTeam(map);
		
	}

}
