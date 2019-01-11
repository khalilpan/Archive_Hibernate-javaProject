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
@Table(name="userlog")
public class UserLog {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;

	//i am adding this field just for being able to use Bi directional connection with User class
	//(this fieldwill have setter and getter)
	//this field won't be saved in dataBase
	//this fied will be used to connect to User class
	@OneToOne(mappedBy="userLog",cascade=CascadeType.ALL) //"userLog" refers to UserLog filed inside the user class ,should be the same name
	private User user;
	
	
	
	//constructor
	public UserLog() {
		super();
	}

	public UserLog(String city, String country) {
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserLog [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	
	
}
