/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer23;

/**
 *
 * @author yessi
 */
public class Main23 {
     public static void main(String[] args) {
        Matriz identidad = new Matriz();
        System.out.println("Matriz identidad:");
        identidad.mostrar();
        
        float[][] valores = new float[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                valores[i][j] = i + j;
            }
        }
        
        Matriz matriz2 = new Matriz(valores);
        System.out.println("\nMatriz personalizada:");
        matriz2.mostrar();
        
        Matriz suma = identidad.sumar(matriz2);
        System.out.println("\nSuma:");
        suma.mostrar();
        
        Matriz resta = matriz2.restar(identidad);
        System.out.println("\nResta:");
        resta.mostrar();
        
        System.out.println("\nSon iguales? " + identidad.igual(matriz2));
    }
}
