package ApplicationTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

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
        } 
        catch (InputMismatchException e) {
            // TRATA ERRO DE ENTRADA DE DADOS INVÁLIDA (QUANDO O USUÁRIO NÃO INSERE UM INTEIRO)
            System.out.println("Input error");
        }
        
        // MENSAGEM QUE INDICA O FIM DO PROGRAMA, INDEPENDENTEMENTE DE OCORRER UMA EXCEÇÃO OU NÃO
        System.out.println("End of program");

        // FECHA O SCANNER PARA LIBERAR O RECURSO
        sc.close();
    }
}
