package com.lti.gladiator.finance.beans;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="TRANSACTIONS")
public class Transactions{
	
	@Id
	@Column(name="TRANSACTION_ID",nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "HB_TRA_SEQ")
    @SequenceGenerator(name="HB_TRA_SEQ", sequenceName="Transaction_Seq" ,allocationSize=1)
	private int transactionId;
	
	@Column(name="PRODUCT_PURCHASED_ID")
	private int productPurchasedId;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	@Column(name="AMOUNT")
	private int amount;

	public Transactions(int productPurchasedId, Date transactionDate, int amount) {
		super();
		this.productPurchasedId = productPurchasedId;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}

	public Transactions(int transactionId, int productPurchasedId, Date transactionDate, int amount) {
		super();
		this.transactionId = transactionId;
		this.productPurchasedId = productPurchasedId;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}

	public Transactions() {
		super();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getProductPurchasedId() {
		return productPurchasedId;
	}

	public void setProductPurchasedId(int productPurchasedId) {
		this.productPurchasedId = productPurchasedId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", productPurchasedId=" + productPurchasedId
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + "]";
	}

}