package com.banco.banco_api.service;

import com.banco.banco_api.model.*;
import com.banco.banco_api.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ContaService {
    @Autowired
    private ContaRepository repository;


    public Conta criarConta(String titular, String tipo){
        Conta conta;

        if(tipo.equalsIgnoreCase("CORRENTE")){
            conta = new ContaCorrente(titular);
        }else{
            conta = new ContaPoupanca(titular);
        }
        return repository.save(conta);
    }

    public List<Conta> listarContas(){
        return repository.findAll();
    }
    public Conta depositar(Long id, double valor){
        Conta conta = repository.findById(id).orElseThrow();
        conta.depositar(valor);
        return repository.save(conta);
    }
    public Conta sacar(Long id, double valor){
        Conta conta = repository.findById(id).orElseThrow();
        conta.sacar(valor);
        return repository.save(conta);
    }
    public void transferir(Long origemId, Long destinoId, double valor){
        Conta origem = repository.findById(origemId).orElseThrow();
        Conta destino = repository.findById(destinoId).orElseThrow();
        origem.sacar(valor);
        destino.sacar(valor);
        repository.save(origem);
        repository.save(destino);
    }

    public double calcularTributo(Long id){
        Conta conta = repository.findById(id).orElseThrow();
        if(conta instanceof ContaCorrente cc){
            return cc.calcularTributo();
        }
        return 0.0;
    }
}


