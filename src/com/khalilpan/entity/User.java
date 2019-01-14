package com.khalilpan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@JoinColumn(name = "userLog_id")
	private UserLog userLog;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH }) // "user" refers to user field in "course" class ,the name should
														// be the same
	private List<course> coursesList;

	
	

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

	public List<course> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<course> coursesList) {
		this.coursesList = coursesList;
	}

	public void setUserLog(UserLog userLog) {
		this.userLog = userLog;
	}

	// use to add a course to list
	public void addCourse(course tempCourse) {

		if (this.coursesList == null) {
			coursesList = new ArrayList<course>();
		}

		coursesList.add(tempCourse);
		tempCourse.setUser(this);
	}



}
