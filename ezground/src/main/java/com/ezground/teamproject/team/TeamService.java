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
import com.ezground.teamproject.teamMember.dto.TeamMember;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
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
	

	public void teamInsert(Team team) {
		//��Ʈ�ѷ����� �Ѱܹ��� ���� Ȯ���غ���.
		logger.debug("teamInsert() teamName = {}", team.getTeamName());		
		
		team.setSportEntriesNo(team.getSportEntriesNo());
		team.setTeamName(team.getTeamName());
		team.setTeamAges(team.getTeamAges());
		team.setTeamCreatedDate(team.getTeamCreatedDate());
		team.setTeamIntro(team.getTeamIntro());
		team.setTeamRegion(team.getTeamRegion());		
	
		//������ �̾Ƴ� teamŸ���� insert�Ѵ�.
		teamDao.teamInsert(team);
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
	public int teamDelete(int teamNo) {
		//��Ʈ�ѷ����� �Ѱܹ��� ���� Ȯ���غ���.
		logger.debug("teamDelete() teamNo = {}", teamNo);
		int row = teamDao.teamDelete(teamNo);
		
		logger.debug("teamDelete() row = {}", row);
		return row;
	
	}
}
