package com.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByName(String name);
}
