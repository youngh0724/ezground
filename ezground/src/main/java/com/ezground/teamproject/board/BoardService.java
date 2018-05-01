package com.ezground.teamproject.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezground.teamproject.board.dto.Board;
import com.ezground.teamproject.board.dto.BoardPage;
import com.ezground.teamproject.board.dto.BoardSelectResult;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	public Map<String, Object> boardListSelectPage(BoardPage boardPage){
		logger.debug("boardListSelectPage() boardPage = {}", boardPage);
		
		int startRow = (boardPage.getCurrentPage()-1)*boardPage.getRowPerPage();
		
		boardPage.setStartRow(startRow);
				
		List<BoardSelectResult> list = boardDao.boardListSelectPage(boardPage);
		logger.debug("boardListSelectPage() list = {}", list);
		
		String boardCategoryName = boardDao.boardCategoryNameSelect(boardPage);
		logger.debug("boardListSelectPage() boardCategoryName = {}", boardCategoryName);
		
		int totalCount = boardDao.boardListSelectTotalCount(boardPage);
		logger.debug("boardListSelectPage() totalCount = {}", totalCount);
		boardPage.setTotalCount(totalCount);
		
		int lastPage = (totalCount/boardPage.getRowPerPage())+1;
		boardPage.setLastPage(lastPage);
		
		logger.debug("boardListSelectPage() totalCount = {}", totalCount);
				
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		returnMap.put("boardCategoryNo", boardPage.getBoardCategoryNo());
		returnMap.put("boardPage", boardPage);
		returnMap.put("boardCategoryName", boardCategoryName);
		
		return returnMap;
	}
	
	public int boardInsert(Board board) {
		logger.debug("boardInsert() board = {}", board);	
		
		int row = boardDao.boardInsert(board);
		
		return row;
	}
	
	
	public Map<String, Object> boardDetail(int memberNo, int boardNo) {
		logger.debug("boardDetail() memberNo = {}", memberNo);
		logger.debug("boardDetail() boardNo = {}", boardNo);
		
		Board board = boardDao.boardSelectOneBYboardNo(boardNo);
		logger.debug("boardDetail() board = {}", board);
		
		board.setBoardViewCount(board.getBoardViewCount()+1);
		
		int row = boardDao.boardAddViewCount(board);
		logger.debug("boardDetail() row = {}", row);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("board", board);
		
		if(board.getMemberNo() == memberNo) {
			returnMap.put("isWriter", board.getMemberNo());
		}	
		
		return returnMap;
	}
	
	public Map<String, Object> boardUpdate(int boardNo) {
		logger.debug("boardUpdate() boardNo = {}", boardNo);
		
		Board board = boardDao.boardSelectOneBYboardNo(boardNo);
		logger.debug("boardUpdate() board = {}", board);		
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("board", board);
		
		return returnMap;
	}
	
	public int boardUpdate(Board board) {
		logger.debug("boardUpdate() board = {}", board);
		
		int row = boardDao.boardUpdate(board);
		logger.debug("boardUpdate() row = {}", row);
		
		return row;		
	}
	
	public int boardDelete(int boardNo) {
		logger.debug("boardDelete() boardNo = {}", boardNo);
		
		int row = boardDao.boardDelete(boardNo);
		logger.debug("boardDelete() row = {}", row);
		
		return row;
	}

}
