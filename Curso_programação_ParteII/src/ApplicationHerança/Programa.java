package ApplicationHerança;

import EntitiesHerança.Account;
import EntitiesHerança.BusinessAccount;
import EntitiesHerança.SavingsAccount;

public class Programa {  

    public static void main(String[] args) {
        
        // HERANÇA: CRIAÇÃO DE UMA CONTA GENÉRICA (ACCOUNT)
        Account acc = new Account(1001, "ALEX", 0.0);
        
        // HERANÇA: CRIAÇÃO DE UMA CONTA EMPRESARIAL (BUSINESSACCOUNT) COM LIMITE DE EMPRÉSTIMO DE 500.0
        BusinessAccount bacc = new BusinessAccount(1002, "MARIA", 0.0, 500.0);
        
        // POLIMORFISMO: UPCASTING - TRANSFORMANDO OBJETOS DE SUBCLASSE EM REFERÊNCIAS DE ACCOUNT
        Account acc1 = bacc; // BACC É DO TIPO BUSINESSACCOUNT, MAS REFERENCIADO COMO ACCOUNT
        Account acc2 = new BusinessAccount(1003, "BOB", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "ANNA", 0.0, 0.01); // CONTA POUPANÇA COM TAXA DE JUROS DE 1%
        
        // POLIMORFISMO: DOWNCASTING - CONVERTENDO DE VOLTA PARA AS SUBCLASSES ESPECÍFICAS
        BusinessAccount acc4 = (BusinessAccount) acc2; // ACC2 REFERENCIADO COMO BUSINESSACCOUNT
        acc4.loan(100.0); // REALIZANDO EMPRÉSTIMO NA CONTA EMPRESARIAL
        
        // POLIMORFISMO: TENTATIVA DE DOWNCASTING DE SAVINGSACCOUNT PARA BUSINESSACCOUNT, VERIFICANDO O TIPO ANTES
        if(acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3; // ESTE BLOCO NÃO SERÁ EXECUTADO POIS ACC3 É SAVINGSACCOUNT
            acc5.loan(200.0);
            System.out.println("LOAN!");
        }

        // POLIMORFISMO: VERIFICAÇÃO CORRETA DE TIPO E USO DE DOWNCASTING PARA SAVINGSACCOUNT
        if(acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance(); // ATUALIZA O SALDO APLICANDO A TAXA DE JUROS
            System.out.println("UPDATE!");
        }

        // HERANÇA: CRIAÇÃO DE UMA CONTA POUPANÇA (SAVINGSACCOUNT) COM SALDO INICIAL DE 1000.0
        // O MÉTODO WITHDRAW(DOUBLE AMOUNT) FOI SOBRESCRITO PARA NÃO INCLUIR A TAXA DE 5.0
        Account acc6 = new SavingsAccount(1005, "LEANDRO", 1000.0, 0.01);

        // POLIMORFISMO: REALIZA UM SAQUE DE 200.0 (SEM A TAXA DE 5.0 DEVIDO À SOBRESCRITA)
        acc6.withdraw(200.0);

        // POLIMORFISMO: SUBTRAÇÃO MANUAL DE 5.0 APÓS O SAQUE
        acc6.withdraw(5.0);

        // IMPRIME O SALDO ATUAL DA CONTA (ESPERADO: 795.0)
        System.out.println(acc6.getBalance());

        // HERANÇA: OUTRA OPERAÇÃO DE SAQUE EM UMA CONTA POUPANÇA, SEM APLICAR A TAXA DE 5.0
        Account acc7 = new SavingsAccount(1010, "NEYMAR", 1000.0, 0.01);
        acc7.withdraw(200.0);

        // IMPRIME O SALDO DE ACC7 (ESPERADO: 800.0)
        System.out.println(acc7.getBalance());
        
        // HERANÇA: NOVA OPERAÇÃO: BUSINESSACCOUNT COM SAQUE DE 200.0
        Account acc8 = new BusinessAccount(1020, "Mara", 1000.0, 500.0);
        acc8.withdraw(200.0);
        
        // ESPERA-SE QUE O SALDO RESULTANTE SEJA 793.0 (SAQUE DE 200.0 + TAXA DE 5.0 + TAXA ADICIONAL DE 2.0)
        System.out.println(acc8.getBalance());
        
        // POLIMORFISMO: EXEMPLOS DE POLIMORFISMO COM AS CLASSES ACCOUNT E SAVINGSACCOUNT
        // CRIAÇÃO DE UMA CONTA GENÉRICA (ACCOUNT) COM SALDO INICIAL DE 1000.0
        Account x = new Account(1030, "Alice", 1000.0); 
        
        // CRIAÇÃO DE UMA CONTA POUPANÇA (SAVINGSACCOUNT) COM SALDO INICIAL DE 1000.0 E TAXA DE JUROS DE 0.01
        Account y = new SavingsAccount(1040, "Gislaine", 1000.0, 0.01);
        
        // POLIMORFISMO: SAQUE DE 50.0 NA CONTA GENÉRICA
        x.withdraw(50.0); // ISSO DEVE SUBTRAIR 50.0 + 5.0 DA TAXA, RESULTANDO EM 945.0
        
        // POLIMORFISMO: SAQUE DE 50.0 NA CONTA POUPANÇA
        y.withdraw(50.0); // ISSO DEVE SUBTRAIR APENAS 50.0 SEM TAXA ADICIONAL, RESULTANDO EM 950.0
        
        // IMPRIME O SALDO ATUAL DAS CONTAS
        System.out.println(x.getBalance()); // IMPRIME 945.0
        System.out.println(y.getBalance()); // IMPRIME 950.0
    }  
}
