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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH }) // to
																												// prevent
																												// to
																												// delete
																												// the
																												// user
																												// when
																												// deleting
																												// one
																												// course
	@JoinColumn(name = "userid") // "userid" is the name of field in table that is connected to user table
	private User user; // this fiels will be user to connect to courseList fiekd in user class

	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id") //"course_id" is the name of column in "review" table that is containing id of course
	private List<Review> reviews;
	
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,
												CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="student_course",
						joinColumns=@JoinColumn(name="course_id"),
						inverseJoinColumns=@JoinColumn(name="student_id")) 
	//"course_id" is the name of column in table that will store the id of course
	//joincolumn ,should be current class
		//inversejoincolimn should be the second class
	//"user_id" is the name of column in table that will store id of user
	private List<student> students;

	public course() {
	}

	public course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "course [id=" + id + ", title=" + title + ", user=" + user + "]";
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	//add user to the course list
	public void addStudent(student tempStudent) {
		if (students == null) {
			students=new ArrayList<student>();
		}
		
		students.add(tempStudent);
	}
	
	
	public List<student> getStudents() {
		return students;
	}

	public void setStudents(List<student> students) {
		this.students = students;
	}

	// add review for course
	public void addReview(Review review) {

		if (reviews == null) {
			reviews = new ArrayList<Review>();
		}

		reviews.add(review);
	}
}
