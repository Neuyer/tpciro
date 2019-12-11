package com.hotel.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hotel.model.Bill;
import com.hotel.model.Guest;
import com.hotel.model.Product;
import com.hotel.repositories.Billrepository;
import com.hotel.repositories.GuestRepository;
import com.hotel.repositories.ProductRepository;
import com.hotel.services.BillService;

import lombok.Getter;
import lombok.Setter;

@Scope (value = "session")
@Component (value = "billController")
@ELBeanName(value = "billController")
@Getter
@Setter
public class BillController {
	Long gid;
	Long pid;
	String title = "Contas";
	Guest guest;
	Bill bill;
	List<Bill> bills;
	List<Product> products;
	List<Guest> guests;
	
	
	@Autowired
	GuestRepository guestRepository;
	@Autowired
	Billrepository billRepository;
	@Autowired
	BillService billService;
	@Autowired
	ProductRepository productRepository;
	
	public void findGuest(Long id) {
		this.guest = guestRepository.findById(id);
		findBill(id);
	}
	
	public void findAllProducts() {
		   products = productRepository.findAll();
		}
	
	@PostConstruct
	public void findAllGuests() throws Exception{
		findAllProducts();
		this.guests = guestRepository.findAll();	
	}
	 public void addItem(Long id) {
		 Product prd = productRepository.findOne(id);
		 bill.getProducts().add(prd);
	 }
	public void findBill(Long gId) {
		Bill bill = billRepository.findByGuestId(gId);
		this.bill =bill;
	}
}
