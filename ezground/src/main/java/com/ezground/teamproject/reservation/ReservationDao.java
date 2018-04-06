package com.ezground.teamproject.reservation;

import java.util.List;import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.facility.dto.Facility;
import com.ezground.teamproject.facility.dto.FacilityField;
import com.ezground.teamproject.team.TeamDao;

@Repository
public class ReservationDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "com.ezground.teamproject.reservation.ReservationMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
	
	public List<FacilityField> fieldSelectListByPage(Map map) {
		logger.debug("facilitySelectListByPage() map.startRow = {}", map.get("startRow"));
		logger.debug("facilitySelectListByPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("facilitySelectListByPage() map.searchWord = {}", map.get("searchWord"));
		logger.debug("facilitySelectListByPage() map.sportEntriesName = {}", map.get("sportEntriesName"));
		return sqlSessionTemplate.selectList(mapperRoot+"fieldSelectPage", map);
	}
	public int fieldSelectTotalCount() {
		logger.debug("totalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"fieldSelectCount");	
	}
}
