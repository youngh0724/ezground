package com.ezground.teamproject.match;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.match.dto.MatchNotice;
import com.ezground.teamproject.match.dto.MatchNoticeAndMatchJoinMember;
import com.ezground.teamproject.match.dto.MatchNoticeFullcalendarEvent;
import com.ezground.teamproject.member.dto.MemberLogin;
import com.google.gson.Gson;

@Controller
public class MatchController {

	@Autowired
	private MatchService matchService;

	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

	// 매치 생성하기버튼을 눌러 생성 정보 입력창으로 가는 요청 처리
	@RequestMapping(value = "/creatMatch", method = RequestMethod.GET)
	public String creatMatch(Model model, HttpSession session,
			@RequestParam(value = "entryNo", required = true) int entryNo) {
		logger.debug("creatMatch() entryNo = {}", entryNo);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}

		// 세션으로부터 맴버넘버를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		logger.debug("creatMatch() memberNo = {}", memberLogin.getMemberNo());

		// 종목번호와 맴버번호로 팀번호를 조회한다.
		Integer teamNo = matchService.teamNoSelectOne(entryNo, memberLogin.getMemberNo());
		logger.debug("creatMatch() teamNo = {}", teamNo);

		// 현재 종목에 가입된 팀이 없으면 팀 생성 화면으로 이동한다.
		if (teamNo == null) {
			return "team/teamInsert";
		}

