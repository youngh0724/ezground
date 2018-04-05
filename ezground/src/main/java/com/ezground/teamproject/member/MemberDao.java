package com.ezground.teamproject.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.member.dto.Member;
import com.ezground.teamproject.member.dto.MemberLogin;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	//매퍼 루트를 반복에서 쓰게 되므로 변경불가능한 파이널로 변수 선언하여 방복기록을 피한다.
	private final String mapperRoot = "com.ezground.teamproject.member.MemberMapper.";

	public int memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
				
		return sqlSessionTemplate.insert(mapperRoot+"memberInsert", member);
	}
	
	public int idOverlapCheck(String memberId) {
		logger.debug("String memberId() memberId = {}", memberId);		
		
		return sqlSessionTemplate.selectOne(mapperRoot+"idOverlapCheck", memberId);
	}
	
	public MemberLogin loginCheck(String memberId) {
		logger.debug("loginCheck() memberId = {}", memberId);
		
		return sqlSessionTemplate.selectOne(mapperRoot+"loginCheck", memberId);
	}
	
}
