package com.ezground.teamproject.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezground.teamproject.member.dto.Member;
import com.ezground.teamproject.member.dto.MemberLogin;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//회원가입 화면으로의 이동 요청
	@RequestMapping(value="/memberInsert", method = RequestMethod.GET)
	public String memberInsertView() {
		logger.debug("memberInsertView() 실행확인");
		
		return "member/memberInsert";
	}
	
	//아이디 중복체크를 하는 메서드
	//ajax요청값 반환을 위해서 @ResponseBody를 써준다.
	@ResponseBody
	@RequestMapping(value = "/idOverlapCheck", method = RequestMethod.POST)
    public String idOverlapCheck(Model model,
    		@RequestParam(value="memberId", required=true) String memberId) {
		logger.debug("idOverlapCheck() memberId = {}", memberId);
		
		//매개변수로 받은(회원가입 화면에서 넘겨준) 아이디로 회원테이블 조회시 나오는 레코드 수 1이면 중복 0이면 중복아님
        int rowcount = memberService.idOverlapCheck(memberId);
        logger.debug("idOverlapCheck() rowcount = {}", rowcount);
        
        return String.valueOf(rowcount);
    }
	
	//회원가입 버튼을 누르면 들어오는 요청  db에 정보를 입력한다.
	@RequestMapping(value="/memberInsert", method = RequestMethod.POST)
	public String memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
		
		//매개변수로 받은 Member타입 변수의 정보를 db에 입력한다.
		memberService.memberInsert(member);
		
		return "redirect:/";
	}	
	
	//ajax요청값 반환을 위해서 @ResponseBody를 써준다.
		@ResponseBody
		@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	    public String loginCheck(Model model, MemberLogin memberLogin) {
			logger.debug("loginCheck() memberLogin = {}", memberLogin);
			
			
			String checkResult = null;
			
			checkResult = memberService.loginCheck(memberLogin);
			logger.debug("loginCheck() checkResult = {}", checkResult);

	        
	        return checkResult;
	    }
	
	
	
	
	
}
