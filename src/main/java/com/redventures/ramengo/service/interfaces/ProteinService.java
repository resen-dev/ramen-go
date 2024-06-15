package com.redventures.ramengo.service.interfaces;

import com.redventures.ramengo.dto.ProteinDto;
import com.redventures.ramengo.entity.ProteinEntity;

import java.util.List;

public interface ProteinService {
    List<ProteinEntity> getAllProteins();

    List<ProteinDto> getAllProteinsDto();

    ProteinEntity getProteinById(Long idProtein);
}
