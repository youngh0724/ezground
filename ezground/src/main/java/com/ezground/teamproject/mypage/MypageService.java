package com.ezground.teamproject.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.team.TeamDao;
import com.ezground.teamproject.team.dto.Team;


@Service
@Transactional
public class MypageService {

	@Autowired
	private MypageDao mypageDao;
	@Autowired
	private TeamDao teamDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MypageService.class);

	public Map<String, Object> mypageTeamList(int currentPage, int rowPerPage) {
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		
		List<Team> list = teamDao.teamSelectListByPage(map);
		logger.debug("mypageService() list = {}", list);
		int totalCount = teamDao.teamSelectTotalCount();
		logger.debug("teamSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
		
	}
}
