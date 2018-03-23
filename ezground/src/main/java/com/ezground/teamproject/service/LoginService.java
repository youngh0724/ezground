package com.ezground.teamproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.LoginController;
import com.ezground.teamproject.member.dto.MemberLogin;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	public MemberLogin loginSelectOne(MemberLogin memberLogin) {
		
		logger.debug("loginSelectOne() memberId = {}", memberLogin.getMemberId());	
		logger.debug("loginSelectOne() memberPw = {}", memberLogin.getMemberPw());
		logger.debug("loginSelectOne() memberLevel = {}", memberLogin.getMemberLevel());
		
		
		memberLogin = loginDao.loginSelectOne(memberLogin);
		return memberLogin;
	}
}
