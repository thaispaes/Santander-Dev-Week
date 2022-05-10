package com.dio.santander.bankline.api.model;

import javax.persistence.*;

@Entity
@Table (name= "tab_correntista")
public class Correntista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //INserindo algumas informações com a dependencia do JPA
    private Integer id;
    @Column(length = 20)
    private String cpf;
    @Column(length = 60)
    private String nome;
    @Embedded //Tudo que tiver na classe vai se relacionar com as colunas desta classe
    private Conta conta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
