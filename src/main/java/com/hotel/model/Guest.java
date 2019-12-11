package com.hotel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@Entity
public class Guest {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "guest")
    private List<Bill> bill;
    private String cpf;
    @ManyToOne(fetch = FetchType.EAGER) 
    private Room room;
    
}

