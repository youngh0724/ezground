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
import com.ezground.teamproject.match.dto.MatchNoticeAndMatchJoinMember;
import com.ezground.teamproject.match.dto.MatchNoticeFullcalendarEvent;
import com.ezground.teamproject.member.dto.MemberLogin;

@Service
@Transactional
public class MatchService {
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private MatchJoinMember matchJoinMember;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchService.class);
	
	//종목번호와 맴버 번호로 팀 번호 조회
	public Integer teamNoSelectOne(int sportEntriesNo, int memberNo) {		
		logger.debug("teamNoSelectOne() memberNo = {}", memberNo);
		logger.debug("teamNoSelectOne() entryNo = {}", sportEntriesNo);
		
		//서로 다른 타입의 정보를 하나의 변수에 저장하기위에 map타입 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sportEntriesNo", sportEntriesNo);
		map.put("memberNo", memberNo);
		
		//팀 번호를 조회
		Integer teamNo = matchDao.teamNoSelectOne(map);
		logger.debug("teamNoSelectOne() teamNo = {}", teamNo);	
		
		return teamNo;
	}
	
	//매치 공고 정보를 입력시키는 메서드
	public int matchNoticeInsert(MatchNotice matchNotice, int memberNo, int sportEntryNo) {		
		logger.debug("matchNoticeInsert() matchNotice = {}", matchNotice);
		logger.debug("matchNoticeInsert() memberNo = {}", memberNo);
		logger.debug("matchNoticeInsert() sportEntryNo = {}", sportEntryNo);
		
		//입력받은 매치종류가 팀전인지 자유인지 비교하여 상태값 세팅
		if(matchNotice.getMatchKinds().equals("free")) {
			matchNotice.setMatchNoticeStatus("awayTeamWating");
		} else if(matchNotice.getMatchKinds().equals("team")) {
			matchNotice.setMatchNoticeStatus("homeTeamWating");
		}
		matchNotice.setMemberNo(memberNo);
		matchNotice.setSportEntriesNo(sportEntryNo);
		
		//매치 공고를 디비에 입력한다.
		matchDao.matchNoticeInsert(matchNotice);
		
		//입력후 생성된 매치공고번호를 저장한다.
		int matchNoticeNo = matchNotice.getMatchNoticeNo();	
		logger.debug("matchNoticeInsert() matchNoticeNo = {}", matchNoticeNo);
				
		//서로 다른 타입의 정보를 하나의 변수에 저장하기위에 map타입 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sportEntriesNo", sportEntryNo);
		map.put("memberNo", memberNo);
		
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
	public List<MatchNotice> matchSelectList(MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember){
		logger.debug("matchSelectList() MatchExpectedDay = {}", matchNoticeAndMatchJoinMember.getMatchExpectedDay());
		logger.debug("matchSelectList() MatchKinds = {}", matchNoticeAndMatchJoinMember.getMatchKinds());
		logger.debug("matchSelectList() MatchNoticeStatus = {}", matchNoticeAndMatchJoinMember.getMatchNoticeStatus());		
		logger.debug("matchSelectList() HomeAway = {}", matchNoticeAndMatchJoinMember.getHomeAway());
		logger.debug("matchSelectList() matchMemberCount = {}", matchNoticeAndMatchJoinMember.getMatchMemberCount());
		logger.debug("matchSelectList() teamNo = {}", matchNoticeAndMatchJoinMember.getTeamNo());
		if(matchNoticeAndMatchJoinMember.getMatchExpectedDay() == "") {			
			matchNoticeAndMatchJoinMember.setMatchExpectedDay(null);
			logger.debug("matchSelectList() MatchExpectedDay공백이 입력되어 null로 세팅한다.");
		}	
		
		//매치 공고 상태의 매치 정보만 검색되도록 상태값을 세팅한다.
		matchNoticeAndMatchJoinMember.setMatchNoticeStatus("awayTeamWating");
		
		//matchKindsSearchWord를 dao에 넘기고 매치공고 리스트를 받아온다.
		List<MatchNotice> list = matchDao.matchSelectList(matchNoticeAndMatchJoinMember);
		
		return list;
	}

	// 매치 종류(팀전 or 자유)선택 혹은 미선택시 매치공고정보 리스트 조회 요청 처리
	public List<MatchNotice> matchNoticeSelectTeam(MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember) {
		logger.debug("matchNoticeSelectTeam() MatchExpectedDay = {}", matchNoticeAndMatchJoinMember.getMatchExpectedDay());
		logger.debug("matchNoticeSelectTeam() MatchKinds = {}", matchNoticeAndMatchJoinMember.getMatchKinds());
		logger.debug("matchNoticeSelectTeam() MatchNoticeStatus = {}", matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		logger.debug("matchNoticeSelectTeam() HomeAway = {}", matchNoticeAndMatchJoinMember.getHomeAway());
		logger.debug("matchNoticeSelectTeam() matchMemberCount = {}", matchNoticeAndMatchJoinMember.getMatchMemberCount());
		logger.debug("matchNoticeSelectTeam() teamNo = {}", matchNoticeAndMatchJoinMember.getTeamNo());
		
		if (matchNoticeAndMatchJoinMember.getMatchExpectedDay() == "") {
			matchNoticeAndMatchJoinMember.setMatchExpectedDay(null);
			logger.debug("matchSelectList() MatchExpectedDay공백이 입력되어 null로 세팅한다.");
		}

		// matchKindsSearchWord를 dao에 넘기고 매치공고 리스트를 받아온다.
		List<MatchNotice> list = matchDao.matchSelectList(matchNoticeAndMatchJoinMember);

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
	public List<MemberLogin> matchJoinMemberSelectList(int matchNoticeNo, String homeAway) {
		logger.debug("matchJoinMemberSelectList() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberSelectList() homeAway = {}", homeAway);
				
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);	
		matchJoinMember.setHomeAway(homeAway);		
		logger.debug("matchJoinMemberSelectList() teamNo = {}", matchJoinMember.getTeamNo());
		//매치에 참가신청된 한쪽 팀 맴버 리스트를 조회한다.
		List<MemberLogin> list = matchDao.matchJoinMemberSelectList(matchJoinMember);
		logger.debug("matchJoinMemberSelectList() list = {}", list);
		
		return list;
	}
	
	// 매치 번호와 팀에 일치하는 매치 참가 맴버 리스트를 조회한다.
	public List<MemberLogin> matchJoinMemberSelectList(int matchNoticeNo, int myTeamNo) {
		logger.debug("matchJoinMemberSelectList() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberSelectList() myTeamNo = {}", myTeamNo);

		matchJoinMember.setMatchNoticeNo(matchNoticeNo);		
		matchJoinMember.setTeamNo(myTeamNo);
		logger.debug("matchJoinMemberSelectList() teamNo = {}", matchJoinMember.getTeamNo());
		// 매치에 참가신청된 한쪽 팀 맴버 리스트를 조회한다.
		List<MemberLogin> list = matchDao.matchJoinMemberSelectList(matchJoinMember);
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
	public void matchJoinMemberInsert(int matchNoticeNo, int memberNo, String homeAway, int sportEntriesNo) {
		logger.debug("matchJoinMemberInsert() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberInsert() memberNo = {}", memberNo);
		logger.debug("matchJoinMemberInsert() sportEntriesNo = {}", sportEntriesNo);
		logger.debug("matchJoinMemberInsert() homeAway = {}", homeAway);
		
		//매치공고 번호로 선택한 매치의 호스트 팀 번호를 확인하는 메서드
		int matchTeamNo = matchDao.matchNoticeSelectHomeAway(matchNoticeNo);
		logger.debug("matchJoinMemberInsert() matchTeamNo = {}", matchTeamNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sportEntriesNo", sportEntriesNo);
		map.put("memberNo", memberNo);
		
		//종목과 맴버번호로 자신의 팀 번호 조회
		int myTeamNo = matchDao.teamNoSelectOne(map);		
		logger.debug("matchJoinMemberInsert() myTeamNo = {}", myTeamNo);
		
		//매개변수로 넘겨받은 값을 세팅한다.
		matchJoinMember.setMatchNoticeNo(matchNoticeNo);
		matchJoinMember.setTeamNo(myTeamNo);
		matchJoinMember.setMemberNo(memberNo);
		matchJoinMember.setHomeAway(homeAway);
		logger.debug("matchJoinMemberInsert() matchJoinMember = {}", matchJoinMember);
		
		//매개변수 homeAway로 세팅된 matchJoinMember에 값이 null이 아니면 세팅된 값 그대로 
		//null이면  자신의 팀 값과 비교하여 자동으로 홈인지 어웨이인지 설정된다.
		if(matchJoinMember.getHomeAway() == null) {
			//신청할 팀 선택
			matchJoinMember.setHomeAway("home");
			
			//매치 호스트팀 번호와 자신의 팀 번호가 다를시 어웨이로
			if(matchTeamNo != myTeamNo) {
				matchJoinMember.setHomeAway("away");
			}
		}			
		
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
			list.get(i).setUrl("../match/matchNoticeInfomation?matchNoticeNo="+list.get(i).getId());								
		}		

		return list;
	}
		
	//매치 공고에 참가한 팀원인지 판별하는 요청 처리
	public MatchJoinMember isTeamMember(int matchNoticeNo, int memberNo) {
		logger.debug("isTeamMember() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("isTeamMember() memberNo = {}", memberNo);
		
		//두 매개변수를 하나의 변수(map타입)에 세팅한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("matchNoticeNo", matchNoticeNo);
		map.put("memberNo", memberNo);
		
		MatchJoinMember teamMember = matchDao.isMatchJoinMember(map);
		
		return teamMember;
	}
	
	//
	public int matchJoinMemberDelete(int matchNoticeNo, int memberNo) {
		logger.debug("matchJoinMemberDelete() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberDelete() memberNo = {}", memberNo);
		
		//두 매개변수를 하나의 변수(map타입)에 세팅한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("matchNoticeNo", matchNoticeNo);
		map.put("memberNo", memberNo);
				
		return matchDao.matchJoinMemberDelete(map);
	}
	
	public MatchNotice matchNoticeInfomation(int matchNoticeNo, int memberNo){
		logger.debug("matchNoticeInfomation() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchNoticeInfomation() memberNo = {}", memberNo);
		
		//매치 번호와 일치하는 매치공고 정보를 조회하여 저장한다.
		MatchNotice matchNotice = matchDao.matchSelectOne(matchNoticeNo);
		logger.debug("matchSelectOne() matchNotice = {}", matchNotice);
			
		return matchNotice;
	}
	
	
	public Map<String, Object> matchNoticeInfomationHome(MatchNotice matchNotice, int memberNo){
		logger.debug("matchNoticeInfomationHome() matchNoticeNo = {}", matchNotice.getMatchNoticeNo());
		logger.debug("matchNoticeInfomationHome() memberNo = {}", memberNo);
				
		//두 매개변수를 하나의 변수(map타입)에 세팅한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("matchNoticeNo", matchNotice.getMatchNoticeNo());
		map.put("memberNo", memberNo);
				
		//매치공고 참가 맴버에 자신이 이미 있는지 조회		
		MatchJoinMember isMatchJoinMember = matchDao.isMatchJoinMember(map);
		logger.debug("matchNoticeInfomationHome() isMatchJoinMember = {}", isMatchJoinMember);

		// 홈팀 맵버정보 리스트를 받아온다.
		String homeAway = "home";
		List<MemberLogin> homeTeamMember = matchJoinMemberSelectList(matchNotice.getMatchNoticeNo(), homeAway);
		logger.debug("matchNoticeInfomationHome() homeTeamMember = {}", homeTeamMember);		
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if(isMatchJoinMember != null) {
			returnMap.put("isMatchJoinMember", isMatchJoinMember);
			if(matchNotice.getMatchNoticeNo() == memberNo) {
				returnMap.put("MatchJoinMemberLevel", "maker");
			}
		}
		returnMap.put("matchNotice", matchNotice);
		returnMap.put("homeTeamMember", homeTeamMember);
		
		if(matchNotice.getMatchNoticeStatus().equals("matchComplete")) {
			// 홈팀 맵버정보 리스트를 받아온다.
			homeAway = "away";
			List<MemberLogin> awayTeamMember = matchJoinMemberSelectList(matchNotice.getMatchNoticeNo(), homeAway);
			logger.debug("matchNoticeInfomationHome() awayTeamMember = {}", awayTeamMember);
			returnMap.put("awayTeamMember", awayTeamMember);
		} else if(matchNotice.getMatchNoticeStatus().equals("awayTeamWating")) {
			homeAway = "joinAway";
			List<MemberLogin> joinAwayTeamMember = matchJoinMemberSelectList(matchNotice.getMatchNoticeNo(), homeAway);
			logger.debug("matchNoticeInfomation() joinAwayTeamMember = {}", joinAwayTeamMember);
			returnMap.put("joinAwayTeamMember", joinAwayTeamMember);
		}
	
		return returnMap;
	}
	
	public Map<String, Object> matchNoticeInfomationAway(MatchNotice matchNotice, int memberNo, int myTeamNo){
		logger.debug("matchNoticeInfomationAway() matchNoticeNo = {}", matchNotice.getMatchNoticeNo());
		logger.debug("matchNoticeInfomationAway() memberNo = {}", memberNo);
				
		//두 매개변수를 하나의 변수(map타입)에 세팅한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("matchNoticeNo", matchNotice.getMatchNoticeNo());
		map.put("memberNo", memberNo);
				
		//매치공고 참가 맴버에 자신이 이미 있는지 조회		
		MatchJoinMember isMatchJoinMember = matchDao.isMatchJoinMember(map);
		logger.debug("matchNoticeInfomationAway() isMatchJoinMember = {}", isMatchJoinMember);
		
		List<MemberLogin> myTeamMember = matchJoinMemberSelectList(matchNotice.getMatchNoticeNo(), myTeamNo);
				
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("matchNotice", matchNotice);
		returnMap.put("myTeamMember", myTeamMember);
		
		if(isMatchJoinMember != null) {
			returnMap.put("isMatchJoinMember", isMatchJoinMember);
			if(myTeamMember.get(0).getMemberNo() == memberNo) {
				returnMap.put("MatchJoinMemberLevel", "teamJang");
			}
		}
		
		// 홈팀 맵버정보 리스트를 받아온다.
		String homeAway = "home";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		List<MemberLogin> homeTeamMember = matchJoinMemberSelectList(matchNotice.getMatchNoticeNo(), homeAway);
		logger.debug("matchNoticeInfomationAway() homeTeamMember = {}", homeTeamMember);
		returnMap.put("homeTeamMember", homeTeamMember);		
	
		return returnMap;
	}
	
}
