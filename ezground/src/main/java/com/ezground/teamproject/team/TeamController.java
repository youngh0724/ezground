package com.ezground.teamproject.team;

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

import com.ezground.teamproject.team.dto.Team;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	//�Է°��� ���ϰ��� Ȯ�� �ϱ� ���� �ΰ� ��� 
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@RequestMapping(value="/team/teamList", method = RequestMethod.GET)
	public String teamSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
						
		logger.debug("teamSelectList() currentPage = {}", currentPage);
		logger.debug("teamSelectList() rowPerPage = {}", rowPerPage);
		logger.debug("teamSelectPage() searchWord = {}", searchWord);
		Map map = teamService.teamSelectListByPage(currentPage, rowPerPage, searchWord);
		//list�� ����ִ� ���� Ȯ���غ���.
		logger.debug("teamSelcetList() map = {}", map);
		
		List<Team> list = (List<Team>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db���� �޾ƿ� ������� model�� �����Ѵ�.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "team/teamList";
	}
	
	@RequestMapping(value="/team/teamDetail", method = RequestMethod.GET)
	public String teamSelectListDetail(Model model, HttpSession session, 
										@RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamSelectListDetail() teamNo = {}", teamNo);
		
		String returnStr = "redirect:/team/teamDetail";		
		return returnStr;
	}
}
