package com.ezground.teamproject.facility;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.facilitydto.Facility;
import com.ezground.teamproject.facilitydto.FacilityAndMember;
import com.ezground.teamproject.member.dto.Member;

@Repository
public class FacilityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "com.ezground.teamproject.FacilityMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityService.class);

	public int facilityInsert(Facility facility) {
		logger.debug("FacilityDao facilityInsert facilityNo = {}", facility.getFacilityNo());
		logger.debug("FacilityDao facilityInsert memberNo = {}", facility.getMemberNo());
		logger.debug("FacilityDao facilityInsert facilityname = {}", facility.getFacilityName());
		logger.debug("FacilityDao facilityInsert facilityPhone = {}", facility.getFacilityPhone());
		logger.debug("FacilityDao facilityInsert facilityAddress = {}", facility.getFacilityAddress());
		logger.debug("FacilityDao facilityInsert facilityNotice = {}", facility.getFacilityNotice());
		logger.debug("FacilityDao facilityInsert facilityDetatil = {}", facility.getFacilityDetail());
		logger.debug("FacilityDao facilityInsert facilityPrice = {}", facility.getFacilityPrice());
		logger.debug("FacilityDao facilityInsert facilityRefund = {}", facility.getFacilityRefund());
		logger.debug("FacilityDao facilityInsert facilityRule = {}", facility.getFacilityRule());
		logger.debug("FacilityDao facilityInsert facilityLicenseeNo = {}", facility.getFacilityLicenseeNo());
		logger.debug("FacilityDao facilityInsert facilityReturn = {}", facility.getFacilityReturn());
		logger.debug("FacilityDao facilityInsert facilityStatus = {}", facility.getFacilityStatus());
		logger.debug("FacilityDao facilityInsert facilityWriteDate = {}", facility.getFacilityWriteDate());
		logger.debug("FacilityDao facilityInsert facilityGrade = {}", facility.getFacilityGrade());
		logger.debug("FacilityDao facilityInsert facilityServiceGrade = {}", facility.getFacilityServiceGrade());
		
		return sqlSessionTemplate.insert(mapperRoot+"facilityInsert", facility);
		
	}


}
