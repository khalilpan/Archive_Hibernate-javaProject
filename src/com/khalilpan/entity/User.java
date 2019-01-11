package com.khalilpan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	private UserLog userLog;

	
	
	
	public User() {
		super();
	}




	public User(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}




	public int getId() {
		return id;
	}


	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public UserLog getUserLog() {
		return userLog;
	}




	public void setUserLog_id(UserLog userLog) {
		this.userLog = userLog;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", userLog_id=" + userLog + "]";
	}
	
	
	

}
