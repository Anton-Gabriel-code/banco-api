package com.banco.banco_api.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Conta{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String titular;
    private double saldo;

    public Conta(){}
    public Conta(String titular){
        this.titular = titular;
        this.saldo = 0.0;
    }
    public void depositar (double valor){
        if(valor > 0) this.saldo += valor;
    }
    public void sacar(double valor){
        if(valor > 0 && valor <= saldo) this.saldo -= valor;
    }
    public Long getId(){
        return id;}
    public String getTitular(){
        return titular;}
    public double getSaldo(){
        return saldo;}
    public void setSaldo(double saldo){
        this.saldo = saldo;}
    public void setTitular(String titular){
        this.titular = titular;}

    public abstract String getTipo();
}