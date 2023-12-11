package com.product.serviceImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repo.IProductRepo;
import com.product.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {
 
	@Autowired
	private IProductRepo productrepo;
	
	@Override
	public String createProduct(Product product) {
		
		String productid = UUID.randomUUID().toString();
		
		product.setProductid(productid);
		
		
		
		return "Product saved with ::"+productrepo.save(product).getProductid();
	}

	@Override
	public Iterable<Product> getAllProduct() {
		
		Iterable<Product> itr = productrepo.findAll();
		
		return itr;
	}

	@Override
	public String updateProduct(Product product) {
		
		 
		 
		Optional<Product> opt = productrepo.findById(product.getProductid());
		
		if(opt.isPresent()) 
		{
			
			Product p1 = opt.get();
			
			p1.setProductexpdate(product.getProductexpdate());
			
			p1.setProductmfgdate(product.getProductmfgdate());
			
			p1.setProductname(product.getProductname());
			
			return "Product Found And Update";

		}
		
		else 
		{
		
		return "No Product Found with id"+product.getProductid() ;
		
		
		}
	}

	@Override
	public String deleteProductById(String pid) {
		
		Optional<Product> opt = productrepo.findById(pid);
		
		if(opt.isPresent()) 
		{
			
			Product p1 = opt.get();
			
			productrepo.delete(p1);
			
			return "Product Found and Deleted with Id::"+pid;
			
			
		}
		
		else 
		{
		
		return "No Product Found For Deletion::";
		
		
	}
		
	}
	
}


