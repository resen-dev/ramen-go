package com.redventures.ramengo.controller;

import com.redventures.ramengo.entity.BrothEntity;
import com.redventures.ramengo.service.interfaces.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/broths")
@CrossOrigin(origins = "https://tech.redventures.com.br", allowedHeaders = "x-api-key")
public class BrothController {

    @Autowired
    BrothService brothService;

    @GetMapping
    public ResponseEntity<List<BrothEntity>> getAllBroths() {
        return ResponseEntity.ok(brothService.getAllBroths());
    }
}
