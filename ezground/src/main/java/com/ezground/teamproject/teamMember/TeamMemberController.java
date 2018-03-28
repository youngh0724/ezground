package com.ezground.teamproject.teamMember;

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

import com.ezground.teamproject.team.dto.Team;
import com.ezground.teamproject.teamMember.dto.TeamMember;

@Controller
public class TeamMemberController {
	@Autowired
	private TeamMemberService teamMemberService;
	
	//입력값과 리턴값을 확인 하기 위한 로거 기능 
	private static final Logger logger = LoggerFactory.getLogger(TeamMemberController.class);
	
	@RequestMapping(value="/teamMember/teamMemberInsert", method = RequestMethod.GET)
	public String teamMemberInsert(HttpSession session) {		
		logger.debug("teamMemberInsert() 실행확인");
		
		return "teamMember/teamMemberInsert";		
	}	
	@RequestMapping(value="/teamMember/teamMemberInsert", method = RequestMethod.POST)
	public String teamMemberInsert(TeamMember teamMember) {
		teamMemberService.teamMemberInsert(teamMember);
		
		return "redirect:/teamMember/teamMemberInsert";
	}
}