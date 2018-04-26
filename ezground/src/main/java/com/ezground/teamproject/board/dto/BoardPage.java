package com.ezground.teamproject.board.dto;

public class BoardPage {

	private int boardCategoryNo;
	private int currentPage;
	private int startRow;
	private int rowPerPage;
	private int lastPage;
	private int totalCount;
	private String searchWord;
		
	@Override
	public String toString() {
		return "BoardPage [boardCategoryNo=" + boardCategoryNo + ", currentPage=" + currentPage + ", startRow="
				+ startRow + ", rowPerPage=" + rowPerPage + ", lastPage=" + lastPage + ", totalCount=" + totalCount
				+ ", searchWord=" + searchWord + "]";
	}
	public int getBoardCategoryNo() {
		return boardCategoryNo;
	}
	public void setBoardCategoryNo(int boardCategoryNo) {
		this.boardCategoryNo = boardCategoryNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}
