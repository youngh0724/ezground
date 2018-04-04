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
	

	
	//입력값과 리턴값을 확인 하기 위한 로거 기능 
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
		//list에 들어있는 값을 확인해본다.
		logger.debug("teamSeletList() map = {}", map);
		
		List<Team> list = (List<Team>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
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
	
	//teamInserForm 입력폼  view파일을 요청
	@RequestMapping(value="/team/teamInsert", method = RequestMethod.GET)
    public String teamInsert() {
	
		//처리하는 내용이 없기때문에 메서드가 실행되었는지 확인하기위해 문자열을 출력해본다.
		logger.debug("teamInsert() 실행확인"); 
		
        return "team/teamInsert";
    }
	
	//teamInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드를 호출
	@RequestMapping(value="/team/teamInsert", method = RequestMethod.POST)
    public String teamInsert(Team team, HttpSession session) {			
		logger.debug("teamInsert() teamName = {}", team.getTeamName());		
		//dao에 insert메서드를 호출하여 db에 입력을 수행한다.
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		SportEntries sportEntries = (SportEntries)session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		
		teamService.teamInsert(team, memberNo, sportEntriesNo);			
		
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/team/teamList";
        
    }
	
	@RequestMapping(value="/team/teamUpdate", method = RequestMethod.GET)
	public String teamSelectOne( Model model, HttpSession session, @RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamSelectOne() teamNo = {}", teamNo);		
	
		//매개변수로 받은 teamId값을 이요하여 하나의 team객체를 리턴받는다.
		Team team = teamService.teamSelectOne(teamNo);		
		logger.debug("teamSelectOne() teamName = {}", team.getTeamName());
		//리턴받은 team객체를 model에 세팅한다.
		model.addAttribute("team", team);
		//업데이트폽으로 포워드 시킨다.
		return "team/teamUpdate";
	}
	
	//업데이트 action요청
	@RequestMapping(value="/team/teamUpdate", method = RequestMethod.POST)
    public String teamUpdate(HttpSession session, Team team) {		
		logger.debug("teamUpdate() teamName = {}", team.getTeamName());		
	
		//입력받은 정보를 매개변수로하여 db정보를 update시킨다.
		teamService.teamUpdate(team);
        //리스트페이지로 리다이렉트 시킨다.
        return "redirect:/team/teamList";
    }
//삭제 action 요청
	@RequestMapping(value="/team/teamDelete", method = RequestMethod.GET)
	public String teamDelete(Model model, HttpSession session, @RequestParam(value="teamNo", required=true) int teamNo) {
		logger.debug("teamDelete() teamNo = {}", teamNo);	
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		teamService.teamMemberDelete(teamNo, memberNo);					

		//입력받은 아이디값을 이용하여 삭제하는 기능의 메서드 호출			
		//리스트페이지로 리다이렉트 시킨다.
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
		//list에 들어있는 값을 확인해본다.
		logger.debug("myTeamSeletList() map = {}", map);			
		
		List<Team> list = (List<Team>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
		//db에서 받아온 결과값을 model에 세팅한다.
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "team/teamManagement";
	}	
	

}
