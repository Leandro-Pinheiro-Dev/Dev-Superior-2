package ApplicationStachTrace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        // INICIA A EXECUÇÃO CHAMANDO O MÉTODO 'method1'
        method1();
        
        // EXIBE MENSAGEM FINAL APÓS A EXECUÇÃO DOS MÉTODOS
        System.out.println("End of program");
    }   
    
    // DEFINIÇÃO DO MÉTODO 'method1' QUE CHAMA 'method2'
    public static void method1() {
        System.out.println("***METHOD1 START***");
        
        // CHAMADA DO MÉTODO 'method2'
        method2();
        
        System.out.println("***METHOD1 END***");
    }   
    
    // DEFINIÇÃO DO MÉTODO 'method2' QUE CONTÉM O CÓDIGO PRINCIPAL
    public static void method2() {
        System.out.println("***METHOD2 START***");
        Scanner sc = new Scanner(System.in);

        try {
            // LÊ UMA LINHA DO CONSOLE E DIVIDE EM UM ARRAY DE STRINGS
            String[] vect = sc.nextLine().split(" ");
            
            // LÊ UM NÚMERO INTEIRO DO USUÁRIO, QUE REPRESENTA UMA POSIÇÃO NO ARRAY
            int position = sc.nextInt();
            
            // IMPRIME O ELEMENTO NA POSIÇÃO INFORMADA PELO USUÁRIO
            System.out.println(vect[position]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            // TRATA ERRO DE ACESSO A UMA POSIÇÃO INVÁLIDA DO ARRAY
            System.out.println("/Invalid position");
            
            // IMPRIME O 'STACK TRACE' PARA AJUDAR NO DEBUG
            e.printStackTrace();
            
            // LÊ A PRÓXIMA ENTRADA PARA CONTINUAR A EXECUÇÃO
            sc.next();
        } 
        catch (InputMismatchException e) {
            // TRATA ERRO DE ENTRADA DE DADOS INVÁLIDA (QUANDO O USUÁRIO NÃO INSERE UM INTEIRO)
            System.out.println("Input error");
        }

        // FECHA O SCANNER PARA LIBERAR O RECURSO
        sc.close();
        
        System.out.println("***METHOD2 END***");
    }
} 
