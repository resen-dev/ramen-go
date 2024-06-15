package com.redventures.ramengo.repository;

import com.redventures.ramengo.entity.ProteinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProteinsRepository extends JpaRepository<ProteinEntity, Long> {
}
