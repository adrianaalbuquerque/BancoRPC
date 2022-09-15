package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Quantidade de Contas: " + banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da conta:");
                    String numeroDaconta = entrada.next();

                    System.out.println("Digite o saldo da conta:");
                    double saldo = entrada.nextDouble();
                    
                    System.out.println(banco.ContaNova(numeroDaconta, saldo));
                    System.out.println("Conta criada com sucesso!");
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta:");
                    String numeroDaconta = entrada.next();
                    
                    System.out.println(banco.PesquisaDaConta(numeroDaconta));
                    break;
                }
                
                case 5: {
                    System.out.println("Digite o número da conta: ");
                    String numeroDaconta = entrada.next();

                    banco.RemocaoDaConta(numeroDaconta);
                    System.out.println("Conta excluída com sucesso!");
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?! Quem saberá?) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("Adriana Albuquerque de Moura");
        System.out.println("2 - Quantidade de Contas");
        System.out.println("3 - Criar uma Conta");
        System.out.println("4 - Pesquisar Conta");
        System.out.println("5 - Remover Conta");
        System.out.println("9 - Sair");
        System.out.println("Adriana Albuquerque de Moura :D");
    }

}
