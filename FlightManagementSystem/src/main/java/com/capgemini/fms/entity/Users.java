package com.capgemini.fms.entity;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

/*****************************************************************************************************
 * @author        Priyavrat Sharma
 * Description    It is a User Entity class that 
 *                specifies that the class  is mapped to a database
 *                table with suitable columns.
 * Version        1.0
 * Created Date   20-September-2020
 *
 ****************************************************************************************************/
@Entity
@Table(name = "User_Table")
public class Users {
	@Id
	@Column(name = "user_Id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "userPaswword")
	private String userPassword;

	
	@Column(name = "user_Name")
	private String userName;

	
	@Column(name = "contact_No")
	private String contactNo;

	
	@Column(name = "email_Id")
	private String emailId;
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", emailId=" + emailId +  "]";
	}
	
	public Users() {
		super();	
	}

	public Users(Integer userId, String userPassword, String userName, String contactNo, String emailId)
		 {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		
		this.emailId = emailId;
		
	}
	
	
	
}
