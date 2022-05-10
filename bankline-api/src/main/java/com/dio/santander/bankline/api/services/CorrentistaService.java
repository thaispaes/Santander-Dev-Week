package com.dio.santander.bankline.api.services;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;
    public void save(CorrentistaDTO novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Random round = new Random();
        Conta conta = new Conta();
        conta.setSaldo(0.00);
        conta.setNumero(round.nextLong(100));
        correntista.setConta(conta);
        repository.save(correntista);

    }
}
