package com.ezground.teamproject.match;

import java.util.List;

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
	public String creatMatch(HttpSession session, MatchNotice matchNotice, RedirectAttributes redirectAttributes) {
		
		logger.debug("creatMatch() matchNotice = {}", matchNotice.getTeamNo());	
		
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		
		int memberNo = memberLogin.getMemberNo();
		
		int generatedMatchNoticeNo = matchService.matchNoticeInsert(matchNotice, memberNo);
		
		redirectAttributes.addAttribute("matchNoticeNo", generatedMatchNoticeNo);
		
		return "redirect:/match/matchNoticeInfomation";
	}
	
	@RequestMapping(value="/match/matchNoticeInfomation", method = RequestMethod.GET)
	public String matchNoticeInfomation(HttpSession session, Model model,
			@RequestParam(value="matchNoticeNo", required=true) int matchNoticeNo) {
		
		MatchNotice matchNotice = matchService.matchSelectOne(matchNoticeNo);
		
		String homeAway = "home";		
		List<String> homeTeamMember = matchService.matchJoinMemberList(matchNoticeNo, homeAway);
		
		homeAway = "away";
		List<String> awayTeamMember = matchService.matchJoinMemberList(matchNoticeNo, homeAway);
		
		model.addAttribute("matchNotice", matchNotice);
		model.addAttribute("homeTeamMember", homeTeamMember);
		model.addAttribute("awayTeamMember", awayTeamMember);
		
		return "match/matchNoticeInfomation";
	}
	
	@RequestMapping(value="/match/matchSelect", method = RequestMethod.GET)
	public String matchNoticeSelect(HttpSession session, Model model,
			@RequestParam(value="searchWord", required=false) String searchWord) {
		
		List<MatchNotice> list = matchService.matchSelectList(searchWord);
		
		model.addAttribute("matchNoticeList", list);
		
		return "match/matchSelect";
	}
	
	@RequestMapping(value="/match/matchJoin", method = RequestMethod.GET)
	public String matchJoinMemberInsert(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value="matchNoticeNo", required=true) int matchNoticeNo) {
				
		int matchTeamNo = matchService.matchNoticeSelectHomeAway(matchNoticeNo);
		
		logger.debug("matchJoinMemberInsert() matchTeamNo = {}", matchTeamNo);	
		
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		
		int memberNo = memberLogin.getMemberNo();
		
		logger.debug("matchJoinMemberInsert() currentSportEntry = {}", session.getAttribute("currentSportEntry"));	
		SportEntries sportEntries = (SportEntries)session.getAttribute("currentSportEntry");
		
		int myTeamNo = matchService.teamNoSelectOne(sportEntries.getSportEntriesNo(), memberNo);
		
		logger.debug("matchJoinMemberInsert() myTeamNo = {}", myTeamNo);
		
		String homeAway = "home";
		
		if(matchTeamNo != myTeamNo) {
			homeAway = "away";
		}
		
		matchService.matchJoinMemberInsert(matchNoticeNo, memberNo, myTeamNo, homeAway);
		
		redirectAttributes.addAttribute("matchNoticeNo", matchNoticeNo);
		return "redirect:/match/matchNoticeInfomation";
	}
	
}
