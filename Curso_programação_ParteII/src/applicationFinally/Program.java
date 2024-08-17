package applicationFinally;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        
        // CRIA UM OBJETO FILE REFERENCIANDO UM ARQUIVO NO CAMINHO ESPECIFICADO
        File file = new File("C:\\temp\\in.txt");
        
        // DECLARA UM OBJETO SCANNER, QUE SERÁ USADO PARA LER O ARQUIVO
        Scanner sc = null;
        
        try {
            // TENTA INICIALIZAR O SCANNER COM O ARQUIVO ESPECIFICADO
            sc = new Scanner(file);
            
            // LÊ E IMPRIME CADA LINHA DO ARQUIVO ENQUANTO HOUVER LINHAS
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        catch (IOException e) {
            // TRATA POSSÍVEIS EXCEÇÕES DE ENTRADA/SAÍDA (EX., ARQUIVO NÃO ENCONTRADO)
            System.out.println("Error opening file: " + e.getMessage());
        }
        finally {
            // O BLOCO FINALLY É EXECUTADO SEMPRE, INDEPENDENTE DE HAVER UMA EXCEÇÃO OU NÃO
            if (sc != null) {
                // SE O SCANNER FOI INICIALIZADO, ELE É FECHADO PARA LIBERAR O RECURSO
                sc.close();
            }
        }
    }
}
