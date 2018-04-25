package com.ezground.teamproject.reservation;

import java.util.List;import java.util.Map;

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

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.facility.dto.FacilityAndFacilityField;
import com.ezground.teamproject.facility.dto.FacilityCalendar;
import com.ezground.teamproject.member.dto.MemberLogin;
import com.ezground.teamproject.reservation.dto.Reservation;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService; 	
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping(value="/facility/facilityFieldList", method = RequestMethod.GET)
	public String fieldSelectList(Model model, HttpSession session, 
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord) {	
		
		SportEntries sportEntries = (SportEntries)session.getAttribute("currentSportEntry");
		String sportEntriesName = sportEntries.getSportEntriesName();		
		
		logger.debug("fieldSelectList() currentPage = {}", currentPage);
		logger.debug("fieldSelectList() rowPerPage = {}", rowPerPage);
		logger.debug("fieldSelectList() searchWord = {}", searchWord);
		Map map = reservationService.fieldSelectListByPage(currentPage, rowPerPage, searchWord, sportEntriesName);
		
		logger.debug("fieldSeletList() map = {}", map);
		
		List<FacilityAndFacilityField> list = (List<FacilityAndFacilityField>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
	
		model.addAttribute("fieldlist", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "facility/facilityFieldList";
	}	
	
	
	@RequestMapping(value="/facility/facilityFieldDetail", method = RequestMethod.GET)
	public String fieldSelectListDetail(Model model, HttpSession session, 
										@RequestParam(value="fieldNo", required=true) int fieldNo) {
		logger.debug("fieldSelectListDetail() fieldNo = {}", fieldNo);
		FacilityAndFacilityField facilityAndFacilityField = reservationService.fieldSelectListDetail(fieldNo);		
		List<FacilityCalendar> facilityCalendar = reservationService.fieldCalendarSelect(fieldNo);
		
		
		model.addAttribute("field", facilityAndFacilityField);
		model.addAttribute("calendar", facilityCalendar);
		return "facility/facilityFieldDetail";
	}	
	
	@RequestMapping(value="/reservation/reservationInsert", method = RequestMethod.GET)
    public String reservationSelect(Model model, HttpSession session,
    								@RequestParam(value="fieldNo", required=true) int fieldNo,
    								@RequestParam(value="calendarNo", required=false) Integer calendarNo) {
		
		logger.debug("reservationSelect() 실행확인"); 
	
		
		List<Reservation> list = reservationService.reservationSelect(fieldNo, calendarNo);
		
		model.addAttribute("reserv", list);
		model.addAttribute("calendarNo", calendarNo);	
        return "reservation/reservationInsert";
    }
	
	@RequestMapping(value="reservation/reservationInsert", method=RequestMethod.POST)
	public String reservationInsert(Reservation reservation, HttpSession session, RedirectAttributes redirectAttributes) {
		logger.debug("reservationInsert() fieldName = {}", reservation.getFieldName());
		
		MemberLogin memberLogin = (MemberLogin)session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		SportEntries sportEntries = (SportEntries)session.getAttribute("currentSportEntry");
		int sportEntriesNo = sportEntries.getSportEntriesNo();
		
		reservationService.reservationInsert(reservation, memberNo, sportEntriesNo);
		redirectAttributes.addAttribute("fieldNo", reservation.getFieldNo());
		return "redirect:/facility/facilityFieldDetail";
	}
	
	@RequestMapping(value="reservation/reservationDelete", method = RequestMethod.GET)
	public String reservationDelete(HttpSession session, @RequestParam(value="reservationNo", required=true) int reservationNo) {
		logger.debug("reservationDelete() reservationNo = {}", reservationNo);
	
		reservationService.reservationDelete(reservationNo);
		
		return "redirect:/reservation/reservationList";
	}
}


