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
import com.lti.gladiator.finance.services.ProductServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class ProductsController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	//http://localhost:8090/api/v1/products
	
	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productService.getAllProducts();
	}
	
	//http://localhost:8090/api/v1/product/10001
	@GetMapping(path="/product/{id}",produces="application/json")
	public Products getProductById(@PathVariable(value="id") int productId) {
		return productService.getProductById(productId);
	
	}
	//http://localhost:8090/api/v1/addnewproduct
	@PostMapping("/addnewproduct")
	public String addProduct(@RequestBody Products product) {
	 return productService.addProduct(product);
			
	}

}