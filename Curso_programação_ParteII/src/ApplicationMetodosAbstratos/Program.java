package ApplicationMetodosAbstratos;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import EntiitesMetodosAbstratos.Circle;
import EntiitesMetodosAbstratos.Rectangle;
import EntiitesMetodosAbstratos.Shape;
import EntiitesMetodosAbstratos.enums.Color;

public class Program {

    public static void main(String[] args) {
 
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        // CRIA UMA LISTA DE OBJETOS DO TIPO 'Shape'
        List<Shape> list = new ArrayList<>();
        
        // SOLICITA O NÚMERO DE FORMAS QUE O USUÁRIO DESEJA CRIAR
        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();
        
        // LOOP PARA CRIAR AS FORMAS BASEADO NA ENTRADA DO USUÁRIO
        for (int i = 1; i <= n; i++) { 
            System.out.println("Shape #" + i + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char ch = sc.next().charAt(0);
            
            // ESCOLHA DA COR USANDO UM ENUM
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next().toUpperCase());
            
            if (ch == 'r') {
                // CRIAÇÃO DE UM RETÂNGULO: USO DE HERANÇA E POLIMORFISMO
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                list.add(new Rectangle(color, width, height)); // UPCASTING
            } else {
                // CRIAÇÃO DE UM CÍRCULO: USO DE HERANÇA E POLIMORFISMO
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color, radius)); // UPCASTING
            }
        }
        
        System.out.println();
        System.out.println("SHAPE AREAS:");
        
        // POLIMORFISMO: CHAMADA DO MÉTODO 'area()' DE FORMA GENÉRICA
        for (Shape shape : list) {
            System.out.println(String.format("%.2f", shape.area())); // MÉTODO ABSTRATO IMPLEMENTADO NAS SUBCLASSES
        }
        
        sc.close();
    }
}
