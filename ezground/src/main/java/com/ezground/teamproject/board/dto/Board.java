package com.ezground.teamproject.board.dto;

public class Board {
	
	private int boardNo;
	private int boardCategoryNo;
	private int memberNo;
	private int boardOrder;
	private int boardDepth;
	private String boardTitle;
	private String boardContent;
	private String boardRegDate;
	private int boardViewCount;
	
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardCategoryNo=" + boardCategoryNo + ", memberNo=" + memberNo
				+ ", boardOrder=" + boardOrder + ", boardDepth=" + boardDepth + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardRegDate=" + boardRegDate + ", boardViewCount="
				+ boardViewCount + "]";
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardCategoryNo() {
		return boardCategoryNo;
	}
	public void setBoardCategoryNo(int boardCategoryNo) {
		this.boardCategoryNo = boardCategoryNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getBoardOrder() {
		return boardOrder;
	}
	public void setBoardOrder(int boardOrder) {
		this.boardOrder = boardOrder;
	}
	public int getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(int boardDepth) {
		this.boardDepth = boardDepth;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public int getBoardViewCount() {
		return boardViewCount;
	}
	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
	}		
}
