package com.hotel.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
public class Room {
    @Id @GeneratedValue
    private Long number;
    private float dailyprice;
    private int vacancy;
    private Boolean occupied = false;
    @OneToMany(mappedBy = "room")
    private List<Guest> guests;
}
