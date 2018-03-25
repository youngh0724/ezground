package com.ezground.teamproject;

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

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.member.dto.MemberLogin;
import com.ezground.teamproject.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginservice;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginCheck() {
		return "login/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginSelectOne(HttpSession session, MemberLogin memberLogin) {
		String flag = "login";
		
		logger.debug("loginSelectOne() memberId = {}", memberLogin.getMemberId());	
		logger.debug("loginSelectOne() memberPw = {}", memberLogin.getMemberPw());
		logger.debug("loginSelectOne() memberLevel = {}", memberLogin.getMemberLevel());
		
		memberLogin = loginservice.loginSelectOne(memberLogin);
		if (memberLogin == null) {
			logger.debug("loginSelectOne() 로그인 실패");			
		} else {
			logger.debug("loginSelectOne() 로그인 성공");	
			session.setAttribute("MemberLogin", memberLogin);
			flag = "redirect:/logined";
		}
		
		return flag;
	}
	
	@RequestMapping(value="/logined", method = RequestMethod.GET)
	public String loginedPage(Model model, HttpSession session,
			@RequestParam(value="entryNo", defaultValue="0") int entryNo) {
		
		List<SportEntries> list = loginservice.sportEntriesNameSelectList();
		
		logger.debug("loginedPage() sportEntriesName = {}", list.get(entryNo).getSportEntriesName());	
		
		model.addAttribute("list", list);
		
		session.setAttribute("currentSportEntry", list.get(entryNo));
		
		return "login/logined";
	}
	
	
	
	
}
