package com.ezground.teamproject.member;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezground.teamproject.member.dto.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/memberInsert", method = RequestMethod.GET)
	public String memberInsertView() {
		logger.debug("memberInsertView() 실행확인");
		
		return "member/memberInsert";
	}
	
	@ResponseBody
	@RequestMapping(value = "/idOverlapCheck", method = RequestMethod.POST)
    public String checkSignup(HttpServletRequest request, Model model) {
        String memberId = request.getParameter("memberId");
        int rowcount = memberService.idOverlapCheck(memberId);
        
        return String.valueOf(rowcount);
    }
	
	@RequestMapping(value="/memberInsert", method = RequestMethod.POST)
	public String memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
		
		memberService.memberInsert(member);
		
		return "redirect:/";
	}
}
