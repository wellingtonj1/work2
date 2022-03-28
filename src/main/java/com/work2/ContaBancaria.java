package com.work2;

public class ContaBancaria {

    private double saldo;
    private String nomeConta;

    public ContaBancaria(String nomeConta, double saldo) {
        this.nomeConta = nomeConta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
