package com.hotel.repositories;
import com.hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
	Guest findById(long Id);
	
}
