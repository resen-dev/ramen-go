package com.redventures.ramengo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "TBL_PROTEIN")
@EqualsAndHashCode(callSuper = true)
public class ProteinEntity extends ProductEntity {

    @Column(name = "image_ramen")
    private String imageRamen;
}
