package com.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Bill;

public interface Billrepository extends JpaRepository<Bill, Long> {
	Bill findByGuestId(Long id);
}
