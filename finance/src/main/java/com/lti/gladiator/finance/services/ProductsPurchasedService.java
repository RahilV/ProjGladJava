package com.lti.gladiator.finance.services;

import java.util.List;

import com.lti.gladiator.finance.beans.ProductsPurchased;

public interface ProductsPurchasedService {

	public int saveProductsPurchased(ProductsPurchased pp);

	public List<ProductsPurchased> getProductsPurchased();

	public List<ProductsPurchased> getUserProductsPurchased(int userId);

	public ProductsPurchased buyProduct(ProductsPurchased pp);

	public ProductsPurchased getPrdById(int productsPurchasedId);

}