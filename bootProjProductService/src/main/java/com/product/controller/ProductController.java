package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.serviceImpl.ProductServiceImpl;



@RestController()
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productImpl;
	
	
	@PostMapping("/saveproduct")
	public ResponseEntity<String> createProduct(@RequestBody Product product)
	{
		
		String msg = productImpl.createProduct(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(msg);
		
		
	}
	
	
	@GetMapping("/allproduct")
	public ResponseEntity<Iterable<Product>> getAllProduct()
	{
		
		Iterable<Product> allproduct = productImpl.getAllProduct();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(allproduct);
		
		
		
	}
	
	
	@PutMapping("/updateproduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		
		String result = productImpl.updateProduct(product);
		
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@DeleteMapping("/deleteById/{pid}")
	public ResponseEntity<String> deleteProductById(@PathVariable String pid)
	{
		
		
		String result = productImpl.deleteProductById(pid);
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		
	}
	
	
	
	

}
