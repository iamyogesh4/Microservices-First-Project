package com.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.product.entity.Product;

public interface IProductRepo extends JpaRepository<Product, String>{

}
