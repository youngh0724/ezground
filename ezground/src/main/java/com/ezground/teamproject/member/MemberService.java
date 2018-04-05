package com.ezground.teamproject.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.member.dto.Member;
import com.ezground.teamproject.member.dto.MemberLogin;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public void memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
		
		memberDao.memberInsert(member);
	}
	
	public int idOverlapCheck(String memberId) {
		logger.debug("memberInsert() memberId = {}", memberId);
		
		return memberDao.idOverlapCheck(memberId);
		
	}
	
	public String loginCheck(MemberLogin memberLogin) {
		logger.debug("loginCheck() memberLogin = {}", memberLogin);
		
		//반환 할 값을 담은 변수 선언
		String checkResult = "0"; 
		
		//매개변수로 로그인 체크 
		MemberLogin checkedMemberLogin = memberDao.loginCheck(memberLogin.getMemberId());
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
