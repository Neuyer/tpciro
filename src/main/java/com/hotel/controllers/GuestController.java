package com.hotel.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hotel.model.Bill;
import com.hotel.model.Guest;
import com.hotel.model.Room;
import com.hotel.repositories.Billrepository;
import com.hotel.repositories.GuestRepository;
import com.hotel.repositories.RoomRepository;

import lombok.Getter;
import lombok.Setter;


@Scope (value = "session")
@Component (value = "guestController")
@ELBeanName(value = "guestController")
@Join(path = "/guests.jsf", to = "/")
@Getter
@Setter
public class GuestController {
	
	Logger logger = Logger.getLogger(GuestController.class);
	
	private Long g ;
	private Long r ;
	private String title = "Hóspedes";
	private List<Guest> guests = new ArrayList<Guest>();
	private Guest guest = new Guest();
	private Room room = new Room();
	List<Room> rooms =  new ArrayList<Room>();

	//Injeçao de dependencia do spring
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private Billrepository billrepository;
	
	//Aloca o hospede

	public void insertGuest(Long gId,Long rId) {
		findGuestBId(gId);
		findRoomById(rId);
		try {
			List<Guest> nguests = room.getGuests();
			nguests.add(this.guest);
		} catch (Exception e) {
			logger.info("Lista de guests do quarto é nula...");
		}finally {
			
			List<Guest> nguests = new ArrayList<Guest>();
			nguests.add(this.guest);
			
			if (nguests.size() > room.getVacancy() ) {
				
				logger.info("vagas excedidas");
			}else {
//				instancia uma nova conta
				logger.info("Instanciando nova conta...");
				List<Bill> bills = new ArrayList<Bill>();
				Bill bill = new Bill();
				
//				seta as propriedades da conta
				logger.info("setando as propriedades...");
				bills.add(bill);
				bill.setDataEntrada(new Date());
				bill.setGuest(guest);
				nguests.add(this.guest);
				
//				relacionamentos
				logger.info("Setando relacionamentos...");
				guest.setBill(bills);
				guest.setRoom(room);
				room.setGuests(nguests);
				room.setOccupied(true);
				
//				salva as entidades
				logger.info("salvando as entidades...");
				guestRepository.save(guest);
				billrepository.save(bill);
				roomRepository.save(room);
			}		
		}
	}	
		
	
//	DB
	@PostConstruct
	public void findAllGuests() throws Exception{
		
		this.guests = guestRepository.findAll();
		findAllRooms();		
	}
	
	public void findAllRooms() {
		
		this.rooms = roomRepository.findAll();
	}

	public void findGuestBId(Long id) {
		
		this.guest = guestRepository.findById(id);
	}
	
	public void findRoomById(Long id) {
		
		this.room = roomRepository.findByNumber(id);
	}
	
	public void save() throws IOException {
		this.guest.setId(null);
		guestRepository.save(this.guest);
	}
	
	
	public void delete(Long gId) {
		findGuestBId(gId);
		guestRepository.delete(guest);
	}

}
