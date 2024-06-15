package com.redventures.ramengo.service;

import com.redventures.ramengo.config.errorhandler.exceptions.RecordNotFoundException;
import com.redventures.ramengo.dto.ProteinDto;
import com.redventures.ramengo.entity.ProteinEntity;
import com.redventures.ramengo.repository.ProteinsRepository;
import com.redventures.ramengo.service.interfaces.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProteinServiceImpl implements ProteinService {

    @Autowired
    ProteinsRepository proteinsRepository;

    @Override
    public List<ProteinEntity> getAllProteins() {
        return proteinsRepository.findAll();
    }

    @Override
    public List<ProteinDto> getAllProteinsDto() {
        return getAllProteins().stream().map(protein ->
                        ProteinDto.builder()
                                .id(protein.getId())
                                .imageInactive(protein.getImageInactive())
                                .imageActive(protein.getImageActive())
                                .name(protein.getName())
                                .description(protein.getDescription())
                                .price(protein.getPrice())
                                .build())
                .toList();
    }

    @Override
    public ProteinEntity getProteinById(Long idProtein){
        return proteinsRepository.findById(idProtein)
                .orElseThrow(() -> new RecordNotFoundException(ProteinEntity.class.getSimpleName(), idProtein));
    }
}
