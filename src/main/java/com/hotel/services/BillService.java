package com.hotel.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.controllers.GuestController;
import com.hotel.repositories.Billrepository;
import com.hotel.repositories.GuestRepository;
import com.hotel.repositories.RoomRepository;

@Service
public class BillService {

	Logger logger = Logger.getLogger(GuestController.class);
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private Billrepository billrepository;
	
	
}
