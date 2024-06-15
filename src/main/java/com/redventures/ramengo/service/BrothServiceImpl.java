package com.redventures.ramengo.service;

import com.redventures.ramengo.config.errorhandler.exceptions.RecordNotFoundException;
import com.redventures.ramengo.entity.BrothEntity;
import com.redventures.ramengo.entity.ProteinEntity;
import com.redventures.ramengo.repository.BrothRepository;
import com.redventures.ramengo.service.interfaces.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrothServiceImpl implements BrothService {

    @Autowired
    BrothRepository brothRepository;

    @Override
    public List<BrothEntity> getAllBroths() {
        return brothRepository.findAll();
    }

    @Override
    public BrothEntity getBrothById(Long idBroth){
        return brothRepository.findById(idBroth)
                .orElseThrow(() -> new RecordNotFoundException(ProteinEntity.class.getSimpleName(), idBroth));
    }
}
