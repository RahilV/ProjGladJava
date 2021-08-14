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
	private Products product;
	
	@Column(name="EMI_DURATION")
	private String emiDuration;
	
	@Column(name="AMOUNT_BILLABLE")
	private int amountBillable;
	
	@Column(name="AMOUNT_PAYED")
	private int amountPayed;
	
	@Column(name="TRANSACTION_ID")
	private int transactionId;

	public ProductsPurchased(int productPurchasedId, int userId, Products product, String emiDuration, int amountBillable,
			int amountPayed, int transactionId) {
		super();
		this.productPurchasedId = productPurchasedId;
		this.userId = userId;
		this.product = product;
		this.emiDuration = emiDuration;
		this.amountBillable = amountBillable;
		this.amountPayed = amountPayed;
		this.transactionId = transactionId;
		
		
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

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public String getEmiDuration() {
		return emiDuration;
	}

	public void setEmiDuration(String emiDuration) {
		this.emiDuration = emiDuration;
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

	@Override
	public String toString() {
		return "ProductsPurchased [productPurchasedId=" + productPurchasedId + ", userId=" + userId + ", product="
				+ product + ", emiDuration=" + emiDuration + ", amountBillable=" + amountBillable + ", amountPayed="
				+ amountPayed + ", transactionId=" + transactionId + "]";
	}
	
}