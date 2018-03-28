package com.ezground.teamproject.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationController {
	@Autowired
	
	// reservation_cal.jsp view 파일 요청
	@RequestMapping(value="/reservation/reservationTest", method = RequestMethod.GET)
	public String reservationTest() {
		return "reservation/reservationTest";
	}
}


