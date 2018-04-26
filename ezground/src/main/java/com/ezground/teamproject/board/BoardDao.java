package com.ezground.teamproject.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.board.dto.Board;
import com.ezground.teamproject.board.dto.BoardPage;
import com.ezground.teamproject.board.dto.BoardSelectResult;


@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	//매퍼 루트를 반복에서 쓰게 되므로 변경불가능한 파이널로 변수 선언하여 방복기록을 피한다.
	private final String mapperRoot = "com.ezground.teamproject.board.BoardMapper.";
	
	public List<BoardSelectResult> boardListSelectPage(BoardPage boardPage){
		logger.debug("boardListSelectPage() boardPage = {}", boardPage);
		
		return sqlSessionTemplate.selectList(mapperRoot+"boardListSelectPage", boardPage);
	}
	
	public int boardListSelectTotalCount(BoardPage boardPage) {
		
		return sqlSessionTemplate.selectOne(mapperRoot+"boardListSelectTotalCount", boardPage);
	}
	
	public int boardInsert(Board board) {
		logger.debug("boardInsert() board = {}", board);	
	
		return sqlSessionTemplate.insert(mapperRoot+"boardInsert", board);
	}
	
	public Board boardSelectOneBYboardNo(int boardNo) {
		logger.debug("boardSelectOneBYboardNo() boardNo = {}", boardNo);	
		
		return sqlSessionTemplate.selectOne(mapperRoot+"boardSelectOneBYboardNo", boardNo);
	}
	
	public int boardAddViewCount(Board board) {
		logger.debug("boardAddViewCount() board = {}", board);
		
		return sqlSessionTemplate.update(mapperRoot+"boardAddViewCount", board);
	}	
	
	public int boardUpdate(Board board) {
		logger.debug("boardUpdate() board = {}", board);
		
		return sqlSessionTemplate.update(mapperRoot+"boardUpdate", board);
	}
	
	public int boardDelete(int boardNo) {
		logger.debug("boardDelete() boardNo = {}", boardNo);
		
		return sqlSessionTemplate.delete(mapperRoot+"boardDelete", boardNo);
	}
}
