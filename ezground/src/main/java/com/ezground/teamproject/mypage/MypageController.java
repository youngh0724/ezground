package com.ezground.teamproject.mypage;

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

import com.ezground.teamproject.member.dto.MemberLogin;
import com.ezground.teamproject.reservation.dto.Reservation;
import com.ezground.teamproject.team.dto.Team;


@Controller
public class MypageController {
	
	@Autowired
	private MypageService mypageService;	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@RequestMapping(value="/mypage/mypage", method = RequestMethod.GET)
	public String myPage(Model model, HttpSession session,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="5") int rowPerPage) {			
		
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		Map map = mypageService.mypageTeamList(currentPage, rowPerPage, memberNo);
		logger.debug("mypageTeamList() memberNo = {}", memberNo);
		
		List<Team> list = (List<Team>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");
		int lastPage = (totalCount/rowPerPage)+1;
		
		List<Reservation> list2 = mypageService.mypageReservList(memberNo);
		logger.debug("mypageReservList() memberNo = {}", memberNo);		
		
		model.addAttribute("reserv", list2);
		model.addAttribute("team", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);			
				
	return "mypage/mypage";
	}
	
	
}
