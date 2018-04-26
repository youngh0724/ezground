package com.ezground.teamproject.matchRecord;

import java.util.Date;
import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.match.MatchService;
import com.ezground.teamproject.matchRecord.dto.MatchRecordFieldList;
import com.ezground.teamproject.matchRecord.dto.MatchScoreRecord;
import com.ezground.teamproject.member.dto.MemberLogin;


@Controller
public class MatchRecordController {

	@Autowired
	private MatchRecordService matchRecordService;
	
	@Autowired
	private MatchService matchService;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecordController.class);
	
	//사업자가 자신의 시설에서 날짜에 따라 일어난 매치 정보를 조회하는 요청 처리
	@RequestMapping(value = "/matchRecord/matchRecordBusinessSelectList", method = RequestMethod.GET)
	public String matchRecordBusinessSelectList(Model model, HttpSession session,
			@RequestParam(value = "reservationDay", required = false) Date reservationDay) {
		logger.debug("matchRecordBusinessSelectList() reservationDay = {}", reservationDay);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("matchRecordBusinessSelectList() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		} else if(session.getAttribute("MemberLogin") != null) {
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecordBusinessSelectList() MemberLevel = {}", memberLogin.getMemberLevel());
			if(!memberLogin.getMemberLevel().equals("business")) {
				logger.debug("matchRecordBusinessSelectList() 세션 권한이 사업자가 아니면 홈으로 리다이렉트 ");
				return "redirect:/";
			}
		}

		// 세션으로부터 맴버넘버를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		logger.debug("matchRecordBusinessSelectList() memberNo = {}", memberLogin.getMemberNo());
		
		int memberNo = memberLogin.getMemberNo();

		List<MatchRecordFieldList> matchRecordFieldList = matchRecordService.matchRecordBusinessSelectList(memberNo, reservationDay);	
		logger.debug("matchRecordBusinessSelectList() matchRecodeFieldList = {}", matchRecordFieldList);
		
		model.addAttribute("matchRecordFieldList", matchRecordFieldList);
		return "matchRecord/matchRecordBusinessSelectList";
	}
	
	//사업자가 자신의 시설에서 날짜에 따라 일어난 매치 정보를 조회하는 요청 처리
		@RequestMapping(value = "/matchRecord/matchRecordBusinessSelectList", method = RequestMethod.POST)
		public String matchRecordBusinessSelectList2(Model model, HttpSession session,
				@RequestParam(value = "reservationDay", required = false) String reservationDay) {
			logger.debug("matchRecordBusinessSelectList2() reservationDay = {}", reservationDay);

			// 세션검사 로그인되어있지 않으면 홈화면으로
			if (session.getAttribute("MemberLogin") == null) {
				logger.debug("matchRecordBusinessSelectList2() 세션값 없으면 홈으로 리다이렉트 ");
				return "redirect:/";
			} else if(session.getAttribute("MemberLogin") != null) {
				MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
				logger.debug("matchRecordBusinessSelectList2() MemberLevel = {}", memberLogin.getMemberLevel());
				if(!memberLogin.getMemberLevel().equals("business")) {
					logger.debug("matchRecordBusinessSelectList2() 세션 권한이 사업자가 아니면 홈으로 리다이렉트 ");
					return "redirect:/";
				}
			}

			// 세션으로부터 맴버넘버를 받아온다.
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecordBusinessSelectList2() memberNo = {}", memberLogin.getMemberNo());
			
			int memberNo = memberLogin.getMemberNo();

			List<MatchRecordFieldList> matchRecordFieldList = matchRecordService.matchRecordBusinessSelectList(memberNo, reservationDay);	
			logger.debug("matchRecordBusinessSelectList2() matchRecodeFieldList = {}", matchRecordFieldList);
			
			model.addAttribute("matchRecordFieldList", matchRecordFieldList);
			return "matchRecord/matchRecordBusinessSelectList";
		}
	
	//날짜별 진행된 경기를 선택하여 경기 내용을 기록하기위한 폼화면으로의 이동요청을 처리
	@RequestMapping(value = "/matchRecord/matchRecordBusinessInsert", method = RequestMethod.GET)
	public String matchRecordBusinessInsert(Model model, HttpSession session,
			@RequestParam(value = "reservationNo", required = true) int reservationNo) {
		logger.debug("matchRecordBusinessInsert() reservationNo = {}", reservationNo);
		
		Map<String, Object> map = matchRecordService.matchRecordBusinessInsert(reservationNo);
		logger.debug("matchRecordBusinessInsert() map = {}", map);
		
		model.addAttribute("reservationInfo", map);	
		return "matchRecord/matchRecordBusinessInsert";
	}
	
	//날짜별 진행된 경기를 선택하여 경기 내용을 기록하기위한 폼화면으로의 이동요청을 처리
		@RequestMapping(value = "/matchRecord/matchRecordBusinessInsert", method = RequestMethod.POST)
		public String matchRecordBusinessInsert(HttpSession session, MatchScoreRecord matchScoreRecord,
				RedirectAttributes redirectAttributes) {
			logger.debug("matchRecordBusinessInsert() matchScoreRecode = {}", matchScoreRecord);
			
			// 세션으로부터 맴버넘버를 받아온다.
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecordBusinessSelectList2() memberNo = {}", memberLogin.getMemberNo());
			
			//입력할 경기 기록에 기록자로 자신의 맴버번호를 세팅한다.
			matchScoreRecord.setWriteMemberNo(memberLogin.getMemberNo());
			
			int row = matchRecordService.matchRecordBusinessInsert(matchScoreRecord);
			logger.debug("matchRecodeBusinessInsert() row = {}", row);
			
			redirectAttributes.addAttribute("reservationNo", matchScoreRecord.getReservationNo());
			return "redirect:/matchRecord/matchRecordBusinessInsert";
		}
		
	//매치 기록을 삭제하는 요청 처리
	@RequestMapping(value = "/matchRecode/matchRecodeBusinessDelete", method = RequestMethod.GET)
	public String matchRecordBusinessDelete(RedirectAttributes redirectAttributes,
			@RequestParam(value = "scoreNo", required = true) int scoreNo,
			@RequestParam(value = "reservationNo", required = true) int reservationNo) {
		logger.debug("matchRecordBusinessDelete() scoreNo = {}", scoreNo);
		logger.debug("matchRecordBusinessDelete() reservationNo = {}", reservationNo);
		
		int row = matchRecordService.matchRecordBusinessDelete(scoreNo);
		logger.debug("matchRecordBusinessDelete() row = {}", row);
		
		redirectAttributes.addAttribute("reservationNo", reservationNo);
		return "redirect:/matchRecord/matchRecordBusinessInsert";
	}
	
	//자신이 속한 팀과 자신의 개인 기록을 볼수있는 화면으로의 이동 요청 처리
		@RequestMapping(value = "/matchRecord/matchRecord", method = RequestMethod.GET)
		public String matchRecordSelect(Model model, HttpSession session) {
		
			// 세션검사 로그인되어있지 않으면 홈화면으로
			if (session.getAttribute("MemberLogin") == null) {
				logger.debug("matchRecordSelect() 세션값 없으면 홈으로 리다이렉트 ");
				return "redirect:/";
			}
			
			// 세션으로부터 맴버넘버를 받아온다.
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecordSelect() memberNo = {}", memberLogin.getMemberNo());
			
			SportEntries sportEntries = (SportEntries) session.getAttribute("currentSportEntry");
			int entryNo = sportEntries.getSportEntriesNo();
			logger.debug("matchRecordSelect() entryNo = {}", entryNo);
			
			// 종목번호와 맴버번호로 팀번호를 조회한다.
			Integer teamNo = matchService.teamNoSelectOne(entryNo, memberLogin.getMemberNo());
			logger.debug("matchRecordSelect() teamNo = {}", teamNo);
			
			// 현재 종목에 가입된 팀이 없으면 팀 생성 화면으로 이동한다.
			if (teamNo == null) {
				return "team/teamInsert";
			}
			
			Map<String, Object> teamMap = matchRecordService.matchRecordResultList(teamNo);
			
			Map<String, Object> memberMap = matchRecordService.matchRecordResultList(teamNo, memberLogin.getMemberNo());
				
			model.addAttribute("teamRecord", teamMap);
			model.addAttribute("memberRecord", memberMap);
			
			return "matchRecord/matchRecord";
		}
}
