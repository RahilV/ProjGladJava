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
	
    //http://localhost:8090/api/v1/buyproduct
    @PostMapping(path="/buyproduct")
    public String buyProduct(@RequestBody ProductsPurchased pp) {
         productsPurchasedService.buyProduct(pp);
         return "***";

   }
	
	 //http://localhost:8090/api/v1/productsPurchased/100001

	    /*@GetMapping(path="/productsPurchased/{id}", produces="application/json")
	    public ProductsPurchased getPrdById(@PathVariable(value="id") int productsPurchasedId) {
	        return productsPurchasedService.getPrdById(productsPurchasedId);
	    }*/

	    
	    /*@PostMapping(path="/buyproduct",produces="application/json")
	    public String buyProduct(@RequestBody ProductsPurchased pp) {
	    	
	    	/*String prdName=pp.getProduct().getProductName();
	    	String prdDetails=pp.getProduct().getProductDetails();
	    	int prdPrice=pp.getProduct().getPrice();
	    	String prdImage=pp.getProduct().getImage();
	    	String prdECriteria=pp.getProduct().getEligibilityCriteria()
	    	
	    	Products viewProduct=prdController.getProductById(100003);
	    	System.out.println(viewProduct);
	    	//return null;
	    	
	    	ProductsPurchased pc = new ProductsPurchased(1000004,100001,viewProduct,"3 months",20000,5000,10000010);
	    	return productsPurchasedService.buyProduct(pc);	
	    }*/
	    
}

