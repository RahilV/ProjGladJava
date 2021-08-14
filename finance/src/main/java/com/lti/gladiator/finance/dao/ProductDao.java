package com.lti.gladiator.finance.dao;

import java.util.List;

import com.lti.gladiator.finance.beans.Products;

public interface ProductDao {
	
	public List<Products> getAllProducts();

	public Products getProductById(int productId);
	
	public String addProduct(Products product);

}