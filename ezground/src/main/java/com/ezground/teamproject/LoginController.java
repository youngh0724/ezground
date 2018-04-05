package com.ezground.teamproject;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String flag = "login/login";
		
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
	
	//ajax요청값 반환을 위해서 @ResponseBody를 써준다.
	@ResponseBody
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(Model model, MemberLogin memberLogin) {
		logger.debug("loginCheck() memberLogin = {}", memberLogin);			
				
		//반환할 문자열을 저장할 변수 선언
		String checkResult = null;
		
		//로그인 정보 유효성 검사 메서드 호출
		checkResult = loginservice.loginCheck(memberLogin);
		logger.debug("loginCheck() checkResult = {}", checkResult);
		        
		//결과값 반환
	    return checkResult;
	}
	
		
}
