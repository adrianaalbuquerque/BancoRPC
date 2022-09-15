package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;

    private List<Conta> ListaDeContas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
        ListaDeContas = new ArrayList<>();
        ListaDeContas.add(new Conta("1", 100.0));
        ListaDeContas.add(new Conta("2", 156.0));
        ListaDeContas.add(new Conta("3", 950.0));

    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public Conta ContaNova(String numeroDaConta, double saldoDaConta) throws RemoteException {
        Conta continha = new Conta(numeroDaConta, saldoDaConta);
        ListaDeContas.add(continha);
        return continha;
    }

    @Override
    public Conta PesquisaDaConta(String numeroDaConta) throws RemoteException {
        return this.ListaDeContas.stream().filter(conta -> conta.getNumero().equals(numeroDaConta)).findAny().orElse(null);
    }

    @Override
    public void RemocaoDaConta(String numeroDaConta) throws RemoteException {
        Conta contita = this.PesquisaDaConta(numeroDaConta);
        this.ListaDeContas.remove(contita);

        //this.ListaDeContas.removeIf(contita -> contita.getNumero().equals(numeroDaConta));
    }

}
