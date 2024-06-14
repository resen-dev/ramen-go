package com.redventures.ramengo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TBL_PROTEIN")
public class ProteinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
