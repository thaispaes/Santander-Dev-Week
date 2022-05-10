package com.dio.santander.bankline.api.controllers;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.services.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){

        return repository.findAll(); //Tras os correntistas do banco
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDTO correntista){
        service.save(correntista);
    }
}
