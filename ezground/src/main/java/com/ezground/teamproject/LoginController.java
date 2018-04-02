package com.ezground.teamproject;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
			flag = "redirect:/";
		}
		
		return flag;
	}
	
	@RequestMapping(value="/login/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("logout() 로그아웃 호출 성공");
		
		if(session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		session.invalidate();
		logger.debug("logout() 세션값이 있으면 세션해제하고 리다이렉트");
		return "redirect:/";
	}
	
		
}
