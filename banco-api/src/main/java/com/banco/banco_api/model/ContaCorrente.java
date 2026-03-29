package com.banco.banco_api.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CORRENTE")

public class ContaCorrente extends Conta{
    private double taxaManutencao = 20.0;

    public ContaCorrente(){}

    public ContaCorrente(String titular){
        super(titular);
    }
    public double calcularTributo(){
        return getSaldo() * 0.02;
    }
    public void aplicarTaxaManutencao(){
        if(getSaldo() >= taxaManutencao){
            setSaldo(getSaldo() - taxaManutencao);
        }
    }
    @Override
    public String getTipo(){
        return "CORRENTE";}
}
