package com.lti.gladiator.finance.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "HB_USER_SEQ")
    @SequenceGenerator(name="HB_USER_SEQ", sequenceName="users_seq" ,allocationSize=1)
	private int userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_TYPE_ID")
	private UserTypes userType;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;

	public Users() {
		super();
	}
	
	public Users(UserTypes userType, String userName, String email, String password) {
		super();
		this.userType = userType;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public Users(int userId, UserTypes userType, String userName, String email, String password) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserTypes getUserType() {
		return userType;
	}

	public void setUserType(UserTypes userType) {
		this.userType = userType;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
