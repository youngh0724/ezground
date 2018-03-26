package com.ezground.teamproject.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.match.dto.MatchJoinMember;
import com.ezground.teamproject.match.dto.MatchNotice;

@Service
@Transactional
public class MatchService {
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private MatchJoinMember matchJoinMember;
	
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
	
	public int matchNoticeInsert(MatchNotice matchNotice, int memberNo) {
		
		matchDao.matchNoticeInsert(matchNotice);
		
		int matchNoticeNo = matchNotice.getMatchNoticeNo();		
		int teamNo = matchNotice.getTeamNo();
		String homeAway = "home";
		
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);
		matchJoinMember.setTeamNo(teamNo);
		matchJoinMember.setMemberNo(memberNo);
		matchJoinMember.setHomeAway(homeAway);
				
		matchDao.matchJoinMemberInsertHomeTeam(matchJoinMember);
		
		return matchNoticeNo;
	}
	
	public List<MatchNotice> matchSelectList(String searchWord){
		
		List<MatchNotice> list = matchDao.matchSelectList(searchWord);
		
		return list;
	}
	
	public MatchNotice matchSelectOne(int matchNoticeNo) {
		
		MatchNotice matchNotice = matchDao.matchSelectOne(matchNoticeNo);
		
		return matchNotice;	
	}
	
	public List<String> matchJoinMemberList(int matchNoticeNo, String homeAway) {
				
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);	
		matchJoinMember.setHomeAway(homeAway);
		
		List<String> list = matchDao.matchJoinMemberList(matchJoinMember);
		
		return list;
	}

	public int matchNoticeSelectHomeAway(int matchNoticeNo) {
		
		int teamNo = matchDao.matchNoticeSelectHomeAway(matchNoticeNo);
			
		return teamNo;
	}
	
	public void matchJoinMemberInsert(int matchNoticeNo, int memberNo, int myTeamNo, String homeAway) {
	
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);
		matchJoinMember.setTeamNo(myTeamNo);
		matchJoinMember.setMemberNo(memberNo);
		matchJoinMember.setHomeAway(homeAway);
		
		matchDao.matchJoinMemberInsertHomeTeam(matchJoinMember);
		
	}
	
}
