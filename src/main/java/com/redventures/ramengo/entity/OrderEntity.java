package com.redventures.ramengo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.Order;

@Entity
@Data
@Table(name = "TBL_ORDER")
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_protein", referencedColumnName = "id")
    private ProteinEntity protein;

    @ManyToOne
    @JoinColumn(name = "id_broth", referencedColumnName = "id")
    private BrothEntity broth;

    public OrderEntity(BrothEntity brothEntity, ProteinEntity proteinEntity){
        broth = brothEntity;
        protein = proteinEntity;
    }
}
