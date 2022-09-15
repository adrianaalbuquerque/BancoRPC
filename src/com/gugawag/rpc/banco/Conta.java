package com.gugawag.rpc.banco;

import java.io.Serializable;

public class Conta implements Serializable{
    private String numero;
    private double saldo;

    public Conta(String numeroDaConta, double saldoDaConta) {
        this.numero = numeroDaConta;
        this.saldo = saldoDaConta;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        
        return "Número da Conta:   " + numero + " Saldo da Conta:   " + saldo;
    }

}

//Desenvolva a classe Conta, com número (String) e saldo (double), e uma lista de Contas (List<Conta>) no servidor. Crie o método adicionarConta,
//na interface do servidor, e implemente no servidor tal método, bem como no lado do cliente;
