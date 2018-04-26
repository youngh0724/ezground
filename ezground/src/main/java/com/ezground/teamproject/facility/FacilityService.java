package com.ezground.teamproject.facility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.facility.dto.Facility;
import com.ezground.teamproject.facility.dto.FacilityAndFacilityImage;
import com.ezground.teamproject.facility.dto.FacilityAndFacilitySub;
import com.ezground.teamproject.facility.dto.FacilityAndMember;
import com.ezground.teamproject.facility.dto.FacilityCalendar;
import com.ezground.teamproject.facility.dto.FacilityField;
import com.ezground.teamproject.facility.dto.FacilityImage;
import com.ezground.teamproject.facility.dto.FacilitySub;
import com.ezground.teamproject.match.dto.MatchNotice;
import com.ezground.teamproject.teamMember.dto.TeamMember;


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
	
	// 사업자 --> 자신이 시설 등록신청 요청한 정보 보기
	public List<Facility> facilityInsertStatusList(int memberNo) {
		logger.debug("FacilityService facilityInsertStatusList memberNo = {}", memberNo);
		List<Facility> list = facilityDao.facilityInsertStatusList(memberNo);
		return list;
	}
	
	// 사업자 --> 자신이 시설 등록신청 요청한 정보수정 페이지 요청
	public Facility facilitySelectOne(int facilityNo) {
		logger.debug("FacilityService facilitySelectOne facilityNo = {}", facilityNo);
		Facility facility = facilityDao.facilitySelectOne(facilityNo);
		return facility;
	}
	
	// 시설 수정등록 처리요청
	public void facilityInsertUpdate(Facility facility) {
		logger.debug("FacilityService facilityInsertUpdate facility = {}", facility);
		facilityDao.facilityInsertUpdate(facility);
	}
	
	// 시설 정보 or 이미지 등록 처리요청
	
	public void facilityAndFaiclityImageInsert(FacilityAndFacilityImage facilityAndFacilityImage, String path) {
		// 컨트롤러에서 넘겨받은 시설번호 값을 확인
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityNo = {}", facilityAndFacilityImage.getFacilityNo());
		logger.debug("FacilityService facilityAndFaiclityImageInsert memberNo = {}", facilityAndFacilityImage.getMemberNo());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityname = {}", facilityAndFacilityImage.getFacilityName());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityPhone = {}", facilityAndFacilityImage.getFacilityPhone());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityAddress = {}", facilityAndFacilityImage.getFacilityAddress());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityNotice = {}", facilityAndFacilityImage.getFacilityNotice());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityDetatil = {}", facilityAndFacilityImage.getFacilityDetail());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityPrice = {}", facilityAndFacilityImage.getFacilityPrice());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityRefund = {}", facilityAndFacilityImage.getFacilityRefund());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityRule = {}", facilityAndFacilityImage.getFacilityRule());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityLicenseeNo = {}", facilityAndFacilityImage.getFacilityLicenseeNo());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityReturn = {}", facilityAndFacilityImage.getFacilityReturn());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityStatus = {}", facilityAndFacilityImage.getFacilityStatus());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityWriteDate = {}", facilityAndFacilityImage.getFacilityWriteDate());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityGrade = {}", facilityAndFacilityImage.getFacilityGrade());
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityServiceGrade = {}", facilityAndFacilityImage.getFacilityServiceGrade());
		
		// 시설 정보 입력 처리 요청
		Facility facility = new Facility();
		facility.setFacilityNo(facilityAndFacilityImage.getFacilityNo());
		facility.setMemberNo(facilityAndFacilityImage.getMemberNo());
		facility.setFacilityName(facilityAndFacilityImage.getFacilityName());
		facility.setFacilityPhone(facilityAndFacilityImage.getFacilityPhone());
		facility.setFacilityAddress(facilityAndFacilityImage.getFacilityAddress());
		facility.setFacilityNotice(facilityAndFacilityImage.getFacilityNotice());
		facility.setFacilityDetail(facilityAndFacilityImage.getFacilityDetail());
		facility.setFacilityPrice(facilityAndFacilityImage.getFacilityPrice());
		facility.setFacilityRefund(facilityAndFacilityImage.getFacilityRefund());
		facility.setFacilityRule(facilityAndFacilityImage.getFacilityRule());
		facility.setFacilityLicenseeNo(facilityAndFacilityImage.getFacilityLicenseeNo());
		facility.setFacilityReturn(facilityAndFacilityImage.getFacilityReturn());
		facility.setFacilityStatus(facilityAndFacilityImage.getFacilityStatus());
		
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityNo실행전 = {}", facility.getFacilityNo());
		facilityDao.facilityInsert(facility);
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityNo실행후 = {}", facility.getFacilityNo());
		
		
		int facilityNo = facility.getFacilityNo();
		logger.debug("FacilityService facilityAndFaiclityImageInsert facilityNo = {}", facility.getFacilityNo());
		
		
		for(MultipartFile files : facilityAndFacilityImage.getFiles()) {
			FacilityImage facilityImage = new FacilityImage();
			// 겹치지 않는 값을 사용하기위해 랜덤UUID메서드를 사용하여 오리지널 파일이름 대신 사용한다.
			UUID uuid = UUID.randomUUID();
			String imageRandomName = uuid.toString().toString().replaceAll("_", ""); //중복 되지 않는 랜덤 이름값 표현
			// 오리지널 파일 이름
			String imageOriginalName = files.getOriginalFilename();
			logger.debug("FacilityService facilityAndFaiclityImageInsert imageOriginalName = {}", files.getOriginalFilename());
			// 오리지널 파일이름에서 .이 마지막 몇번쨰에 있는지 반환.
			int pos = imageOriginalName.lastIndexOf(".");
			// 오리지널 파일이름에서 pos+1 번쨰까지의 문자열을 잘라낸다.
			String imageExt = imageOriginalName.substring(pos + 1);
			// 도메인 image 셋팅
			facilityImage.setImageOriginalName(imageOriginalName);
			facilityImage.setImageRandomName(imageRandomName);
			facilityImage.setFacilityNo(facilityNo);
			facilityImage.setImagePath(path);
			facilityImage.setImageExt(imageExt);
			
			logger.debug("FacilityService facilityAndFaiclityImageInsert imageOriginalName = {}", facilityImage.getImageOriginalName());
			logger.debug("FacilityService facilityAndFaiclityImageInsert imageRandomName = {}", facilityImage.getImageRandomName());
			logger.debug("FacilityService facilityAndFaiclityImageInsert facilityNo = {}", facilityImage.getFacilityNo());
			logger.debug("FacilityService facilityAndFaiclityImageInsert path = {}", facilityImage.getImagePath());
			logger.debug("FacilityService facilityAndFaiclityImageInsert imageExt = {}", facilityImage.getImageExt());
			
			//지정한 경로의 디렉토리 객체 생성
			File directory = new File(path+"/field/");
			if(!directory.exists()) {
				directory.mkdirs();
			} else {
				
			// path 경로에 파일저장 이름+확장자
			File temp = new File(path + "/facilityImageFileUpload/", imageRandomName+"."+imageExt);
			logger.debug("FacilityService facilityAndFaiclityImageInsert temp = {}", temp);
			
			try {	
				files.transferTo(temp);
				facilityDao.facilityAndFaiclityImageInsert(facilityImage);
					} catch (IllegalStateException e) {
					e.printStackTrace();
					} catch (IOException e) {
					e.printStackTrace();
					}
					}
			}
		}
	
	// 구장 등록 가능 시설 리스트
	public List<Facility> facilityFieldPage(int memberNo){
			List<Facility> facility = facilityDao.facilityFieldPage(memberNo);
			logger.debug("FacilityService facilityFieldPage memberNo = {}", memberNo);
		return facility;
	}
	
	// 구장 등록 페이지 요청
	public Facility facilityFieldInsrtPage(int facilityNo) {
		logger.debug("FacilityService facilityFieldInsrtPage facilityNo = {}", facilityNo);
		Facility facility = facilityDao.facilityFieldInsrtPage(facilityNo);
		return facility;
	}
	
	// 구장 등록 처리 요청
	public void fieldInsert(FacilityField field) {
		logger.debug("FacilityField fieldInsert FacilityNo = {}", field.getFacilityNo());
		logger.debug("FacilityField fieldInsert SportEntriesName = {}", field.getSportEntriesName());
		logger.debug("FacilityField fieldInsert FieldName = {}", field.getFieldName());
		logger.debug("FacilityField fieldInsert FieldSize = {}", field.getFieldSize());
		logger.debug("FacilityField fieldInsert FieldPrice = {}", field.getFieldPrice());
		logger.debug("FacilityField fieldInsert FieldPeopleNumber = {}", field.getFieldPeopleNumber());
		 facilityDao.fieldInsert(field);
	}
	// 부대 시설 등록 페이지 요청
	public Facility facilitySubInsertPage(int facilityNo) {
		logger.debug("FacilityService facilitySubInsertPage facilityNo = {}", facilityNo);
		Facility facility = facilityDao.facilitySubInsertPage(facilityNo);
		return facility;
	}
	// 부대 시설 등록 페이지 요청시 부대시설 정보 가져오기
	public List<FacilitySub> subSelect() {
		List<FacilitySub> facilitySub = facilityDao.subSelect();
		return facilitySub;
	}
	
	// 부대 시설 등록 페이지 요청시 시설 AND 부대시설 리스트 가져오기
	public List<FacilityAndFacilitySub> facilityAndFacilitySub(int facilityNo){
		logger.debug("FacilityService facilityAndFacilitySub facilityNo = {}", facilityNo);
		List<FacilityAndFacilitySub> facilityAndFacilitySub = facilityDao.facilityAndFacilitySub(facilityNo);
		logger.debug("FacilityService facilityAndFacilitySub facilityAndFacilitySub = {}", facilityAndFacilitySub);
		return facilityAndFacilitySub;
	}
	// 부대 시설 등록
	public void facilitySubInsert(FacilityAndFacilitySub facilityAndFacilitySub) {
		int subNo = facilityAndFacilitySub.getSubNo();
		int facilityNo = facilityAndFacilitySub.getFacilityNo();
		List<Integer> intarr = facilityDao.subNoSelect(facilityNo);
		boolean flag = true;
		for(int arrNo : intarr){
			if(arrNo == subNo) {
				flag = false;
			}
		}
		if(flag) {
			facilityDao.facilitySubInsert(facilityAndFacilitySub);
		}		
	}
	
	public int facilitySubDelete(int facilityNo, int subNo) {
		logger.debug("facilitySubDelete() facilityNo= {}", facilityNo);
		Map map = new HashMap();
		map.put("facilityNo", facilityNo);
		map.put("subNo", subNo);
		
		int row = facilityDao.facilitySubDelete(map);
		return row; 
	}
	// 회원 번호로 시설 이름 꺼내오기
	public List<Facility> facilitySelect(int memberNo){
		logger.debug("FacilityService facilitySelect memberNo = {}", memberNo);
		List<Facility> list = facilityDao.facilitySelect(memberNo);
		return list;
	}
	// 시설 이름 클릭시 시설 번호로 구장 조회
	public List<FacilityField> facilityInfieldList(int facilityNo){
		logger.debug("FacilityService facilityInfieldList facilityNo = {}", facilityNo);
		List<FacilityField> list = facilityDao.facilityInfieldList(facilityNo);
		return list;
	}
	//modal.일정리스트(보류)
	public List<FacilityCalendar> fieldCalendarList(int fieldNo){
		logger.debug("FacilityService fieldCalendarList fieldNo = {}", fieldNo);
		List<FacilityCalendar> list = facilityDao.fieldCalendarList(fieldNo);
		return list;
	}
	//구장 일정리스트 페이지 화면
	public List<FacilityCalendar> fieldCalendarList(int fieldNo, String date){
		logger.debug("FacilityService fieldCalendarList fieldNo = {}", fieldNo);
		List<FacilityCalendar> list= facilityDao.fieldCalendarList(fieldNo, date);
		return list;
		
	}
	
	public int facilityDelete(int facilityNo, int memberNo) {
		
		logger.debug("facilityDelete() facilityNo = {}", facilityNo);	
		Map map = new HashMap();
		map.put("facilityNo", facilityNo);
		map.put("memberNo", memberNo);							
		Facility facility = facilityDao.facilitySelectOne(facilityNo);
		
		if(facility.getMemberNo() == memberNo) {		
			logger.debug("facilityDelete() facilityNo = {}", facilityNo);		
			int row = facilityDao.facilityDelete(facilityNo);
			logger.debug("facilityDelete() row = {}", row);		
			return row;			
			}
			else {
				
				logger.debug("시설 등록 정보 삭제 권한이 없습니다.");	
				return 0;
			}
	}
	
}
