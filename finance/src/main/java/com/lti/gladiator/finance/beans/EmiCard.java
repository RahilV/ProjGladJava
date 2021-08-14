package com.lti.gladiator.finance.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMI_CARD")
public class EmiCard {
	
	@Id
	@Column(name="CARD_NO")
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "HB_EMI_SEQ")
	@SequenceGenerator(name="HB_EMI_SEQ", sequenceName="Emi_Seq" ,allocationSize=1)
	private long cardNo;
	
	@Column(name="CARD_TYPE_NAME")	
	private String cardTypeName;

	@Column(name="CARD_LIMIT")
	private int cardLimit;

	@Column(name="VALIDITY")
	private java.sql.Date validity;

	public EmiCard() {
		super();
	}

	public EmiCard(String cardTypeName, int cardLimit, Date validity) {
		super();
		this.cardTypeName = cardTypeName;
		this.cardLimit = cardLimit;
		this.validity = validity;
	}
	public EmiCard(long cardNo, String cardTypeName, int cardLimit, Date validity) {
		super();
		this.cardNo = cardNo;
		this.cardTypeName = cardTypeName;
		this.cardLimit = cardLimit;
		this.validity = validity;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public int getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}

	public java.sql.Date getValidity() {
		return validity;
	}

	public void setValidity(java.sql.Date validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "EmiCard [cardNo=" + cardNo + ", cardTypeName=" + cardTypeName + ", cardLimit=" + cardLimit
				+ ", validity=" + validity + "]";
	}


	

}