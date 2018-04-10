package com.ezground.teamproject.reservation;

import java.util.List;import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.facility.dto.Facility;
import com.ezground.teamproject.facility.dto.FacilityAndFacilityField;
import com.ezground.teamproject.team.TeamDao;

@Repository
public class ReservationDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "com.ezground.teamproject.reservation.ReservationMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
	
	public List<FacilityAndFacilityField> fieldSelectListByPage(Map map) {
		logger.debug("fieldSelectListByPage() map.startRow = {}", map.get("startRow"));
		logger.debug("fieldSelectListByPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("fieldSelectListByPage() map.searchWord = {}", map.get("searchWord"));
		logger.debug("fieldSelectListByPage() map.sportEntriesName = {}", map.get("sportEntriesName"));
		return sqlSessionTemplate.selectList(mapperRoot+"fieldSelectPage", map);
	}
	public int fieldSelectTotalCount() {
		logger.debug("fieldtotalCount() 실행확인"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"fieldSelectCount");	
	}
}
