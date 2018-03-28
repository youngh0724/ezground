package com.ezground.teamproject.facility;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezground.teamproject.facilitydto.Facility;
import com.ezground.teamproject.facilitydto.FacilityAndMember;
import com.ezground.teamproject.member.dto.MemberLogin;


@Controller
public class FacilityController {
	private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);
	
	@Autowired
	private FacilityService facilityService;
	
	// facilityInsertForm.jsp 페이지 요청
	@RequestMapping(value="/facility/facilityTest", method = RequestMethod.GET)
	public String facility() {
		return "facility/facilityInsertForm";
	}
	
	// facilityInsert 요청
		@RequestMapping(value="/facility/facilityInsert", method = RequestMethod.POST)
		public String facilityInsert(Facility facility) {
			// facilityService.facilityInsert 확인
			logger.debug("FacilityController facilityInsert facilityNo = {}", facility.getFacilityNo());
			logger.debug("FacilityController facilityInsert memberNo = {}", facility.getMemberNo());
			logger.debug("FacilityController facilityInsert facilityname = {}", facility.getFacilityName());
			logger.debug("FacilityController facilityInsert facilityPhone = {}", facility.getFacilityPhone());
			logger.debug("FacilityController facilityInsert facilityAddress = {}", facility.getFacilityAddress());
			logger.debug("FacilityController facilityInsert facilityNotice = {}", facility.getFacilityNotice());
			logger.debug("FacilityController facilityInsert facilityDetatil = {}", facility.getFacilityDetail());
			logger.debug("FacilityController facilityInsert facilityPrice = {}", facility.getFacilityPrice());
			logger.debug("FacilityController facilityInsert facilityRefund = {}", facility.getFacilityRefund());
			logger.debug("FacilityController facilityInsert facilityRule = {}", facility.getFacilityRule());
			logger.debug("FacilityController facilityInsert facilityLicenseeNo = {}", facility.getFacilityLicenseeNo());
			logger.debug("FacilityController facilityInsert facilityReturn = {}", facility.getFacilityReturn());
			logger.debug("FacilityController facilityInsert facilityStatus = {}", facility.getFacilityStatus());
			logger.debug("FacilityController facilityInsert facilityWriteDate = {}", facility.getFacilityWriteDate());
			logger.debug("FacilityController facilityInsert facilityGrade = {}", facility.getFacilityGrade());
			logger.debug("FacilityController facilityInsert facilityServiceGrade = {}", facility.getFacilityServiceGrade());
			facilityService.facilityInsert(facility);
			return null;
		}
		
	// 관리자용 facility 등록요청 리스트					
		@RequestMapping(value="/facility/masterFacilityInsertStatusList")					
		public String masterFacilityInsertStatusList() {
			return "facility/masterFacilityInsertStatusListForm";		
			
		}



}
