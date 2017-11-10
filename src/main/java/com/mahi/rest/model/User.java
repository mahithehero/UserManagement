package com.mahi.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mahendra
 * This class is a model class which maps 
 * java objects to database table entities
 */

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 4910225916550731446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "username", length = 50)
	private String userName;

	@Column(name = "useremail", length = 100)
	private String userEmail;

	@Column(name = "gender", length = 20)
	private String userGender;

	@Column(name = "country", length = 20)
	private String country;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String userName, String userEmail, String userGender, String country) {
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.country = country;
	}

	public User(String userName, String userEmail, String userGender, String country) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append(this.id).append(", userName: ").append(this.userName).append(", userEmail: ")
				.append(this.userEmail).append(", Gender: ").append(this.userGender).append(", Country: ")
				.append(this.country);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		User toCompare = (User) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
