package com.ezground.teamproject.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezground.teamproject.service.LoginDao;

@Service
@Transactional
public class MatchService {
	
	@Autowired
	private MatchDao matchDao;

}
