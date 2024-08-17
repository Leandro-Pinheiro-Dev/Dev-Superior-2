package ApplicationExceçõesII;

import java.util.Locale;
import java.util.Scanner;
import EntitiesII.Account;
import ExceptionsExceções.BusinessException;

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        sc.nextLine();  // LIMPA O BUFFER DO SCANNER
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        // CRIAÇÃO DO OBJETO CONTA COM OS DADOS INFORMADOS
        Account acc = new Account(number, holder, balance, withdrawLimit);
        
        // ESPAÇO PARA MELHOR LEITURA
        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();
        
        try {
            // REALIZA O SAQUE NA CONTA E EXIBE O NOVO SALDO
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }
        catch (BusinessException e) {
            // TRATA EXCEÇÕES DO TIPO BusinessException, EXIBINDO A MENSAGEM DE ERRO
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
}
