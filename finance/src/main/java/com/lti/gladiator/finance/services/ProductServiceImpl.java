package com.lti.gladiator.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.Products;
import com.lti.gladiator.finance.dao.ProductDao;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
    @Override
	public List<Products> getAllProducts() {
    	System.out.println("\n Get All Products: Service layer");
		return productDao.getAllProducts();
	}

    @Override
	public Products getProductById(int productId) {
    	System.out.println("\n Get Product By Id: service layer");
		return productDao.getProductById(productId);
	}

    @Override
	public String addProduct(Products product) {
		return productDao.addProduct(product);
	}

}