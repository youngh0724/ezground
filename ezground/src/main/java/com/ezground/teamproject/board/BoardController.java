package com.ezground.teamproject.board;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezground.teamproject.board.dto.Board;
import com.ezground.teamproject.board.dto.BoardPage;
import com.ezground.teamproject.member.dto.MemberLogin;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardPage boardPage;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 리스트화면
	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public String boardList(Model model, HttpSession session,
			@RequestParam(value="boardCategoryNo", required=true) int boardCategoryNo,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage,
			@RequestParam(value="searchWord", required=false) String searchWord){
		logger.debug("boardList() boardCategoryNo = {}", boardCategoryNo);
		logger.debug("boardList() currentPage = {}", currentPage);
		logger.debug("boardList() rowPerPage = {}", rowPerPage);
		logger.debug("boardList() searchWord = {}", searchWord);
		
		boardPage.setBoardCategoryNo(boardCategoryNo);
		boardPage.setCurrentPage(currentPage);
		boardPage.setRowPerPage(rowPerPage);
		boardPage.setSearchWord(searchWord);
		
		Map<String, Object> map = boardService.boardListSelectPage(boardPage);
		
		model.addAttribute("boardList", map);
		return "board/boardList";
	}
	
	//게시판 게시글 작성화면
	@RequestMapping(value = "/board/boardWrite", method = RequestMethod.GET)
	public String boardWrite(Model model, HttpSession session,
			@RequestParam(value="boardCategoryNo", required=true) int boardCategoryNo) {
		logger.debug("boardWrite() boardCategoryNo = {}", boardCategoryNo);
		logger.debug("boardWrite() 게시글 작성화면이로 이동");
		
		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		
		model.addAttribute("boardCategoryNo", boardCategoryNo);		
		
		return "board/boardWrite";
	}
	
	//게시판 작성된 게시글 입력
	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.POST)
	public String boardInsert(HttpSession session, RedirectAttributes redirectAttributes, Board board) {
		logger.debug("boardInsert() board = {}", board);
		
		// 세션으로부터 자신의 맴버번호 확인
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		board.setMemberNo(memberNo);
		
		int row = boardService.boardInsert(board);
		logger.debug("boardInsert() row = {}", row);
		
		redirectAttributes.addAttribute("boardCategoryNo", board.getBoardCategoryNo());
		return "redirect:/board/boardList";
	}
	
	//게시글 상세보기 , 조회수 증가 처리
	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, HttpSession session,
			@RequestParam(value="boardNo", required=true) int boardNo) {
		logger.debug("boardDetail() boardNo = {}", boardNo);
		
		// 세션검사 로그인되어있지 않으면 홈화면으로
		if (session.getAttribute("MemberLogin") == null) {
			logger.debug("logout() 세션값 없으면 홈으로 리다이렉트 ");
			return "redirect:/";
		}
		
		
		// 세션으로부터 자신의 맴버번호 확인
		MemberLogin memberLogin = (MemberLogin) session.getAttribute("MemberLogin");
		int memberNo = memberLogin.getMemberNo();
		
		Map<String, Object> map = boardService.boardDetail(memberNo, boardNo);
		logger.debug("boardDetail() map = {}", map);
		
		model.addAttribute("boardDetail", map);
				
		return "board/boardDetail";
	}
	
	//게시글 수정화면
	@RequestMapping(value = "/board/boardUpdate", method = RequestMethod.GET)
	public String boardUpdate(Model model,
			@RequestParam(value="boardCategoryNo", required=true) int boardCategoryNo,
			@RequestParam(value="boardNo", required=true) int boardNo) {
		logger.debug("boardUpdate() boardCategoryNo = {}", boardCategoryNo);
		logger.debug("boardUpdate() boardNo = {}", boardNo);
		
		Map<String, Object> map = boardService.boardUpdate(boardNo);
		logger.debug("boardDetail() map = {}", map);
		
		model.addAttribute("boardUpdate", map);
		
		return "board/boardUpdate";
	}
	
	//게시글 수정입력 처리
	@RequestMapping(value = "/board/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(RedirectAttributes redirectAttributes, Board board) {
		logger.debug("boardUpdate() board = {}", board);
		
		int row = boardService.boardUpdate(board);
		logger.debug("boardUpdate() row = {}", row);
		
		redirectAttributes.addAttribute("boardCategoryNo", board.getBoardCategoryNo());
		return "redirect:/board/boardList";
	}
	
	//게시글 삭제하기
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
	public String boardDelete(RedirectAttributes redirectAttributes,
			@RequestParam(value="boardCategoryNo", required=true) int boardCategoryNo,
			@RequestParam(value="boardNo", required=true) int boardNo) {
		logger.debug("boardDelete() boardCategoryNo = {}", boardCategoryNo);
		logger.debug("boardDelete() boardNo = {}", boardNo);
		
		int row = boardService.boardDelete(boardNo);
		logger.debug("boardDelete() row = {}", row);
		
		redirectAttributes.addAttribute("boardCategoryNo", boardCategoryNo);
		return "redirect:/board/boardList";
	}
	
	

}
