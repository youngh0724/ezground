package com.ezground.teamproject.match.dto;

import java.util.Date;

public class MatchNoticeFullcalendarEvent {

	private int id;
	private String title;
	private Date start;
	private Date end;
	private String url;
	
	
	public MatchNoticeFullcalendarEvent() {
		super();
	}
	public MatchNoticeFullcalendarEvent(int id, String title, Date start, Date end, String url) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.url = url;
	}
	@Override
	public String toString() {
		return "MatchNoticeFullcalendarEvent [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end
				+ ", url=" + url + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
