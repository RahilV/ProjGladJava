package com.lti.gladiator.finance.beans;

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
@Table(name="PRODUCTS_PURCHASED")
public class ProductsPurchased {
		
	@Id
	@Column(name="PRODUCT_PURCHASED_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "HB_PP_SEQ")
    @SequenceGenerator(name="HB_PP_SEQ", sequenceName="PP_Seq" ,allocationSize=1)
	private int productPurchasedId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@OneToOne()
	@JoinColumn(name="PRODUCT_ID")
	private Products productId;
	
	@Column(name="AMOUNT_BILLABLE")
	private int amountBillable;
	
	@Column(name="AMOUNT_PAYED")
	private int amountPayed;
	
	@Column(name="TRANSACTION_ID")
	private int transactionId;
	
	@Column(name="EMI_PERIOD")
	private int emiPeriod;

	public ProductsPurchased(int productPurchasedId, int userId, Products productId, int amountBillable,
			int amountPayed, int transactionId, int emiPeriod) {
		super();
		this.productPurchasedId = productPurchasedId;
		this.userId = userId;
		this.productId = productId;
		this.amountBillable = amountBillable;
		this.amountPayed = amountPayed;
		this.transactionId = transactionId;
		this.emiPeriod = emiPeriod;
	}

	public ProductsPurchased() {
		super();
	}

	public int getProductPurchasedId() {
		return productPurchasedId;
	}

	public void setProductPurchasedId(int productPurchasedId) {
		this.productPurchasedId = productPurchasedId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	public int getAmountBillable() {
		return amountBillable;
	}

	public void setAmountBillable(int amountBillable) {
		this.amountBillable = amountBillable;
	}

	public int getAmountPayed() {
		return amountPayed;
	}

	public void setAmountPayed(int amountPayed) {
		this.amountPayed = amountPayed;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getEmiPeriod() {
		return emiPeriod;
	}

	public void setEmiPeriod(int emiPeriod) {
		this.emiPeriod = emiPeriod;
	}

	@Override
	public String toString() {
		return "ProductsPurchased [productPurchasedId=" + productPurchasedId + ", userId=" + userId + ", productId="
				+ productId + ", amountBillable=" + amountBillable + ", amountPayed=" + amountPayed + ", transactionId="
				+ transactionId + ", emiPeriod=" + emiPeriod + "]";
	}


	
	
	
}
