package com.ezground.teamproject.facility.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FacilityImage {
	private int imageNo;
	private int facilityNo;
	private String imagePath;
	private String imageOriginalName;
	private String imageRandomName;
	private String imageExt;
	private Date imageDate;
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public int getFacilityNo() {
		return facilityNo;
	}
	public void setFacilityNo(int facilityNo) {
		this.facilityNo = facilityNo;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageOriginalName() {
		return imageOriginalName;
	}
	public void setImageOriginalName(String imageOriginalName) {
		this.imageOriginalName = imageOriginalName;
	}
	public String getImageRandomName() {
		return imageRandomName;
	}
	public void setImageRandomName(String imageRandomName) {
		this.imageRandomName = imageRandomName;
	}
	public String getImageExt() {
		return imageExt;
	}
	public void setImageExt(String imageExt) {
		this.imageExt = imageExt;
	}
	public Date getImageDate() {
		return imageDate;
	}
	public void setImageDate(Date imageDate) {
		this.imageDate = imageDate;
	}
	
	
}
