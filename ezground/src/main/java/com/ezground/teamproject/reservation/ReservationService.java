package com.ezground.teamproject.reservation;

import java.util.HashMap;import java.util.List;import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.facility.dto.FacilityAndFacilityField;
import com.ezground.teamproject.reservation.dto.Reservation;


@Service
@Transactional
public class ReservationService {
	
	@Autowired
	private Reservation reservation;
	
	@Autowired
	private ReservationDao reservationDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
	
	public Map<String, Object> fieldSelectListByPage(int currentPage, int rowPerPage, String searchWord, String sportEntriesName){
		
		logger.debug("fieldSelectListByPage() currentPage = {}", currentPage);
		logger.debug("fieldSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("fieldSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("sportEntriesName", sportEntriesName);
		
		List<FacilityAndFacilityField> list = reservationDao.fieldSelectListByPage(map);
		logger.debug("fieldSelectListByPage() list = {}", list);
		int totalCount = reservationDao.fieldSelectTotalCount();
		logger.debug("fieldSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
	public FacilityAndFacilityField fieldSelectListDetail(int fieldNo) {
		logger.debug("facilityFieldSelectListDetail() FieldNo = {}", fieldNo);	
		FacilityAndFacilityField facilityAndFacilityField = reservationDao.fieldSelectListDetail(fieldNo);
		
		return facilityAndFacilityField;
	}
	
	public List<Reservation> reservationSelect(int fieldNo, int calendarNo) {
		logger.debug("reservationSelect() FieldNo = {}", fieldNo);
		logger.debug("reservationSelect() FieldNo = {}", calendarNo);
		
		reservation.setCalendarNo(calendarNo);
		reservation.setFieldNo(fieldNo);
		
		List<Reservation> list = reservationDao.reservationSelect(reservation);
		
		return list;
	}
}