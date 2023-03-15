package com.infosys.dto;

import java.util.Date;

public class UserDto {

	
private Integer userId;
	
	private String name;
	
//  consider email is user name
	private String email;
	
	private String password;
	
	private String address;
	
	private String about;
	
	private String gender;
	
	private Date createAt;
	
	private String phone;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserDto(Integer userId, String name, String email, String password, String address, String about,
			String gender, Date createAt, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.about = about;
		this.gender = gender;
		this.createAt = createAt;
		this.phone = phone;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", about=" + about + ", gender=" + gender + ", createAt=" + createAt
				+ ", phone=" + phone + "]";
	}

	
}
