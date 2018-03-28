package com.ezground.teamproject.facility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.facilitydto.Facility;
import com.ezground.teamproject.facilitydto.FacilityAndMember;


@Service
@Transactional
public class FacilityService {

	@Autowired
	private FacilityDao facilityDao;

	private static final Logger logger = LoggerFactory.getLogger(FacilityService.class);

	public void facilityInsert(Facility facility) {
		// Controller에서 넘어온 값들 확인
		logger.debug("FacilityService facilityInsert facilityNo = {}", facility.getFacilityNo());
		logger.debug("FacilityService facilityInsert memberNo = {}", facility.getMemberNo());
		logger.debug("FacilityService facilityInsert facilityname = {}", facility.getFacilityName());
		logger.debug("FacilityService facilityInsert facilityPhone = {}", facility.getFacilityPhone());
		logger.debug("FacilityService facilityInsert facilityAddress = {}", facility.getFacilityAddress());
		logger.debug("FacilityService facilityInsert facilityNotice = {}", facility.getFacilityNotice());
		logger.debug("FacilityService facilityInsert facilityDetatil = {}", facility.getFacilityDetail());
		logger.debug("FacilityService facilityInsert facilityPrice = {}", facility.getFacilityPrice());
		logger.debug("FacilityService facilityInsert facilityRefund = {}", facility.getFacilityRefund());
		logger.debug("FacilityService facilityInsert facilityRule = {}", facility.getFacilityRule());
		logger.debug("FacilityService facilityInsert facilityLicenseeNo = {}", facility.getFacilityLicenseeNo());
		logger.debug("FacilityService facilityInsert facilityReturn = {}", facility.getFacilityReturn());
		logger.debug("FacilityService facilityInsert facilityStatus = {}", facility.getFacilityStatus());
		logger.debug("FacilityService facilityInsert facilityWriteDate = {}", facility.getFacilityWriteDate());
		logger.debug("FacilityService facilityInsert facilityGrade = {}", facility.getFacilityGrade());
		logger.debug("FacilityService facilityInsert facilityServiceGrade = {}", facility.getFacilityServiceGrade());
		
		facilityDao.facilityInsert(facility);
	}
	


}
