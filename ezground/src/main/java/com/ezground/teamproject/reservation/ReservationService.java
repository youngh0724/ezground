package com.ezground.teamproject.reservation;

import java.util.HashMap;import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.facility.FacilityDao;
import com.ezground.teamproject.facility.dto.FacilityField;
import com.ezground.teamproject.team.dto.Team;
import com.ezground.teamproject.teamMember.TeamMemberDao;
import com.ezground.teamproject.teamMember.TeamMemberService;

@Service
@Transactional
public class ReservationService {
	
	@Autowired
	private ReservationDao reservationDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamMemberService.class);
	
	public Map<String, Object> fieldSelectListByPage(int currentPage, int rowPerPage, String searchWord, String sportEntriesName){
		
		logger.debug("facilitySelectListByPage() currentPage = {}", currentPage);
		logger.debug("facilitySelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("facilitySelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("sportEntriesName", sportEntriesName);
		
		List<FacilityField> list = reservationDao.fieldSelectListByPage(map);
		logger.debug("teamSelectListByPage() list = {}", list);
		int totalCount = reservationDao.fieldSelectTotalCount();
		logger.debug("teamSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}

}
