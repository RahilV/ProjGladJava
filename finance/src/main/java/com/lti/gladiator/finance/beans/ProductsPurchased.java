package com.lti.gladiator.finance.beans;

import java.io.Serializable;

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

//Hibernate: alter table PRODUCTS_PURCHASED add constraint FKsd9qb1m5lai04l9ui2qtfbaiu foreign key (USER_ID) references CONSUMER

@Entity
@Table(name="PRODUCTS_PURCHASED")
public class ProductsPurchased implements Serializable{
        
    @Id
    @Column(name="PRODUCT_PURCHASED_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "HB_PP_SEQ")
    @SequenceGenerator(name="HB_PP_SEQ", sequenceName="PP_Seq" ,allocationSize=1)
	private int productPurchasedId;
	
    @Column(name="USER_ID")
	private int userId;
	
	@OneToOne(cascade=CascadeType.MERGE,targetEntity=Products.class)
	@JoinColumn(name="PRODUCT_ID")
	private Products product;
	
	@Column(name="AMOUNT_BILLABLE")
	private int amountBillable;
	
	@Column(name="AMOUNT_PAYED")
	private int amountPayed;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Transactions.class)
	@JoinColumn(name="TRANSACTION_ID")
	private Transactions transaction;
	
	@Column(name="EMI_PERIOD")
	private int emiPeriod;

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

	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public int getEmiPeriod() {
		return emiPeriod;
	}

	public void setEmiPeriod(int emiPeriod) {
		this.emiPeriod = emiPeriod;
	}

	@Override
	public String toString() {
		return "ProductsPurchased [productPurchasedId=" + productPurchasedId + ", userId=" + userId + ", product="
				+ product + ", amountBillable=" + amountBillable + ", amountPayed=" + amountPayed + ", transaction="
				+ transaction + ", emiPeriod=" + emiPeriod + "]";
	}
}
