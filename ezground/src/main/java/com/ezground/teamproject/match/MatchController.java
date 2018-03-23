package com.ezground.teamproject.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezground.teamproject.LoginController;

@Controller
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
	
	@RequestMapping(value="/creatMatch", method = RequestMethod.GET)
	public String creatMatch() {
		return "match/matchCreat";
	}
	
	
	
	
}
