package com.dio.santander.bankline.api.services;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDTO novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();
        Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.Receita
                ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);
    }
}
