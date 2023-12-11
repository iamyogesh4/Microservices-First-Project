package com.product.service;

import com.product.entity.Product;

public interface IProductService {
	
	public String createProduct(Product product);
	
	public Iterable<Product> getAllProduct();
	
	public String updateProduct(Product product);
	
	public String deleteProductById(String pid);
	

}
