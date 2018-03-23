package com.ezground.teamproject.match;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

}
