package com.redventures.ramengo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TBL_BROTH")
public class BrothEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
