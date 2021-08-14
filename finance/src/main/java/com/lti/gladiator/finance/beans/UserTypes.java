package com.lti.gladiator.finance.beans;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="USER_TYPES")
public class UserTypes {
	
	@Id
	@Column(name="USER_TYPE_ID")
	private int userTypeId;
	
	@Column(name="USER_TYPE_NAME")
	private String userTypeName;

	public UserTypes(int userTypeId, String userTypeName) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
	}

	public UserTypes() {
		super();
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	@Override
	public String toString() {
		return "UserTypes [userTypeId=" + userTypeId + ", userTypeName=" + userTypeName + "]";
	}
	
	

}