		model.addAttribute("teamNo", teamNo);
		return "match/matchCreat";
	}

	// 매치 생성 정보 입력창에서 정보를 입력하고 등록버튼을 눌럿을때 오는 요청을 처리
	@RequestMapping(value = "/creatMatch", method = RequestMethod.POST)
	public String creatMatch(HttpSession session, MatchNotice matchNotice, RedirectAttributes redirectAttributes) {
		logger.debug("creatMatch() matchNotice = {}", matchNotice.getMemberNo());

		// 세션에서 맴버 번호를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		logger.debug("creatMatch() memberNo = {}", memberNo);

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int sportEntryNo = sportEntries.getSportEntriesNo();
		logger.debug("matchNoticeSelect() entryNo = {}", sportEntryNo);

		// 정보를 디비에 입력하고 입력후 방색한 매치공고 번호를 받아 저장한다.
		int generatedMatchNoticeNo = matchService.matchNoticeInsert(matchNotice, memberNo, sportEntryNo);
		logger.debug("creatMatch() generatedMatchNoticeNo = {}", generatedMatchNoticeNo);

		// 리다이렉트시 정보를 저장하기위세 세팅한다.
		redirectAttributes.addAttribute("matchNoticeNo", generatedMatchNoticeNo);
		return "redirect:/match/matchNoticeInfomation";
	}

	// 매치 정보 상세보기를 눌럿을때 상세보기 화면으로가는 요청 처리
	@RequestMapping(value = "/match/matchNoticeInfomation", method = RequestMethod.GET)
	public String matchNoticeInfomation(HttpSession session, Model model,
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo) {
		logger.debug("matchNoticeInfomation() matchNoticeNo = {}", matchNoticeNo);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("matchNoticeInfomation() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}

		// 세션으로부터 자신의 맴버번호 확인
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		//매치의 정보를 조회한다.
		MatchNotice matchNotice = matchService.matchNoticeInfomation(matchNoticeNo, memberNo);
		
		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		logger.debug("matchNoticeInfomation() sportEntriesNo = {}", sportEntriesNo);
				
		// 종목번호와 맴버번호로 팀번호를 조회한다.
		Integer myTeamNo = matchService.teamNoSelectOne(sportEntriesNo, memberLogin.getMemberNo());
		logger.debug("matchNoticeInfomation() myTeamNo = {}", myTeamNo);
		
		// 종목번호와 맴버번호로 팀번호를 조회한다.
		Integer homeTeamNo = matchService.teamNoSelectOne(sportEntriesNo, matchNotice.getMemberNo());
		logger.debug("matchNoticeInfomation() homeTeamNo = {}", homeTeamNo);
				
		Map<String, Object> map;
		
		//홈팀 과 나의 팀을 비교하여 같으면 홈팀이화면에 필요한 정보 다르면 원정팀에 필요한 정보를 세팅하는 메서드를 호출한다.
		if(homeTeamNo == myTeamNo) {
			map = matchService.matchNoticeInfomationHome(matchNotice, memberNo);
		} else {
			map = matchService.matchNoticeInfomationAway(matchNotice, memberNo, myTeamNo);
		}				
		
		model.addAttribute("conditionInfo", map);

		return "match/matchNoticeInfomation";
	}

	// 매치 공고 정보를 조회하는 화면으로의 요청처리
	@RequestMapping(value = "/match/matchSelect", method = RequestMethod.GET)
	public String matchNoticeSelect(HttpSession session, Model model,
			MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember) {
		logger.debug("matchNoticeSelect() matchNoticeStatus = {}",
				matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		logger.debug("matchNoticeSelect() matchKinds = {}", matchNoticeAndMatchJoinMember.getMatchKinds());
		logger.debug("matchNoticeSelect() matchExpectedDay = {}", matchNoticeAndMatchJoinMember.getMatchExpectedDay());
		logger.debug("matchNoticeSelect() homeAway = {}", matchNoticeAndMatchJoinMember.getHomeAway());
		logger.debug("matchNoticeSelect() matchMemberCount = {}", matchNoticeAndMatchJoinMember.getMatchMemberCount());
		logger.debug("matchNoticeSelect() teamNo = {}", matchNoticeAndMatchJoinMember.getTeamNo());
		
		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}

		// 매치 상태값을 미리 지정한 값으로 초기화
		matchNoticeAndMatchJoinMember.setMatchNoticeStatus("awayTeamWating");
		logger.debug("matchNoticeSelect() NoticeStatus = {}", matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		matchNoticeAndMatchJoinMember.setMatchKinds("all");
		logger.debug("matchNoticeSelect() MatchKinds = {}", matchNoticeAndMatchJoinMember.getMatchKinds());

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		logger.debug("matchNoticeSelect() sportEntriesNo = {}", sportEntriesNo);

		matchNoticeAndMatchJoinMember.setSportEntriesNo(sportEntriesNo);
		logger.debug("matchNoticeSelect() SportEntriesNo = {}", matchNoticeAndMatchJoinMember.getSportEntriesNo());

		// 매치공고 정보 리스트를 조회하는 매서드
		List<MatchNotice> list = matchService.matchSelectList(matchNoticeAndMatchJoinMember);
		logger.debug("matchNoticeSelect() list = {}", list);

		model.addAttribute("matchNoticeList", list);
		return "match/matchSelect";
	}

	// 매치 공고 정보를 조회하는 화면으로의 요청처리
	@RequestMapping(value = "/match/matchSelect", method = RequestMethod.POST)
	public String matchNoticeSelectWithSearchCondition(HttpSession session, Model model,
			MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember) {
		logger.debug("matchNoticeSelectWithSearchCondition() MatchExpectedDay = {}",
				matchNoticeAndMatchJoinMember.getMatchExpectedDay());
		logger.debug("matchNoticeSelectWithSearchCondition() MatchKinds = {}",
				matchNoticeAndMatchJoinMember.getMatchKinds());
		logger.debug("matchNoticeSelectWithSearchCondition() MatchNoticeStatus = {}",
				matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		logger.debug("matchNoticeSelectWithSearchCondition() HomeAway = {}",
				matchNoticeAndMatchJoinMember.getHomeAway());
		logger.debug("matchNoticeSelectWithSearchCondition() matchMemberCount = {}",
				matchNoticeAndMatchJoinMember.getMatchMemberCount());

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int entryNo = sportEntries.getSportEntriesNo();
		logger.debug("matchNoticeSelectWithSearchCondition() entryNo = {}", entryNo);

		matchNoticeAndMatchJoinMember.setSportEntriesNo(entryNo);
		logger.debug("matchNoticeSelectWithSearchCondition() SportEntriesNo = {}", matchNoticeAndMatchJoinMember.getSportEntriesNo());

		// 매치공고 정보 리스트를 조회하는 매서드
		List<MatchNotice> list = matchService.matchSelectList(matchNoticeAndMatchJoinMember);
		logger.debug("matchNoticeSelectWithSearchCondition() list = {}", list);

		model.addAttribute("matchNoticeList", list);
		return "match/matchSelect";
	}

	// 팀원 소속 매치 검색 페이지로 이동 요청 처리
	@RequestMapping(value = "/match/matchSelectTeam", method = RequestMethod.GET)
	public String matchNoticeSelectTeam(HttpSession session, Model model,
			MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember) {
		logger.debug("matchNoticeSelectTeam() matchNoticeStatus = {}",
				matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		logger.debug("matchNoticeSelectTeam() matchKinds = {}", matchNoticeAndMatchJoinMember.getMatchKinds());
		logger.debug("matchNoticeSelectTeam() matchExpectedDay = {}", matchNoticeAndMatchJoinMember.getMatchExpectedDay());
		logger.debug("matchNoticeSelectTeam() homeAway = {}", matchNoticeAndMatchJoinMember.getHomeAway());
		logger.debug("matchNoticeSelectTeam() matchMemberCount = {}", matchNoticeAndMatchJoinMember.getMatchMemberCount());

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		
		// 세션으로부터 맴버넘버를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		logger.debug("creatMmatchNoticeSelectTeamatch() memberNo = {}", memberLogin.getMemberNo());

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		logger.debug("matchNoticeSelectTeam() entryNo = {}", sportEntriesNo);
				
		// 종목번호와 맴버번호로 팀번호를 조회한다.
		Integer teamNo = matchService.teamNoSelectOne(sportEntriesNo, memberLogin.getMemberNo());
		logger.debug("matchNoticeSelectTeam() teamNo = {}", teamNo);

		if(teamNo == null) {
			return "team/teamInsert";
		}
		
		// 매치 상태값을 미리 지정한 값으로 초기화
		matchNoticeAndMatchJoinMember.setTeamNo(teamNo);
		logger.debug("matchNoticeSelectTeam() NoticeStatus = {}", matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		matchNoticeAndMatchJoinMember.setMatchKinds("all");
		logger.debug("matchNoticeSelectTeam() MatchKinds = {}", matchNoticeAndMatchJoinMember.getMatchKinds());

		matchNoticeAndMatchJoinMember.setSportEntriesNo(sportEntriesNo);
		logger.debug("matchNoticeSelectTeam() SportEntriesNo = {}", matchNoticeAndMatchJoinMember.getSportEntriesNo());

		// 매치공고 정보 리스트를 조회하는 매서드
		List<MatchNotice> list = matchService.matchNoticeSelectTeam(matchNoticeAndMatchJoinMember);
		logger.debug("matchNoticeSelectTeam() list = {}", list);

		model.addAttribute("matchNoticeList", list);
		return "match/matchSelectTeam";
	}

	// 매치 공고 정보를 조회하는 화면으로의 요청처리
	@RequestMapping(value = "/match/matchSelectTeam", method = RequestMethod.POST)
	public String matchNoticeSelecTeamtWithSearchCondition(HttpSession session, Model model,
			MatchNoticeAndMatchJoinMember matchNoticeAndMatchJoinMember) {
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() MatchExpectedDay = {}",
				matchNoticeAndMatchJoinMember.getMatchExpectedDay());
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() MatchKinds = {}",
				matchNoticeAndMatchJoinMember.getMatchKinds());
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() MatchNoticeStatus = {}",
				matchNoticeAndMatchJoinMember.getMatchNoticeStatus());
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() HomeAway = {}",
				matchNoticeAndMatchJoinMember.getHomeAway());
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() matchMemberCount = {}",
				matchNoticeAndMatchJoinMember.getMatchMemberCount());

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int entryNo = sportEntries.getSportEntriesNo();
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() entryNo = {}", entryNo);

		matchNoticeAndMatchJoinMember.setSportEntriesNo(entryNo);
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() SportEntriesNo = {}", matchNoticeAndMatchJoinMember.getSportEntriesNo());

		// 매치공고 정보 리스트를 조회하는 매서드
		List<MatchNotice> list = matchService.matchSelectList(matchNoticeAndMatchJoinMember);
		logger.debug("matchNoticeSelecTeamtWithSearchCondition() list = {}", list);

		model.addAttribute("matchNoticeList", list);
		return "match/matchSelectTeam";
	}

	// 매치 상세보기에서 매치에 참가신청을 하는 요청 처리
	@RequestMapping(value = "/match/matchJoin", method = RequestMethod.GET)
	public String matchJoinMemberInsert(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo,
			@RequestParam(value = "homeAway", required = false) String homeAway) {
		logger.debug("matchJoinMemberInsert() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchJoinMemberInsert() homeAway = {}", homeAway);

		// 세션으로부터 자신의 맴버번호 확인
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		logger.debug("matchJoinMemberInsert() sportEntries = {}", sportEntries);

		// 매치에 참가 신청
		matchService.matchJoinMemberInsert(matchNoticeNo, memberNo, homeAway, sportEntries.getSportEntriesNo());

		// 리다이렉트 시킬시 정보 저장
		redirectAttributes.addAttribute("matchNoticeNo", matchNoticeNo);
		return "redirect:/match/matchNoticeInfomation";
	}

	// 매치 상세보기에서 매치에 참가신청을 추소하는 요청 처리
	@RequestMapping(value = "/match/matchJoinCancel", method = RequestMethod.GET)
	public String matchJoinMemberDelete(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo) {
		logger.debug("matchJoinMemberDelete() matchNoticeNo = {}", matchNoticeNo);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}

		// 세션으로부터 자신의 맴버번호 확인
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();

		// 매치에 참가 신청취소
		matchService.matchJoinMemberDelete(matchNoticeNo, memberNo);

		// 리다이렉트 시킬시 정보 저장
		redirectAttributes.addAttribute("matchNoticeNo", matchNoticeNo);
		return "redirect:/match/matchNoticeInfomation";
	}

	// 매치검색 화면에서 fullcalendar에 날짜에 매치 예정일과 일치하는 경기 내용을 표시해줄 데이터를 제공하는 요청처리
	@RequestMapping(value = "/matchNoticeGsonList", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String gsonList(HttpSession session, Locale locale, Model model,
			@RequestParam(value = "matchKindsSearchWord", required = false) String matchKindsSearchWord) {

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		logger.debug("matchJoinMemberInsert() sportEntries = {}", sportEntries);

		int sprotEntryNo = sportEntries.getSportEntriesNo();

		List<MatchNoticeFullcalendarEvent> list = matchService.matchSelectListfullcalendar(sprotEntryNo,
				matchKindsSearchWord);
		logger.debug("matchJoinMemberInsert() list = {}", list);

		Gson gson = new Gson();
		return gson.toJson(list);
	}

	// 매치 공고 정보를 조회하는 화면으로의 요청처리
	@RequestMapping(value = "/match/matchNoticeDelete", method = RequestMethod.GET)
	public String matchNoticeDelete(HttpSession session, Model model,
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo) {
		logger.debug("matchNoticeDelete() matchNoticeNo = {}", matchNoticeNo);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		return "match/matchSelect";
	}
	
	// 매치 공고 정보 조회 화면에서 공고 정보를 다름팀이 검색할수 있도록 검색제한을 푸는 요청 처리
	@RequestMapping(value = "/match/matchNoticeNotice", method = RequestMethod.GET)
	public String matchNoticeNotice(HttpSession session, Model model, 
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo) {
		logger.debug("matchNoticeDelete() matchNoticeNo = {}", matchNoticeNo);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		
		// 매치공고  다른팀이 검색할수 있도록 공개하기
		matchService.matchNoticeNotice(matchNoticeNo);

		return "redirect:/match/matchSelectTeam";
	}
	
	// 매치 공고 정보 조회화면에서 원정팀 신청 맴버가 조건달성되어 홈팀에 매치 요청을 하는 요청 처리
	@RequestMapping(value = "/match/matchRequestHomeTeam", method = RequestMethod.GET)
	public String matchRequestHomeTeam(HttpSession session, Model model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo) {
		logger.debug("matchRequestHomeTeam() matchNoticeNo = {}", matchNoticeNo);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("matchRequestHomeTeam() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		
		// 세션으로부터 맴버넘버를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		logger.debug("matchRequestHomeTeam() memberNo = {}", memberLogin.getMemberNo());

		// 현재 세션이 갖고있는 스포츠 종목
		SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		logger.debug("matchRequestHomeTeam() entryNo = {}", sportEntriesNo);

		// 종목번호와 맴버번호로 팀번호를 조회한다.
		Integer teamNo = matchService.teamNoSelectOne(sportEntriesNo, memberLogin.getMemberNo());
		logger.debug("matchRequestHomeTeam() teamNo = {}", teamNo);

		// 매치공고 다른팀이 검색할수 있도록 공개하기
		matchService.matchRequestHomeTeam(matchNoticeNo, teamNo);

		// 리다이렉트 시킬시 정보 저장
		redirectAttributes.addAttribute("matchNoticeNo", matchNoticeNo);
		return "redirect:/match/matchNoticeInfomation";
	}
	
	//홈팀의 원정팀 매치요청을 수락하는 요청 처리
	@RequestMapping(value = "/match/matchRequestPermit", method = RequestMethod.GET)
	public String matchRequestPermit(HttpSession session, Model model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "matchNoticeNo", required = true) int matchNoticeNo,
			@RequestParam(value = "memberNo", required = true) int memberNo) {
		logger.debug("matchRequestPermit() matchNoticeNo = {}", matchNoticeNo);
		logger.debug("matchRequestPermit() memberNo = {}", memberNo);
		
		matchService.matchRequestPermit(matchNoticeNo, memberNo);
		
		// 리다이렉트 시킬시 정보 저장
		redirectAttributes.addAttribute("matchNoticeNo", matchNoticeNo);
		return "redirect:/match/matchNoticeInfomation";
	}

}
