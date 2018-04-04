package com.ezground.teamproject;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.ezground.teamproject.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private LoginService loginservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session,
			@RequestParam(value="entryNo", defaultValue="0") int entryNo) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<SportEntries> entryList = loginservice.sportEntriesNameSelectList();
		
		logger.debug("loginedPage() sportEntriesName = {}", entryList.get(entryNo).getSportEntriesName());	
		
		
		session.setAttribute("sportEntry", entryList);
		session.setAttribute("currentSportEntry", entryList.get(entryNo));
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/teamMemberInfo/teamMemberInfo", method = RequestMethod.GET)
	public String teamMemberInfo() {
		logger.info("팀 맴버 정보 화면으로으 요청 처리 메서드 호출 성공");
		
		return "teamMemberInfo/teamMemberInfo";
	}
	
	
	
	
}
