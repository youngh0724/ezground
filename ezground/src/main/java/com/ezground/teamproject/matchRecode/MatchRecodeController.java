package com.ezground.teamproject.matchRecode;

import java.util.Date;
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

import com.ezground.teamproject.member.dto.MemberLogin;


@Controller
public class MatchRecodeController {

	@Autowired
	private MatchRecodeService matchRecodeService;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchRecodeController.class);
	
	//사업자가 자신의 시설에서 날짜에 따라 일어난 매치 정보를 조회하는 요청 처리
	@RequestMapping(value = "/matchRecode/matchRecodeSelectList", method = RequestMethod.GET)
	public String matchRecodeSelectList(Model model, HttpSession session,
			@RequestParam(value = "reservationDay", required = false) Date reservationDay) {
		logger.debug("matchRecodeSelectList() reservationDay = {}", reservationDay);

		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("matchRecodeSelectList() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		} else if(session.getAttribute("MemberLogin") != null) {
			MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
			logger.debug("matchRecodeSelectList() MemberLevel = {}", memberLogin.getMemberLevel());
			if(memberLogin.getMemberLevel() != "business") {
				logger.debug("matchRecodeSelectList() 세션 권한이 사업자가 아니면 홈으로 리다이렉트 ");
				return "redirect:/";
			}
		}

		// 세션으로부터 맴버넘버를 받아온다.
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		logger.debug("creatMatch() memberNo = {}", memberLogin.getMemberNo());
		
		int memberNo = memberLogin.getMemberNo();

		Map<String, Object> map = matchRecodeService.matchRecodeSelectList(memberNo, reservationDay);	

		model.addAttribute("matchRecodeSelectList", map);
		return "match/matchCreat";
	}

	
	
}
