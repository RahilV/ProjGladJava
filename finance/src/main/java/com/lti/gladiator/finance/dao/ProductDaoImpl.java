package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.Products;

@Repository("products")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Products> getAllProducts() {
        System.out.println("\nGet All Products : Dao layer");
		TypedQuery<Products> qry=em.createQuery("SELECT e FROM Products e",Products.class);		
		List<Products> productList= qry.getResultList();		
		return productList;
	}

	@Override
	public Products getProductById(int productId) {
		Products product=em.find(Products.class, productId);
		return product;
	}

	@Override
	@Transactional
	public String addProduct(Products product) {
		em.persist(product);
		return "Product Added successfully" ;
	}

}