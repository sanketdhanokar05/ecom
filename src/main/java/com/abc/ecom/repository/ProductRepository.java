package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ecom.entity.Product;

//@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {	
	
	
	
}