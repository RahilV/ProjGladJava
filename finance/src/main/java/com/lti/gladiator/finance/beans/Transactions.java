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
public class Transactions implements Serializable {
	
	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "HB_TRA_SEQ")
    @SequenceGenerator(name="HB_TRA_SEQ", sequenceName="Transaction_Seq" ,allocationSize=1)
	private int transactionId;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ProductsPurchased.class)
	@JoinColumn(name="PRODUCT_PURCHASED_ID")
	private ProductsPurchased productPurchased;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	@Column(name="AMOUNT")
	private int amount;

	public Transactions(int transactionId, ProductsPurchased productPurchased, Date transactionDate, int amount) {
		super();
		this.transactionId = transactionId;
		this.productPurchased = productPurchased;
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

	public ProductsPurchased getProductPurchasedId() {
		return productPurchased;
	}

	public void setProductPurchasedId(ProductsPurchased productPurchased) {
		this.productPurchased = productPurchased;
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
		return "Transactions [transactionId=" + transactionId + ", productPurchasedId=" + productPurchased
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + "]";
	}

}