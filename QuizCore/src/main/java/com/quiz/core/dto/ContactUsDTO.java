package com.quiz.core.dto;

public class ContactUsDTO {
	
	private String name;
	private String email;
	private String phoneNo;
	private String matterToDiscuss;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMatterToDiscuss() {
		return matterToDiscuss;
	}
	public void setMatterToDiscuss(String matterToDiscuss) {
		this.matterToDiscuss = matterToDiscuss;
	}
	@Override
	public String toString() {
		return "ContactUsDTO [name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", matterToDiscuss="
				+ matterToDiscuss + "]";
	}
	
}
