package com.redventures.ramengo.controller;

import com.redventures.ramengo.dto.ProteinDto;
import com.redventures.ramengo.service.interfaces.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/proteins")
@CrossOrigin(origins = "https://tech.redventures.com.br", allowedHeaders = "x-api-key")
public class ProteinController {

    @Autowired
    ProteinService proteinService;

    @GetMapping
    public ResponseEntity<List<ProteinDto>> getAllBroths() {
        return ResponseEntity.ok(proteinService.getAllProteinsDto());
    }
}
