package com.ezground.teamproject.mypage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.reservation.dto.Reservation;
import com.ezground.teamproject.team.TeamDao;

@Repository
public class MypageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String mapperRoot = "com.ezground.teamproject.mypage.MypageMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(MypageDao.class);
	
	public List<Reservation> mypageReservList(int memberNo) {
		logger.debug("mypageReservList() memberNo = {}", memberNo);
		return sqlSessionTemplate.selectList(mapperRoot+"mypageReservList", memberNo);
		
	}
}




