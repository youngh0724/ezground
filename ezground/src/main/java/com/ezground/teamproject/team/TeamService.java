package com.ezground.teamproject.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	

	public Map<String, Object> teamSelectListByPage(int currentPage, int rowPerPage, String searchWord, int sportEntriesNo){
		
		logger.debug("teamSelectListByPage() currentPage = {}", currentPage);
		logger.debug("teamSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("teamSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("sportEntriesNo", sportEntriesNo);
		
		List<Team> list = teamDao.teamSelectListByPage(map);
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
	

	public void teamInsert(Team team, int memberNo, int sportEntryNo) {
		//��Ʈ�ѷ����� �Ѱܹ��� ���� Ȯ���غ���.
		logger.debug("teamInsert() teamName = {}", team.getSportEntriesNo());		
		//������ �̾Ƴ� teamŸ���� insert�Ѵ�.
		
		teamDao.teamInsert(team);		
		logger.debug("teamInsert() teamNo = {}", team.getTeamNo());
		TeamMember teamMember = new TeamMember();
		
		teamMember.setTeamNo(team.getTeamNo());
		teamMember.setMemberNo(memberNo);
		teamMember.setTeamMemberLevelNo(1);		
		teamMemberDao.teamMemberInsert(teamMember);
		
	}
	
	//��Ʈ�ѷ����� ����ȭ�鿡 ���� �ϳ��� ���ڵ尪�� ��ȸ�Ҷ� ���Ǿ����� �޼���
	public Team teamSelectOne(int teamNo) {
		//��Ʈ�ѷ����� �Ѱܹ��� ���� Ȯ���غ���.
		logger.debug("teamSelectOne() teamId = {}", teamNo);
		//dao�� �ִ� ��Ʈ�ѷ����� �Ѱܹ������� ������ ��ġ�ϴ� ������ ��ȸ�ϴ� �޼��带 ȣ���Ͽ� team�� �Ҵ��Ѵ�.
		Team team = teamDao.teamSelectOneForUpdate(teamNo);
		//team�� ����ִ� ���� Ȯ���غ���.
		logger.debug("teamSelectOne() team = {}", team);
		return team;
	}
	//��Ʈ�ѷ����� �Ѱܹ��� ������ db������ �����Ҷ� ���Ǿ����� �޼���
	public int teamUpdate(Team team) {
		//��Ʈ�ѷ����� �Ѱܹ��� ���� Ȯ���غ���.
		logger.debug("teamUpdate() team = {}", team);
		//dao�� �ִ� ��������� �޼��带 ȣ���ϰ� ���(db�� ������ �Ͼ ���)�� row�� �Ҵ��Ѵ�.
		int row = teamDao.teamUpdate(team); 
		//row�� ����ִ� ���� Ȯ���غ���.
		logger.debug("teamUpdate() row = {}", row);
		return row;
	}	
	
		
	//��Ʈ�ѷ����� �Ѱܹ��� ������ db������ �����Ҷ� ���Ǿ����� �޼���
	public int teamMemberDelete(int teamNo, int memberNo) {
		//��Ʈ�ѷ����� �Ѱܹ��� ���� Ȯ���غ���.		
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
				
				logger.debug("���� ������ �����ϴ�.");	
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