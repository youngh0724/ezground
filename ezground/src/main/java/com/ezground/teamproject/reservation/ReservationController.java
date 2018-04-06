package com.ezground.teamproject.reservation;

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

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.facility.dto.FacilityField;
import com.ezground.teamproject.team.TeamController;
import com.ezground.teamproject.team.TeamService;
import com.ezground.teamproject.team.dto.Team;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService; //
	//�ü� ��� ��ȸ������ views�� facilityList.jsp ȣ��
	
	//�Է°��� ���ϰ��� Ȯ�� �ϱ� ���� �ΰ� ��� 
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping(value="/field/fieldList", method = RequestMethod.GET)
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
		
		List<FacilityField> list = (List<FacilityField>)map.get("list");
		int totalCount = (Integer) map.get("totalCount");		
		
		int lastPage = (totalCount/rowPerPage)+1;
	
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("currentPage", currentPage);
		return "field/fieldList";
	}	
	
}


