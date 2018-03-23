package com.ezground.teamproject.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.team.dto.Team;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamService.class);
	

	public Map<String, Object> teamSelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("movieSelectListByPage() currentPage = {}", currentPage);
		logger.debug("movieSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("movieSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<Team> list = teamDao.teamSelectPage(map);
		logger.debug("movieSelectListByPage() list = {}", list);
		int totalCount = teamDao.teamSelectTotalCount();
		logger.debug("movieSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}


}
