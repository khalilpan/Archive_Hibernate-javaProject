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
import javax.persistence.Table;

@Entity // creating an entity
@Table(name = "student") // mapping this class(Entity) to a specific table (the table can has different
							// name)
public class student {

	@Id // it makes this field Primary key and not null
	@GeneratedValue(strategy = GenerationType.IDENTITY) // activating auto increament for this field
	@Column(name = "id") // mapping this field to a specific column in table
	private int id;

	@Column(name = "firstname") // mapping this field to a specific column in table
	private String firstName;

	@Column(name = "lastname") // mapping this field to a specific column in table
	private String lastName;

	@Column(name = "email") // mapping this field to a specific column in table
	private String email;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, 
													CascadeType.MERGE, 
													CascadeType.PERSIST,
													CascadeType.REFRESH })
	@JoinTable(name = "student_course", 
					joinColumns = @JoinColumn(name = "student_id"), 
					inverseJoinColumns = @JoinColumn(name = "course_id"))
	//"course_id" is the name of column in table that will store the id of course 
	// joincolumn ,should be current class
	// inversejoincolimn should be the second class
	//"user_id" is the name of column in table that will store id of user
	private List<course> courses;

	
	// Empty constructor - in all the Entities we should declare an empty
	// constructor
	public student() {

	}

	public student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//adding course for student
	public void addCourse(course tempCourse) {
		if (courses==null) {
			courses=new ArrayList<course>();
		}
		
		courses.add(tempCourse);
	}
	
	
	public List<course> getCourses() {
		return courses;
	}

	public void setCourses(List<course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
