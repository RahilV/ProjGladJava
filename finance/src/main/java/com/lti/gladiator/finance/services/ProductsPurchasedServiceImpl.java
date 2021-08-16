package com.lti.gladiator.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.ProductsPurchased;
import com.lti.gladiator.finance.beans.Transactions;
import com.lti.gladiator.finance.dao.ProductsPurchasedDao;

@Service("ProductsPurchasedService")
public class ProductsPurchasedServiceImpl implements ProductsPurchasedService {

	@Autowired
	private ProductsPurchasedDao productsPurchasedDao;

	public ProductsPurchasedDao getProductsPurcyhasedDao() {
		return productsPurchasedDao;
	}

	public void setProductsPurcyhasedDao(ProductsPurchasedDao productsPurchasedDao) {
		this.productsPurchasedDao = productsPurchasedDao;
	}

	@Override
	public int saveProductsPurchased(ProductsPurchased pp) {
		System.out.println("\nService Layer: " + pp);
		productsPurchasedDao.saveProductsPurchased(pp);
		return 0;
	}

	@Override
	public List<ProductsPurchased> getProductsPurchased() {
		System.out.println("\nGet Products Purchased: Service Layer");
		return productsPurchasedDao.getProductsPurchased();
	}


	@Override
	public ProductsPurchased buyProduct(ProductsPurchased pp) {
		return productsPurchasedDao.buyProduct(pp);
	}

	@Override
	public ProductsPurchased getPrdById(int productsPurchasedId) {
		return productsPurchasedDao.getPrdById(productsPurchasedId);
	}

	@Override
	public List<ProductsPurchased> getUserProductsPurchased(int userId) {
		return productsPurchasedDao.getUserProductsPurchased(userId);
	}

	public int getInstallmentsLeft(int productsPurchasedId) {
		return productsPurchasedDao.getInstallmentsLeft(productsPurchasedId);
	}

	@Override
	public int payInstallment(Transactions transaction) {
		return productsPurchasedDao.payInstallment(transaction);
	}
}
