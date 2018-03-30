package com.ezground.teamproject.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.match.dto.MatchJoinMember;
import com.ezground.teamproject.match.dto.MatchNotice;
import com.ezground.teamproject.match.dto.MatchNoticeFullcalendarEvent;

@Service
@Transactional
public class MatchService {
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private MatchJoinMember matchJoinMember;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchService.class);
	
	//종목번호와 맴버 번호로 팀 번호 조회
	public int teamNoSelectOne(int sportEntryNo, int memberNo) {		
		logger.debug("teamNoSelectOne() memberNo = {}", memberNo);
		logger.debug("teamNoSelectOne() entryNo = {}", sportEntryNo);
		
		//서로 다른 타입의 정보를 하나의 변수에 저장하기위에 map타입 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sportEntryNo", sportEntryNo);
		map.put("memberNo", memberNo);
		
		//팀 번호를 조회
		int teamNo = matchDao.teamNoSelectOne(map);
		logger.debug("teamNoSelectOne() teamNo = {}", teamNo);	
		
		return teamNo;
	}
	
	//매치 공고 정보를 입력시키는 메서드
	public int matchNoticeInsert(MatchNotice matchNotice, int memberNo, int sportEntryNo) {		
		logger.debug("matchNoticeInsert() matchNotice = {}", matchNotice);
		logger.debug("matchNoticeInsert() memberNo = {}", memberNo);
		logger.debug("matchNoticeInsert() sportEntryNo = {}", sportEntryNo);
		
		//매치 공고를 디비에 입력한다.
		matchDao.matchNoticeInsert(matchNotice);
		
		//입력후 생성된 매치공고번호를 저장한다.
		int matchNoticeNo = matchNotice.getMatchNoticeNo();	
		logger.debug("matchNoticeInsert() matchNoticeNo = {}", matchNoticeNo);
				
		//서로 다른 타입의 정보를 하나의 변수에 저장하기위에 map타입 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sportEntryNo", sportEntryNo);
		map.put("memberNo", memberNo);
				
		
		logger.debug("matchNoticeInsert() sportEntryNo = {}", map.get("sprotEntryNo"));	
		//팀번호와 참가팀을 성정한다.
		int teamNo = matchDao.teamNoSelectOne(map);
		String homeAway = "home";		
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);
		matchJoinMember.setTeamNo(teamNo);
		matchJoinMember.setMemberNo(memberNo);
		matchJoinMember.setHomeAway(homeAway);
		
		//매치공고 입력후 매치참가 홈팀에 참가신청을 한다.
		matchDao.matchJoinMemberInsert(matchJoinMember);
		
		return matchNoticeNo;
	}
	
	//매치 종류(팀전 or 자유)선택 혹은 미선택시 매치공고정보 리스트 조회 요청 처리
	public List<MatchNotice> matchSelectList(int sprotEntryNo, String matchKindsSearchWord){
		logger.debug("matchSelectList() matchKindsSearchWord = {}", matchKindsSearchWord);
		
		//두 매개변수를 하나의 변수(map타입)에 세팅한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sprotEntryNo", sprotEntryNo);
		map.put("matchKindsSearchWord", matchKindsSearchWord);		
		
		//matchKindsSearchWord를 dao에 넘기고 매치공고 리스트를 받아온다.
		List<MatchNotice> list = matchDao.matchSelectList(map);
		
		return list;
	}
	
	//매치 번호와 일치하는 매치공고 정보를 조회힌다.
	public MatchNotice matchSelectOne(int matchNoticeNo) {
		logger.debug("matchSelectOne() matchNoticeNo = {}", matchNoticeNo);
		
		//매치 번호와 일치하는 매치공고 정보를 조회하여 저장한다.
		MatchNotice matchNotice = matchDao.matchSelectOne(matchNoticeNo);
		logger.debug("matchSelectOne() matchNotice = {}", matchNotice);
		
		return matchNotice;	
	}
	
	//매치 번호와 팀에 일치하는 매치 참가 맴버 리스트를 조회한다.
	public List<String> matchJoinMemberSelectList(int matchNoticeNo, String homeAway) {
		logger.debug("matchJoinMemberSelectList() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberSelectList() homeAway = {}", homeAway);
				
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);	
		matchJoinMember.setHomeAway(homeAway);
		
		//매치에 참가신청된 한쪽 팀 맴버 리스트를 조회한다.
		List<String> list = matchDao.matchJoinMemberSelectList(matchJoinMember);
		logger.debug("matchJoinMemberSelectList() list = {}", list);
		
		return list;
	}
	
	//home팀의 팀 번호를 조회하는 메서드
	public int matchNoticeSelectHomeAway(int matchNoticeNo) {
		logger.debug("matchNoticeSelectHomeAway() matchNoticeNo = {}", matchNoticeNo);
		
		int teamNo = matchDao.matchNoticeSelectHomeAway(matchNoticeNo);
		logger.debug("matchNoticeSelectHomeAway() teamNo = {}", teamNo);
		
		return teamNo;
	}
	
	//매치 에 맴버 참가 신청을 한다.(디비에 입력)
	public void matchJoinMemberInsert(int matchNoticeNo, int memberNo, int myTeamNo, String homeAway) {
		logger.debug("matchJoinMemberInsert() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberInsert() memberNo = {}", memberNo);
		logger.debug("matchJoinMemberInsert() myTeamNo = {}", myTeamNo);
		logger.debug("matchJoinMemberInsert() homeAway = {}", homeAway);
		
		//매개변수로 넘겨받은 값을 세팅한다.
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);
		matchJoinMember.setTeamNo(myTeamNo);
		matchJoinMember.setMemberNo(memberNo);
		matchJoinMember.setHomeAway(homeAway);
		
		//매치에 맴버참가 신청을 한다.
		matchDao.matchJoinMemberInsert(matchJoinMember);
		
	}
	
	//매치 종류(팀전 or 자유)선택 혹은 미선택시 매치공고정보 리스트 조회 요청 처리
		public List<MatchNoticeFullcalendarEvent> matchSelectListfullcalendar(int sprotEntryNo, String matchKindsSearchWord){
			logger.debug("matchSelectListfullcalendar() matchKindsSearchWord = {}", matchKindsSearchWord);
			
			//두 매개변수를 하나의 변수(map타입)에 세팅한다.
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sprotEntryNo", sprotEntryNo);
			map.put("matchKindsSearchWord", matchKindsSearchWord);		
			
			//matchKindsSearchWord를 dao에 넘기고 매치공고 리스트를 받아온다.
			List<MatchNoticeFullcalendarEvent> list = matchDao.matchSelectListfullcalendar(map);
			logger.debug("matchSelectListfullcalendar() list = {}", list);
			
			for(int i = 0; i < list.size(); i++) {
			
				list.get(i).setUrl("${pageContext.request.contextPath}/match/matchNoticeInfomation?matchNoticeNo="+list.get(i).getId());
								
			}		
			
			return list;
		}
	
}
