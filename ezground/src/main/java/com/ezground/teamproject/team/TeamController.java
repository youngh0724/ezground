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
		logger.debug("teamSeletList() map = {}", map);
		
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
		Team team = teamService.teamSelectListDetail(teamNo);		
			
		model.addAttribute("team", team);
		
		return "team/teamDetail";
	}	
	
	//teamInserForm �Է���  view������ ��û
	@RequestMapping(value="/team/teamInsert", method = RequestMethod.GET)
    public String teamInsert(HttpSession session) {
		//ó���ϴ� ������ ���⶧���� �޼��尡 ����Ǿ����� Ȯ���ϱ����� ���ڿ��� ����غ���.
		logger.debug("teamInsert() ����Ȯ��"); 
			
        return "team/teamInsert";
    }
	
	//teamInserForm �Է������� �Է¹��� ���� db�� �Է��ϴ� �޼��带 ȣ��
	@RequestMapping(value="/team/teamInsert", method = RequestMethod.POST)
    public String teamInsert(Team team) {			
		logger.debug("teamInsert() teamName = {}", team.getTeamName());		
		//dao�� insert�޼��带 ȣ���Ͽ� db�� �Է��� �����Ѵ�.
		teamService.teamInsert(team);
        //����Ʈ�������� �����̷�Ʈ ��Ų��.
        return "redirect:/team/teamList";
    }
	
	@RequestMapping(value="/team/teamUpdate", method = RequestMethod.GET)
	public String teamSelectOne( Model model, HttpSession session, @RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamSelectOne() teamNo = {}", teamNo);		
	
		//�Ű������� ���� teamId���� �̿��Ͽ� �ϳ��� team��ü�� ���Ϲ޴´�.
		Team team = teamService.teamSelectOne(teamNo);		
		logger.debug("teamSelectOne() teamName = {}", team.getTeamName());
		//���Ϲ��� team��ü�� model�� �����Ѵ�.
		model.addAttribute("team", team);
		//������Ʈ������ ������ ��Ų��.
		return "team/teamUpdate";
	}
	
	//������Ʈ action��û
	@RequestMapping(value="/team/teamUpdate", method = RequestMethod.POST)
    public String teamUpdate(HttpSession session, Team team) {		
		logger.debug("teamUpdate() teamName = {}", team.getTeamName());		
	
		//�Է¹��� ������ �Ű��������Ͽ� db������ update��Ų��.
		teamService.teamUpdate(team);
        //����Ʈ�������� �����̷�Ʈ ��Ų��.
        return "redirect:/team/teamList";
    }
//���� action ��û
	@RequestMapping(value="/team/teamDelete", method = RequestMethod.GET)
	public String teamDelete(HttpSession session, @RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamDelete() teamNo = {}", teamNo);	
	
		
		//�Է¹��� ���̵��� �̿��Ͽ� �����ϴ� ����� �޼��� ȣ��
		teamService.teamDelete(teamNo);
		//����Ʈ�������� �����̷�Ʈ ��Ų��.
		return "redirect:/team/teamList";
	}

}
