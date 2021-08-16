package com.lti.gladiator.finance.dao;

import java.util.List;
import com.lti.gladiator.finance.beans.ProductsPurchased;
import com.lti.gladiator.finance.beans.Transactions;

public interface ProductsPurchasedDao {
	
	public int saveProductsPurchased(ProductsPurchased pp);

	public List<ProductsPurchased> getProductsPurchased();

	public List<ProductsPurchased> getUserProductsPurchased(int userId);

	public ProductsPurchased getPrdById(int productsPurchasedId);
	
	public ProductsPurchased buyProduct(ProductsPurchased pp);
	
	public int getInstallmentsLeft(int productsPurchasedId);
	
	public int payInstallment(Transactions transaction);
}