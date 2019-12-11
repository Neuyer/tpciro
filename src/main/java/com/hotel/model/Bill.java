package com.hotel.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Bill {
	@Id @GeneratedValue
	private Long id;
	private Boolean paid;
	private Float billValue;
	@ManyToOne
	private Guest guest;
	@OneToMany(mappedBy = "bill")
	private List<Product> products;
	private Date dataEntrada;

}
