package com.lti.gladiator.finance.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Hibernate: alter table CONSUMER add constraint FKrpvgkp70epoy11fsgtmt3uvqj foreign key (USER_ID) references USERS
//Hibernate: alter table CONSUMER add constraint FKfd2cylg2sq6nm4vqfqvkcgppk foreign key (CARD_NO) references EMI_CARD

@Entity
@Table(name="CONSUMER")
public class Consumer implements Serializable{
	
	@Id
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Users.class)
	@JoinColumn(name="USER_ID")
	private Users user;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="LNAME")
	private String lName;
	
	@Column(name="PHONENO")
	private long phoneNo;
	
	@Column(name="ADDRESS")
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=EmiCard.class)
	@JoinColumn(name="CARD_NO")
	private EmiCard card;
	
	@Column(name="SAVING_ACCOUNT_NO")
	private long savingAccNo;
	
	@Column(name="IFSC_CODE")
	private String ifscCode;
	
	@Column(name="IS_VALIDATED")
	private char isValidated;
	
	@Column(name="BALANCE")
	private int balance;

	public Consumer() {
		super();
	}

	public Consumer(Users user, String fName, String lName, long phoneNo, String address, EmiCard card,
			long savingAccNo, String ifscCode, char isValidated, int balance) {
		super();
		this.user = user;
		this.fName = fName;
		this.lName = lName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.card = card;
		this.savingAccNo = savingAccNo;
		this.ifscCode = ifscCode;
		this.isValidated = isValidated;
		this.balance = balance;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EmiCard getCard() {
		return card;
	}

	public void setCard(EmiCard cardNo) {
		this.card = cardNo;
	}

	public long getSavingAccNo() {
		return savingAccNo;
	}

	public void setSavingAccNo(long savingAccNo) {
		this.savingAccNo = savingAccNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public char getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(char isValidated) {
		this.isValidated = isValidated;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Consumer [user=" + user + ", fName=" + fName + ", lName=" + lName + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", cardNo=" + card + ", savingAccNo=" + savingAccNo + ", ifscCode="
				+ ifscCode + ", isValidated=" + isValidated + ", balance=" + balance + "]";
	}
	
}
