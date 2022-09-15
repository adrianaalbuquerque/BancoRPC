package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    Conta ContaNova(String numeroDaConta, double saldoDaConta) throws RemoteException;
    Conta PesquisaDaConta(String numeroDaConta) throws RemoteException;
    void RemocaoDaConta(String numeroDaConta) throws RemoteException;

}
