package com.lti.gladiator.finance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Products {
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTS_SEQ")
	@SequenceGenerator(name="PRODUCTS_SEQ", sequenceName="PRODUCTS_SEQ",allocationSize=1)
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_DETAILS")
	private String productDetails;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="ELIGIBILITY_CRITERIA")
	private String eligibilityCriteria;

	public Products(int productId, String productName, String productDetails, int price, String image,
			String eligibilityCriteria) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDetails = productDetails;
		this.price = price;
		this.image = image;
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public Products() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productDetails="
				+ productDetails + ", price=" + price + ", image=" + image + ", eligibilityCriteria="
				+ eligibilityCriteria + "]";
	}
	
	
	
	
}