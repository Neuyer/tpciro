package com.hotel.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hotel.model.Product;
import com.hotel.repositories.ProductRepository;

import lombok.Getter;
import lombok.Setter;

@Scope (value = "session")
@Component (value = "productController")
@ELBeanName(value = "productController")
@Getter
@Setter
public class ProductController {
	
	String title = "Produtos";
	Product product = new Product();
	List<Product> products;
	
	@Autowired
	ProductRepository productRepository;
	
	public void save() {
		productRepository.save(this.product);
	}
	
	@PostConstruct
	public void findAllProducts() {
	   products = productRepository.findAll();
	}
	
	public void findById(Long pId) {
		this.product = productRepository.findOne(pId);
	}
	
	public void delete(Long pId) {
		findById(pId);
		productRepository.delete(product);
	}
	
}
