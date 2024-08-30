package com.savancys.model;

import java.util.Date;

public class JobApplicantDTO {
	private long id;
	private String name;
	private String phoneNumber;
	private Date createDate;
	private String jobPostName;
	public JobApplicantDTO() {
		super();
	}
	public JobApplicantDTO(long id, String name, String phoneNumber, Date createDate, String jobPostName) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.jobPostName = jobPostName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getJobPostName() {
		return jobPostName;
	}
	public void setJobPostName(String jobPostName) {
		this.jobPostName = jobPostName;
	}
}
	
