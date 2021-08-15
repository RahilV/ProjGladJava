package com.lti.gladiator.finance.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.gladiator.finance.beans.Products;
import com.lti.gladiator.finance.beans.ProductsPurchased;
import com.lti.gladiator.finance.services.ProductsPurchasedServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class ProductsPurchasedController {
	
	@Autowired
	private ProductsPurchasedServiceImpl productsPurchasedService;
	
	@Autowired
	private ProductsController prdController;
	
	
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
	
	@PostMapping(path = "/buyproduct")
	public String buyProduct(@RequestBody ProductsPurchased pp) {
		productsPurchasedService.buyProduct(pp);
		return "Product Purchased Successfully";

	}
	    
}

