package com.example.demo.user;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User details primary class") // used in Swagger for Model documentation
public class User {


	private Integer userId;
	@ApiModelProperty(value = " length should be between 2 to 4")   // used in Swagger for Model documentation
	@Size(min = 2 , max = 4 , message =" length should be between 2 to 4")
	private String UserName;
	private LocalDate dob;
	
	
	
	public User() {
		super();
	}

	public User(Integer id,String userName, LocalDate dob) {
		super();
		userId = id;
		UserName = userName;
		this.dob = dob;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
