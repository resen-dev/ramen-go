package com.redventures.ramengo.controller;

import com.redventures.ramengo.dto.ProteinDto;
import com.redventures.ramengo.service.interfaces.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/proteins")
public class ProteinController {

    @Autowired
    ProteinService proteinService;

    @GetMapping
    public ResponseEntity<List<ProteinDto>> getAllBroths() {
        return ResponseEntity.ok(proteinService.getAllProteinsDto());
    }
}
