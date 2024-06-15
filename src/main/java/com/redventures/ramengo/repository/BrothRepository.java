package com.redventures.ramengo.repository;

import com.redventures.ramengo.entity.BrothEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrothRepository extends JpaRepository<BrothEntity, Long> {
}
