package com.redventures.ramengo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "TBL_BROTH")
@EqualsAndHashCode(callSuper = true)
public class BrothEntity extends ProductEntity {
}
