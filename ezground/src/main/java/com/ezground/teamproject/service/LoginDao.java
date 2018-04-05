package com.ezground.teamproject.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.dto.SportEntries;
import com.ezground.teamproject.member.dto.MemberLogin;


@Repository
public class LoginDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);
	
	private final String mapperRoot = "com.ezground.teamproject.service.LoginMapper.";
	
	public MemberLogin loginSelectOne(MemberLogin memberLogin) {	
		
		logger.debug("loginSelectOne() memberId = {}", memberLogin.getMemberId());	
		logger.debug("loginSelectOne() memberPw = {}", memberLogin.getMemberPw());
		logger.debug("loginSelectOne() memberLevel = {}", memberLogin.getMemberLevel());
		
		return sqlSessionTemplate.selectOne(mapperRoot+"loginSelectOne", memberLogin);
	}
	
	public List<SportEntries> sportEntriesNameSelectList() {
		
		return sqlSessionTemplate.selectList(mapperRoot+"sportEntriesNameSelectList");
	}
	
	public MemberLogin loginCheck(MemberLogin memberLogin) {
		logger.debug("loginCheck() memberLogin = {}", memberLogin);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"loginCheck", memberLogin);
	}
		

}