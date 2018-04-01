package com.ezground.teamproject.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.member.dto.MemberLogin;
import com.ezground.teamproject.team.dto.Team;
import com.ezground.teamproject.teamMember.TeamMemberDao;
import com.ezground.teamproject.teamMember.dto.TeamMember;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private TeamMemberDao teamMemberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamService.class);
	

	public Map<String, Object> teamSelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("teamSelectListByPage() currentPage = {}", currentPage);
		logger.debug("teamSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("teamSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<Team> list = teamDao.teamSelectPage(map);
		logger.debug("teamSelectListByPage() list = {}", list);
		int totalCount = teamDao.teamSelectTotalCount();
		logger.debug("teamSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
	public Team teamSelectListDetail(int teamNo) {
		logger.debug("teamSelectListDetail() teamNo = {}", teamNo);	
		Team team = teamDao.teamSelectListDetail(teamNo);
		
		return team;
	}
	

	public void teamInsert(Team team, int memberNo) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("teamInsert() teamName = {}", team.getSportEntriesNo());		
		//위에서 뽑아낸 team타입을 insert한다.
		
		teamDao.teamInsert(team);		
		logger.debug("teamInsert() teamNo = {}", team.getTeamNo());
		TeamMember teamMember = new TeamMember();
		
		teamMember.setTeamNo(team.getTeamNo());
		teamMember.setMemberNo(memberNo);
		teamMember.setTeamMemberLevelNo(1);			
		teamMemberDao.teamMemberInsert(teamMember);
		
	}
	
	//컨트롤러에서 수정화면에 사용될 하나의 레코드값을 조회할때 사용되어지는 메서드
	public Team teamSelectOne(int teamNo) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("teamSelectOne() teamId = {}", teamNo);
		//dao에 있는 컨트롤러에서 넘겨받은값과 조건이 일치하는 정보를 조회하는 메서드를 호출하여 team에 할당한다.
		Team team = teamDao.teamSelectOneForUpdate(teamNo);
		//team에 들어있는 값을 확인해본다.
		logger.debug("teamSelectOne() team = {}", team);
		return team;
	}
	//컨트롤러에서 넘겨받은 정보로 db정보를 수정할때 사용되어지는 메서드
	public int teamUpdate(Team team) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("teamUpdate() team = {}", team);
		//dao에 있는 수정기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = teamDao.teamUpdate(team); 
		//row에 들어있는 값을 확인해본다.
		logger.debug("teamUpdate() row = {}", row);
		return row;
	}	
	
		
	//컨트롤러에서 넘겨받은 정보로 db정보를 삭제할때 사용되어지는 메서드
	public int teamMemberDelete(int teamNo, int memberNo) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.		
		logger.debug("teamMemberSelect() TeamNo = {}", teamNo);	
		Map map = new HashMap();
		map.put("teamNo", teamNo);
		map.put("memberNo", memberNo);		
		
		TeamMember teamMember = teamMemberDao.teamMemberSelect(map);
		logger.debug("teamMemberSelect() TeamMember = {}", teamMember);			
		
		if(teamMember.getMemberNo() == memberNo && teamMember.getTeamMemberLevelNo() == 1) {		
			logger.debug("teamDelete() teamNo = {}", teamNo);		
			teamDao.teamDeleteMember(teamNo);		
			int row = teamDao.teamDelete(teamNo);
			logger.debug("teamDelete() row = {}", row);		
			return row;			
			}
			else {
				
				logger.debug("삭제 권한이 없습니다.");	
				return 0;
			}
		
	}
	public Map<String, Object> teamSelectMyTeam(int currentPage, int rowPerPage, String searchWord, int memberNo){
		
		logger.debug("teamSelectMyTeam() currentPage = {}", currentPage);
		logger.debug("teamSelectMyTeam() rowPerPage = {}", rowPerPage);
		logger.debug("teamSelectMyTeam() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("memberNo", memberNo);
		
		List<Team> list = teamDao.teamSelectMyTeam(map);
		logger.debug("teamSelectMyTeam() list = {}", list);
		int totalCount = teamDao.myTeamSelectTotalCount(memberNo);
		logger.debug("teamSelectMyTeam() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
}
