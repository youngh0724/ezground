package com.ezground.teamproject.facility;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.facility.dto.Facility;
import com.ezground.teamproject.facility.dto.FacilityAndFacilitySub;
import com.ezground.teamproject.facility.dto.FacilityAndMember;
import com.ezground.teamproject.facility.dto.FacilityCalendar;
import com.ezground.teamproject.facility.dto.FacilityField;
import com.ezground.teamproject.facility.dto.FacilityImage;
import com.ezground.teamproject.facility.dto.FacilitySub;
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
	
	// 구장 등록가능 시설리스트
	public List<Facility> facilityFieldPage(int memberNo){
		logger.debug("FacilityDao facilityFieldPage memberNo = {}", memberNo);
		return sqlSessionTemplate.selectList(mapperRoot+"facilityFieldPage", memberNo);
	}
	
	// 구장 등록 페이지 요청
	public Facility facilityFieldInsrtPage(int facilityNo) {
		logger.debug("FacilityDao facilityFieldInsrtPage facilityNo = {}", facilityNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"facilityFieldInserPage", facilityNo);
	}
	
	// 구장 등록 처리
	public int fieldInsert(FacilityField field) {
		return sqlSessionTemplate.insert(mapperRoot+"fieldInsert", field);
	}
	
	// 부대시설 등록 페이지 요청
	public Facility facilitySubInsertPage(int facilityNo) {
		logger.debug("FacilityDao facilitySubInsertPage facilityNo = {}", facilityNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"facilitySubInsertPage", facilityNo);
	}
	
	public List<FacilitySub> subSelect() {
		return sqlSessionTemplate.selectList(mapperRoot+"facilitySubSelect");
	}
	// 부대시설 등록 페이지 이동시 시설 And 부대시설 리스트 가져가기
	public List<FacilityAndFacilitySub> facilityAndFacilitySub(int facilityNo){
		logger.debug("FacilityDao facilitySubInsertPage facilityNo = {}", facilityNo);
		
		return sqlSessionTemplate.selectList(mapperRoot+"facilityAndFacilitySubList", facilityNo);
	}
	// 부대 시설 등록 처리
	public int facilitySubInsert(FacilityAndFacilitySub facilityAndFacilitySub) {
		return sqlSessionTemplate.insert(mapperRoot+"facilityAndFacilitySub", facilityAndFacilitySub);
	}
	// 부대 시설 번호 가져오기
	public List<Integer> subNoSelect(int facilityNo) {
		return sqlSessionTemplate.selectList(mapperRoot+"subNoSelect", facilityNo);
	}
	// 회원 번호로 시설 이름 가져오기
	public List<Facility> facilitySelect(int memberNo){
		return sqlSessionTemplate.selectList(mapperRoot+"facilitySelect", memberNo);
	}
	// 시설 이름 클릭시 시설 번호로 구장 조회
	public List<FacilityField> facilityInfieldList(int facilityNo){
		return sqlSessionTemplate.selectList(mapperRoot+"facilityInfieldList", facilityNo);
	}
	//
	public List<FacilityCalendar> fieldCalendarList(int fieldNo){
		return sqlSessionTemplate.selectList(mapperRoot+"fieldCalendarList1", fieldNo);
	}
	public List<FacilityCalendar> fieldCalendarList(int fieldNo, String date){
		FacilityCalendar facilityCalendar = new FacilityCalendar();
		facilityCalendar.setCalendarDate(date);
		facilityCalendar.setFieldNo(fieldNo);
		return sqlSessionTemplate.selectList(mapperRoot+"fieldCalendarList", facilityCalendar);
	}
}
