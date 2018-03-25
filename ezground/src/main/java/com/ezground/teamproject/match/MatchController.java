package com.ezground.teamproject.match;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezground.teamproject.match.dto.MatchNotice;
import com.ezground.teamproject.member.dto.MemberLogin;

@Controller
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
	
	@RequestMapping(value="/creatMatch", method = RequestMethod.GET)
	public String creatMatch(Model model, HttpSession session,
			@RequestParam(value="entryNo", required=true) int entryNo) {
		
		logger.debug("creatMatch() entryNo = {}", entryNo);
		
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		
		logger.debug("creatMatch() memberNo = {}", memberLogin.getMemberNo());	
				
		int teamNo = matchService.teamNoSelectOne(entryNo, memberLogin.getMemberNo());
		
		model.addAttribute("teamNo", teamNo);
		
		return "match/matchCreat";
	}
	
	@RequestMapping(value="/creatMatch", method = RequestMethod.POST)
	public String creatMatch(HttpSession session, MatchNotice matchNotice) {
		
		logger.debug("creatMatch() matchNotice = {}", matchNotice.getTeamNo());	
		
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		
		int memberNo = memberLogin.getMemberNo();
		
		matchService.matchNoticeInsert(matchNotice, memberNo);
				
		return "match/matchNoticeInfomation";
	}
	
	
	
	
}
