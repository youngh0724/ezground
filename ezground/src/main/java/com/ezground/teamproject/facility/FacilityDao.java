package com.ezground.teamproject.facility;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.facilitydto.Facility;
import com.ezground.teamproject.facilitydto.FacilityAndMember;
import com.ezground.teamproject.facilitydto.FacilityField;
import com.ezground.teamproject.facilitydto.FacilityImage;
import com.ezground.teamproject.member.dto.Member;

@Repository
public class FacilityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "com.ezground.teamproject.FacilityMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityService.class);
	
	// 시설 등록 처리요청
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
	// 사업자가 신청한 시설 등록신청 요청 리스트 조회
	public List<Facility> memberFacilityInsertStatusList(int memberNo) {
		logger.debug("FacilityDao memberFacilityInsertStatusList memberNo = {}", memberNo);
		return sqlSessionTemplate.selectList(mapperRoot+"memberfacilitySelectList", memberNo);
	}
	// 사업자가 신청한 시설등록 신청 요청 수정화면페이지 처리
	public Facility facilitySelectOne(int facilityNo) {
		logger.debug("FacilityDao facilitySelectOne facilityNo = {}", facilityNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"facilitySelectOne", facilityNo);
	}
	
	// 시설 정보 수정 처리
	public int facilityInsertUpdate(Facility facility) {
		logger.debug("FacilityDao facilityInsertUpdate facilityNo = {}", facility);
		return sqlSessionTemplate.update(mapperRoot+"facilityInsertUpdate", facility); 
	}
	
	// 시설 이미지 등록 처리
	public int facilityAndFaiclityImageInsert(FacilityImage facilityImage) {
		logger.debug("FacilityDao facilityAndFaiclityImageInsert facilityNo = {}", facilityImage.getFacilityNo());
		logger.debug("FacilityDao facilityAndFaiclityImageInsert facilityNo = {}", facilityImage.getImageOriginalName());
		logger.debug("FacilityDao facilityAndFaiclityImageInsert facilityNo = {}", facilityImage.getImageRandomName());
		logger.debug("FacilityDao facilityAndFaiclityImageInsert facilityNo = {}", facilityImage.getImagePath());
		logger.debug("FacilityDao facilityAndFaiclityImageInsert facilityNo = {}", facilityImage.getImageExt());
		return sqlSessionTemplate.update(mapperRoot+"facilityImageInsert", facilityImage); 
	}
	
	public List<Facility> facilityStatusSelectList(int memberNo) {
		logger.debug("FacilityDao facilityStatusSelectList memberNo = {}", memberNo);
		return sqlSessionTemplate.selectList(mapperRoot+"facilityStatusSelectList2", memberNo); 
	}
	
	/* 구장등록페이지 이동시 종목 리스트 뿌려주기
	public List<SportEntries> selectSportEntriesName() {
	
		return sqlSessionTemplate.selectList(mapperRoot+"selectSportEntriesName"); 
	}
	*/
	// 구장 등록123123
	public int facilityFieldInsert(FacilityField facilityField) {
		logger.debug("FacilityDao facilityFieldInsert fieldName = {}", facilityField.getFieldName());
		logger.debug("FacilityDao facilityFieldInsert fieldSize = {}", facilityField.getFieldSize());
		logger.debug("FacilityDao facilityFieldInsert fieldPrice = {}", facilityField.getFieldPrice());
		logger.debug("FacilityDao facilityFieldInsert facilityNumber = {}", facilityField.getFieldNumber());
		return sqlSessionTemplate.update(mapperRoot+"facilityFieldInsert", facilityField); 
	}
	
	// 구장 등록가능 시설리스트
	public List<Facility> facilityFieldPage(int memberNo){
		return sqlSessionTemplate.selectList(mapperRoot+"facilityFieldPage", memberNo);
	}
	
	
}
