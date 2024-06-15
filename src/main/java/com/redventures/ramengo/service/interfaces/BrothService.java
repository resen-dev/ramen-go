package com.redventures.ramengo.service.interfaces;

import com.redventures.ramengo.entity.BrothEntity;

import java.util.List;

public interface BrothService{
    List<BrothEntity> getAllBroths();

    BrothEntity getBrothById(Long idBroth);
}
