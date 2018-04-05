package com.ezground.teamproject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.dto.SportEntries;
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
	
	public List<SportEntries> sportEntriesNameSelectList() {
		
		List<SportEntries> list = loginDao.sportEntriesNameSelectList();
		
		logger.debug("sportEntriesNameSelectList() sportEntriesName = {}", list.get(1).getSportEntriesName());	
		
		
		return list;
	}
	
	public String loginCheck(MemberLogin memberLogin) {
		logger.debug("loginCheck() memberLogin = {}", memberLogin);
		
		//반환 할 값을 담은 변수 선언
		String checkResult = "0"; 
		
		//매개변수로 로그인 체크 
		MemberLogin checkedMemberLogin = loginDao.loginCheck(memberLogin);
		logger.debug("loginCheck() checkedMemberLogin = {}", checkedMemberLogin);
		
		//결과가 null이면 아이디와 일치하는 정보 없음(상황1 - 문자 0 리턴),  null이 아니면 일치하는 정보 있음(상황2- 문자1리턴)
		if(checkedMemberLogin != null) {
			checkResult = "1";
			//입력받은 비밀번호와 조회된 비밀번호를 비교 같으면 로그인 성공(상황3 - 문자2리턴)
			if(checkedMemberLogin.getMemberPw().equals(memberLogin.getMemberPw())) {
				checkResult = "2";
			}
		}		
		
		return checkResult;
	}
	
	
	
	
}
