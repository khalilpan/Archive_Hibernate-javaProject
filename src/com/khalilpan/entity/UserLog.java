package com.khalilpan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Override
	public String toString() {
		return "UserLog [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	
	
}
