package com.redventures.ramengo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TBL_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
