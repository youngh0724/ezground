package com.ezground.teamproject.facilitydto;

import java.sql.Timestamp;

public class FacilityImage {
	
	private int imageNo;
	private int facilityNo;
	private String imagePath;
	private String originalName;
	private String image_random_name;
	private Timestamp imageDate;
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
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getImage_random_name() {
		return image_random_name;
	}
	public void setImage_random_name(String image_random_name) {
		this.image_random_name = image_random_name;
	}
	public Timestamp getImageDate() {
		return imageDate;
	}
	public void setImageDate(Timestamp imageDate) {
		this.imageDate = imageDate;
	}
	
	
}
