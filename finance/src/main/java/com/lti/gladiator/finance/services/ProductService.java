package com.lti.gladiator.finance.services;

import java.util.List;

import com.lti.gladiator.finance.beans.Products;

public interface ProductService {
	public List<Products> getAllProducts();

	public Products getProductById(int productId);
	
	public String addProduct(Products product);

}