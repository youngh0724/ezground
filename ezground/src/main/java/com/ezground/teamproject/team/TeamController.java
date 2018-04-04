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

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.member.dto.MemberLogin;
import com.ezground.teamproject.team.dto.Team;
import com.ezground.teamproject.teamMember.TeamMemberService;
import com.ezground.teamproject.teamMember.dto.TeamMember;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	@Autowired
	private TeamMemberService teamMemberService;
	

	
	//�Է°��� ���ϰ��� Ȯ�� �ϱ� ���� �ΰ� ��� 
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@RequestMapping(value="/team/teamList", method = RequestMethod.GET)
	public String teamSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
		SportEntries sportEntries = (SportEntries)session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();		
		
		logger.debug("teamSelectList() currentPage = {}", currentPage);
		logger.debug("teamSelectList() rowPerPage = {}", rowPerPage);
		logger.debug("teamSelectPage() searchWord = {}", searchWord);
		Map map = teamService.teamSelectListByPage(currentPage, rowPerPage, searchWord, sportEntriesNo);
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
	public String teamSelectListDetail(Model model, 
										@RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamSelectListDetail() teamNo = {}", teamNo);
		Team team = teamService.teamSelectListDetail(teamNo);		
			
		model.addAttribute("team", team);
		
		return "team/teamDetail";
	}	
	
	//teamInserForm �Է���  view������ ��û
	@RequestMapping(value="/team/teamInsert", method = RequestMethod.GET)
    public String teamInsert() {
	
		//ó���ϴ� ������ ���⶧���� �޼��尡 ����Ǿ����� Ȯ���ϱ����� ���ڿ��� ����غ���.
		logger.debug("teamInsert() ����Ȯ��"); 
		
        return "team/teamInsert";
    }
	
	//teamInserForm �Է������� �Է¹��� ���� db�� �Է��ϴ� �޼��带 ȣ��
	@RequestMapping(value="/team/teamInsert", method = RequestMethod.POST)
    public String teamInsert(Team team, HttpSession session) {			
		logger.debug("teamInsert() teamName = {}", team.getTeamName());		
		//dao�� insert�޼��带 ȣ���Ͽ� db�� �Է��� �����Ѵ�.
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		SportEntries sportEntries = (SportEntries)session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		
		teamService.teamInsert(team, memberNo, sportEntriesNo);			
		
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
	public String teamDelete(Model model, HttpSession session, @RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamDelete() teamNo = {}", teamNo);	
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		teamService.teamMemberDelete(teamNo, memberNo);					

		//�Է¹��� ���̵��� �̿��Ͽ� �����ϴ� ����� �޼��� ȣ��			
		//����Ʈ�������� �����̷�Ʈ ��Ų��.
		return "redirect:/team/teamList";
	}
	
	@RequestMapping(value="/team/teamManagement", method = RequestMethod.GET)
	public String myTeamSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
						
		logger.debug("myTeamSelectList() currentPage = {}", currentPage);
		logger.debug("myTeamSelectList() rowPerPage = {}", rowPerPage);
		logger.debug("myTeamSelectPage() searchWord = {}", searchWord);
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		logger.debug("myTeamSelectPage() memberNo = {}", memberNo);
		Map map = teamService.teamSelectMyTeam(currentPage, rowPerPage, searchWord, memberNo);
		//list�� ����ִ� ���� Ȯ���غ���.
		logger.debug("myTeamSeletList() map = {}", map);			
		
		List<Team> list = (List<Team>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db���� �޾ƿ� ������� model�� �����Ѵ�.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "team/teamManagement";
	}	
	

}
