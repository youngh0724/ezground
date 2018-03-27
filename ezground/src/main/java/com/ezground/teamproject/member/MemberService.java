package com.ezground.teamproject.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.member.dto.Member;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public void memberInsert(Member member) {
		logger.debug("memberInsert() member = {}", member);
		
		memberDao.memberInsert(member);
	}
	
	public int idOverlapCheck(String memberId) {
		logger.debug("memberInsert() memberId = {}", memberId);
		
		return memberDao.idOverlapCheck(memberId);
		
	}

}
