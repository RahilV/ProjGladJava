package com.lti.gladiator.finance.controller;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.gladiator.finance.beans.Consumer;
import com.lti.gladiator.finance.beans.Products;
import com.lti.gladiator.finance.beans.ProductsPurchased;
import com.lti.gladiator.finance.beans.Transactions;
import com.lti.gladiator.finance.services.ProductsPurchasedServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class ProductsPurchasedController {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private ProductsPurchasedServiceImpl productsPurchasedService;
	
	@Autowired
	private ProductsController prdController;
	
	@Autowired
	private TransactionController transactioncontrol;
	
	@Autowired
	private ConsumerController consumerControl;
	
	//http://localhost:8090/api/v1/productsPurchased
	
	@GetMapping("/productsPurchased")
	public List<ProductsPurchased> getProductPurchased()
	{
		System.out.println("Inside Controller");
		
		List<ProductsPurchased> empList = productsPurchasedService.getProductsPurchased();
		return empList;
	}
	
	@GetMapping("/productsPurchased/{id}")
	public ProductsPurchased getPrdById(@PathVariable(value="id") int productsPurchasedId)
	{
		return productsPurchasedService.getPrdById(productsPurchasedId);
	}
	
	@GetMapping("/userProducts/{id}")
	public List<ProductsPurchased> getUserProductsPurchased(@PathVariable(value="id") int userId)
	{
		return productsPurchasedService.getUserProductsPurchased(userId);
	}
	

	
	 //http://localhost:8090/api/v1/buyproduct

	@PostMapping(path = "/buyproduct")
	@Transactional
	public String buyProduct(@RequestBody ProductsPurchased productsPurchased) {
		ProductsPurchased pp = productsPurchasedService.buyProduct(productsPurchased);
		Transactions t = pp.getTransaction();
		t.setProductPurchasedId(pp.getProductPurchasedId());
		transactioncontrol.setTransactions(t);
		
		System.out.println(pp.getProduct());
		Consumer c = consumerControl.getConsumerById(pp.getUserId());
		System.out.println(c);
		c.setBalance(c.getBalance()-pp.getAmountBillable()/pp.getEmiPeriod());
		
		System.out.println(c);
		return "Product Purchased Successfully";

	}
	
	@GetMapping(path="/userProducts/emi/{id}")
	public int installmentsLeft(@PathVariable(value="id") int productsPurchasedId) {
		System.out.println("\n\nHERE");
		int installmentsPayed = productsPurchasedService.getInstallmentsLeft(productsPurchasedId);
		int installmentsLeft  = em.find(ProductsPurchased.class, productsPurchasedId).getEmiPeriod() - installmentsPayed;
		return installmentsLeft;
	}
	
	@PostMapping(path = "/payInstallment")
	@Transactional
	public String payEmi(@RequestBody Transactions transaction) {
		productsPurchasedService.payInstallment(transaction);
		
		ProductsPurchased pp = em.find(ProductsPurchased.class, transaction.getProductPurchasedId());
		pp.setTransaction(transaction);
		pp.setAmountPayed(pp.getAmountPayed()+transaction.getAmount());
		Consumer c = consumerControl.getConsumerById(pp.getUserId());
		System.out.println(c);
		c.setBalance(c.getBalance()-pp.getAmountBillable()/pp.getEmiPeriod());
		
		System.out.println(c);
		return "INSTALLMENT PAYED";
	}
}

