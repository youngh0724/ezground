package com.ezground.teamproject.dto;

public class SportEntries {
	private int sportEntriesNo;
	private String sportEntriesName;
		
	public SportEntries() {
		super();
	}
	public SportEntries(int sportEntriesNo, String sportEntriesName) {
		super();
		this.sportEntriesNo = sportEntriesNo;
		this.sportEntriesName = sportEntriesName;
	}
	@Override
	public String toString() {
		return "SportEntries [sportEntriesNo=" + sportEntriesNo + ", sportEntriesName=" + sportEntriesName + "]";
	}
	public int getSportEntriesNo() {
		return sportEntriesNo;
	}
	public void setSportEntriesNo(int sportEntriesNo) {
		this.sportEntriesNo = sportEntriesNo;
	}
	public String getSportEntriesName() {
		return sportEntriesName;
	}
	public void setSportEntriesName(String sportEntriesName) {
		this.sportEntriesName = sportEntriesName;
	}	
}
