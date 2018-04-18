package com.ezground.teamproject.matchRecode;

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

import com.ezground.teamproject.matchRecode.dto.MatchRecodeFieldList;
import com.ezground.teamproject.member.dto.MemberLogin;


@Controller
public class MatchRecodeController {

	@Autowired
	private MatchRecodeService matchRecodeService;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecodeController.class);
	
	//사업자가 자신의 시설에서 날짜에 따라 일어난 매치 정보를 조회하는 요청 처리
	@RequestMapping(value = "/matchRecode/matchRecodeBusinessSelectList", method = RequestMethod.GET)
	public String matchRecodeBusinessSelectList(Model model, HttpSession session,
			@RequestParam(value = "reservationDay", required = false) Date reservationDay) {
		logger.debug("matchRecodeBusinessSelectList() reservationDay = {}", reservationDay);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("matchRecodeBusinessSelectList() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		} else if(session.getAttribute("MemberLogin") != null) {
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecodeBusinessSelectList() MemberLevel = {}", memberLogin.getMemberLevel());
			if(!memberLogin.getMemberLevel().equals("business")) {
				logger.debug("matchRecodeBusinessSelectList() 세션 권한이 사업자가 아니면 홈으로 리다이렉트 ");
				return "redirect:/";
			}
		}

		// 세션으로부터 맴버넘버를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		logger.debug("matchRecodeBusinessSelectList() memberNo = {}", memberLogin.getMemberNo());
		
		int memberNo = memberLogin.getMemberNo();

		List<MatchRecodeFieldList> matchRecodeFieldList = matchRecodeService.matchRecodeBusinessSelectList(memberNo, reservationDay);	
		logger.debug("matchRecodeBusinessSelectList() matchRecodeFieldList = {}", matchRecodeFieldList);
		
		model.addAttribute("matchRecodeFieldList", matchRecodeFieldList);
		return "matchRecode/matchRecodeBusinessSelectList";
	}
	
	//사업자가 자신의 시설에서 날짜에 따라 일어난 매치 정보를 조회하는 요청 처리
		@RequestMapping(value = "/matchRecode/matchRecodeBusinessSelectList", method = RequestMethod.POST)
		public String matchRecodeBusinessSelectList2(Model model, HttpSession session,
				@RequestParam(value = "reservationDay", required = false) String reservationDay) {
			logger.debug("matchRecodeBusinessSelectList() reservationDay = {}", reservationDay);

			// 세션검사 로그인되어있지 않으면 홈화면으로
			if (session.getAttribute("MemberLogin") == null) {
				logger.debug("matchRecodeBusinessSelectList() 세션값 없으면 홈으로 리다이렉트 ");
				return "redirect:/";
			} else if(session.getAttribute("MemberLogin") != null) {
				MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
				logger.debug("matchRecodeBusinessSelectList() MemberLevel = {}", memberLogin.getMemberLevel());
				if(!memberLogin.getMemberLevel().equals("business")) {
					logger.debug("matchRecodeBusinessSelectList() 세션 권한이 사업자가 아니면 홈으로 리다이렉트 ");
					return "redirect:/";
				}
			}

			// 세션으로부터 맴버넘버를 받아온다.
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecodeBusinessSelectList() memberNo = {}", memberLogin.getMemberNo());
			
			int memberNo = memberLogin.getMemberNo();

			List<MatchRecodeFieldList> matchRecodeFieldList = matchRecodeService.matchRecodeBusinessSelectList(memberNo, reservationDay);	
			logger.debug("matchRecodeBusinessSelectList() matchRecodeFieldList = {}", matchRecodeFieldList);
			
			model.addAttribute("matchRecodeFieldList", matchRecodeFieldList);
			return "matchRecode/matchRecodeBusinessSelectList";
		}
	

	@RequestMapping(value = "/matchRecode/matchRecodeBusinessInsert", method = RequestMethod.GET)
	public String matchRecodeBusinessInsert(Model model, HttpSession session,
			@RequestParam(value = "reservationNo", required = true) int reservationNo) {
		logger.debug("matchRecodeBusinessInsert() reservationNo = {}", reservationNo);
		
		return "redirect:/matchRecode/matchRecodeBusinessSelectList";
	}
	
	
}
