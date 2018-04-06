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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezground.teamproject.facility.dto.Facility;
import com.ezground.teamproject.facility.dto.FacilityAndFacilityImage;
import com.ezground.teamproject.facility.dto.FacilityAndFacilitySub;
import com.ezground.teamproject.facility.dto.FacilityField;
import com.ezground.teamproject.facility.dto.FacilitySub;
import com.ezground.teamproject.member.dto.MemberLogin;


@Controller
public class FacilityController {
	private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);
	
	@Autowired
	private FacilityService facilityService;
	
	// facilityInsertForm.jsp 페이지 요청
	@RequestMapping(value="/facility/facilityInsertForm", method = RequestMethod.GET)
	public String facility(HttpSession session) {
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		logger.debug("FacilityController facilityInsert memberNo = {}", memberLogin.getMemberNo());
		logger.debug("FacilityController facilityInsert memberNo = {}", memberLogin.getMemberLevel());
		if(!memberLogin.getMemberLevel().equals("business")) {
			return "redirect:/";
		}
		return "facility/facilityInsertForm";
	}
	
	// facilityInsert 요청
		/**
		@RequestMapping(value="facility/facilityInsert", method = RequestMethod.POST)
		public String facilityInsert(HttpSession session, Facility facility) {
			// 세션에서 세션 키값을 통해 회원번호 출력
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			logger.debug("FacilityController facilityInsert memberNo = {}", memberLogin.getMemberNo());
			int memberNo = memberLogin.getMemberNo();
			facility.setMemberNo(memberNo);
			logger.debug("FacilityController facilityInsert memberNo = {}", memberNo);
			// facilityService.facilityInsert 확인
			logger.debug("FacilityController facilityInsert facilityNo = {}", facility.getFacilityNo());
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
			return "redirect:/";
		}
		**/
		
		// 사업자 자신이 시설 등록요청한 글 조회
		@RequestMapping(value="facility/memberFacilityInsertStatusListForm")
		public String memberFacilityInsertStatusSelectList(Model model, HttpSession session) {
			// 세션에서 뽑아낸 회원 번호 값을 멤버로 형변환 후 데이터 타입 바꿈
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			logger.debug("FacilityController facilityInsert memberNo = {}", memberLogin.getMemberNo());
			if(!memberLogin.getMemberLevel().equals("business")) {
				return "redirect:/";
			}
			// 멤버 로그인 변수 안에서 회원 번호를 뽑아내 int 멤버 변수에 담아줌
			int memberNo = memberLogin.getMemberNo();
			// 변수 memberNo 에 값이 잘 들어가있는지 확인
			logger.debug("FacilityController memberFacilityInsertStatusSelectOne memberNo = {}", memberLogin.getMemberNo());
			// facilityService.memberFacilityInsertStatusList 호출하여 리턴 받은 값을  List<Facility>타입의 list 변수에 할당
			List<Facility> list = facilityService.memberFacilityInsertStatusList(memberNo);
			// list안의 정보 확인
			logger.debug("FacilityController memberFacilityInsertStatusSelectList list = {}", list);
			// 변수 list를 키값  List 로 모델에 셋팅해줌
			model.addAttribute("List", list);
			return "facility/memberFacilityInsertStatusListForm";
		}
		
		// 사업자 자신이 시설 등록요청한 글 수정화면페이지 요청
		@RequestMapping(value="facility/facilityInsertUpdateForm", method = RequestMethod.GET)
		public String memberFacilityInsertUpdateForm(Model model, @RequestParam(value="facilityNo", required=true) int facilityNo) {
			// 전달 받은 값 확인
			logger.debug("FacilityController memberFacilityInsertUpdateForm facilityNo = {}", facilityNo);
			// 매개변수 값을 이용해 facilityService.facilitySelectOne 호출후 리턴 받은 값을 변수에 담아줌
			Facility facility = facilityService.facilitySelectOne(facilityNo);
			// 변수에 담긴 정보 확인
			logger.debug("FacilityController memberFacilityInsertUpdateForm facility = {}", facility.getFacilityNo());
			// facility변수를 키값 facility로 세션에 셋팅
			model.addAttribute("facility", facility);
			return "facility/facilityInsertUpdateForm";
		}
		
		//  시설 정보 수정 처리요청
		@RequestMapping(value="facility/facilityInsertUpdate", method = RequestMethod.POST)
		public String facilityInsertUpdate(Facility facility) {
			logger.debug("FacilityController facilityInsertUpdate facility = {}", facility.getFacilityNo());
			facilityService.facilityInsertUpdate(facility);
			return "redirect:/facility/memberFacilityInsertStatusListForm";
		}
		
		// 관리자용 시설 등록 신청 리스트 조회
		@RequestMapping(value="facility/masterFacilityInsertStatusListForm", method = RequestMethod.GET)
		public String masterFacilityInsertStatusListForm(Model model, HttpSession session) {
			
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			return null;
		}
		
		// 시설  등록  or 이미지 등록 요청
		@RequestMapping(value="facility/facilityInsert" , method = RequestMethod.POST)
		public String facilityAndFaiclityImageInsert(FacilityAndFacilityImage facilityAndFaiclityImage, HttpSession session) {
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			logger.debug("FacilityController facilityInsert memberNo = {}", memberLogin.getMemberNo());
			int memberNo = memberLogin.getMemberNo();
			facilityAndFaiclityImage.setMemberNo(memberNo);
			
			
			if(!memberLogin.getMemberLevel().equals("business")) {
				return "redirect:/";
			}
			logger.debug("FacilityController facilityAndFaiclityImageInsert facilityNo = {}", facilityAndFaiclityImage.getFacilityNo());
			String path = session.getServletContext().getRealPath("/resources");
			logger.debug("FacilityController facilityAndFaiclityImageInsert facilityNo = {}", path);
			facilityService.facilityAndFaiclityImageInsert(facilityAndFaiclityImage, path);
			return "redirect:/facility/memberFacilityInsertStatusListForm";
		}
		
		// 구장 등록이 가능한 시설 리스트  페이지 요청
		@RequestMapping(value="facility/facilityFieldInsertListForm", method = RequestMethod.GET)
		public String facilityFieldPage(HttpSession session, Model model) {
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			if(!memberLogin.getMemberLevel().equals("business")) {
				return "redirect:/";
			}
			int memberNo = memberLogin.getMemberNo();
			logger.debug("FacilityController facilityFieldPage memberNo = {}", memberNo);
			List<Facility> list = facilityService.facilityFieldPage(memberNo);
			model.addAttribute("List", list);
			return "facility/facilityFieldInsertListForm";
		}
		
		// 구장 등록 페이지 요청
		@RequestMapping(value="facility/facilityFieldInsertForm", method = RequestMethod.GET)
		public String facilityFieldInsrtPage(HttpSession session, Model model,
				 @RequestParam(value="facilityNo", required=true) int facilityNo) {
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			if(!memberLogin.getMemberLevel().equals("business")) {
				return "redirect:/";
			}
			logger.debug("FacilityController facilityFieldInsrtPage facilityNo = {}", facilityNo);
			Facility facility = facilityService.facilityFieldInsrtPage(facilityNo);
			model.addAttribute("FacilityNo" , facility.getFacilityNo());
			return "facility/facilityFieldInsertForm";
		}
		
		// 구장 등록 처리 요청
		@RequestMapping(value="facility/fieldInsert", method = RequestMethod.POST)
		public String fieldInsert(HttpSession session, FacilityField field, RedirectAttributes redirectAttributes) {
			logger.debug("FacilityController fieldInsert FacilityNo = {}", field.getFacilityNo());
			logger.debug("FacilityController fieldInsert SportEntriesName = {}", field.getSportEntriesName());
			logger.debug("FacilityController fieldInsert getFieldName = {}", field.getFieldName());
			logger.debug("FacilityController fieldInsert FieldSize = {}", field.getFieldSize());
			logger.debug("FacilityController fieldInsert FieldPrice = {}", field.getFieldPrice());
			logger.debug("FacilityController fieldInsert FieldPeopleNumber = {}", field.getFieldPeopleNumber());
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			if(!memberLogin.getMemberLevel().equals("business")) {
				return "redirect:/";
			}
			facilityService.fieldInsert(field);
			redirectAttributes.addAttribute(field.getFacilityNo());
			return "redirect:facility/facilityFieldInsertListForm";
		}
		
		// 부대 시설 등록 페이지 요청
		@RequestMapping(value="facility/facilitySubInsertForm", method = RequestMethod.GET)
		public String facilitySubInsertPage(HttpSession session, Model model,
				@RequestParam(value="facilityNo", required=true) int facilityNo) {
			MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
			if(!memberLogin.getMemberLevel().equals("business")) {
				return "redirect:/";
			}
			logger.debug("FacilityController FacilityController facilitySubInsertPage facilityNo = {}", facilityNo);
			List<FacilityAndFacilitySub> facilityAndFacilitySub = facilityService.facilityAndFacilitySub(facilityNo);
			Facility facility = facilityService.facilitySubInsertPage(facilityNo);
			List<FacilitySub> list = facilityService.subSelect();
			logger.debug("FacilityController facilitySubInsertPage facilityAndFacilitySub = {}", facilityAndFacilitySub);
			logger.debug("FacilityController facilitySubInsertPage list = {}", list);
			model.addAttribute("facilityAndFacilitySub", facilityAndFacilitySub);
			model.addAttribute("Facility", facility);
			model.addAttribute("List", list);
			return "facility/facilitySubInsertForm";
		}
		
		// 부대시설 등록 처리 요청
		@RequestMapping(value="facility/facilitySubInsert", method = RequestMethod.GET)
		public String facilitySubInsert(HttpSession session, Model model,RedirectAttributes redirectAttributes,
				@RequestParam(value="facilitySubNo", required=true) int facilitySubNo,
				@RequestParam(value="facilityNo", required=true) int facilityNo,
				@RequestParam(value="facilitySubName", required=true) String facilitySubName){
			logger.debug("FacilityController facilitySubInsert facilitySubNo = {}", facilitySubNo);
			logger.debug("FacilityController facilitySubInsert facilityNo = {}", facilityNo);
			logger.debug("FacilityController facilitySubInsert facilitySubName = {}", facilitySubName);
			
			FacilityAndFacilitySub facilityAndFacilitySub = new FacilityAndFacilitySub();
			facilityAndFacilitySub.setSubNo(facilitySubNo);
			facilityAndFacilitySub.setFacilityNo(facilityNo);
			facilityAndFacilitySub.setSubName(facilitySubName);
			facilityService.facilitySubInsert(facilityAndFacilitySub);
			redirectAttributes.addAttribute("facilityNo", facilityNo);
					return "redirect:/facility/facilitySubInsertForm";
		}
		
	
}
