package com.banco.banco_api.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("POUPANCA")

public class ContaPoupanca extends Conta{
    private double taxaRendimento = 0.05;

    public ContaPoupanca(){}

    public ContaPoupanca(String titular){
        super(titular);
    }
    public void aplicarRendimento(){
        setSaldo(getSaldo() + getSaldo() * taxaRendimento);
    }
    @Override
    public String getTipo(){
        return "POUPANCA";
    }
}
