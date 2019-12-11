package com.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.hotel.model.Room;
import com.hotel.repositories.RoomRepository;

import lombok.Getter;
import lombok.Setter;

@Scope (value = "session")
@Component (value = "roomController")
@ELBeanName(value = "roomController")
@Getter
@Setter
public class RoomController {
	
	String title = "Quartos";
	Room room = new Room();
	List<Room> rooms =  new ArrayList<Room>();
	
	@Autowired
	RoomRepository roomRepository;
	
	@PostConstruct
	public void findAllRooms() {
		this.rooms = roomRepository.findAll(); 
	}
	
	public void save() {
		roomRepository.save(this.room);
	}	
	
	public void findById(Long id) {
		this.room = roomRepository.findOne(id);
	}
	
	public void Delete(Long id) {
		findById(id);
		roomRepository.delete(room);
	}
}
