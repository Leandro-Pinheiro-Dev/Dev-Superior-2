package ApplicationAbstratos;

import java.util.ArrayList;
import java.util.List;

import EntitiesHerança.Account;
import EntitiesHerança.BusinessAccount;
import EntitiesHerança.SavingsAccount;

public class Program {

    public static void main(String[] args) {

        // CRIANDO UMA LISTA DE CONTAS DO TIPO Account
        List<Account> list = new ArrayList<>();

        // ADICIONANDO CONTAS DO TIPO SavingsAccount E BusinessAccount À LISTA
        list.add(new SavingsAccount(1002, "Alex", 500.0, 0.01));
        list.add(new BusinessAccount(1003, "Maria", 1000.0, 400.0));
        list.add(new SavingsAccount(1002, "Bob", 300.0, 0.01));
        list.add(new BusinessAccount(1003, "Anna", 500.0, 500.0));

        // CALCULANDO O SALDO TOTAL DE TODAS AS CONTAS NA LISTA
        double sum = 0.0;
        for (Account acc : list) {
            sum += acc.getBalance();
        }  // FECHAMENTO DO BLOCO DO FOR
        
        // EXIBINDO O SALDO TOTAL
        System.out.printf("Total balance: %.2f%n", sum);

        // DEPOSITANDO 10.0 EM CADA CONTA DA LISTA
        for (Account acc : list) {
            acc.deposit(10.0);
        }

        // EXIBINDO O SALDO ATUALIZADO PARA CADA CONTA
        for (Account acc : list) {
            System.out.printf("Updated balance for Account %d: %.2f%n", acc.getNumber(), acc.getBalance());
        }

        // TESTANDO A OPERAÇÃO DE SAQUE EM UMA CONTA DO TIPO Account
        Account acc1 = new Account(1001, "Alex", 1000.0); // VERIFIQUE SE Account NÃO É ABSTRATA
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance());

        // TESTANDO A OPERAÇÃO DE SAQUE EM UMA CONTA DO TIPO SavingsAccount
        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());

        // TESTANDO A OPERAÇÃO DE SAQUE EM UMA CONTA DO TIPO BusinessAccount
        Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance());
    }
}
