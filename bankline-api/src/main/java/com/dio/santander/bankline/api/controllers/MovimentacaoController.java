package com.dio.santander.bankline.api.controllers;

import com.dio.santander.bankline.api.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll(); //Tras os correntistas do banco
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoDTO movimentacao){
        service.save(movimentacao);
    }
}
