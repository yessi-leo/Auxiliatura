/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer23;

/**
 *
 * @author yessi
 */
public class Matriz {
    
    float[][] matriz;
    
    public Matriz() {
        matriz = new float[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(i == j) {
                    matriz[i][j] = 1.0f;
                } else {
                    matriz[i][j] = 0.0f;
                }
            }
        }
    }
    
    public Matriz(float[][] valores) {
        matriz = new float[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                matriz[i][j] = valores[i][j];
            }
        }
    }
    
    public Matriz sumar(Matriz otra) {
        float[][] resultado = new float[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                resultado[i][j] = this.matriz[i][j] + otra.matriz[i][j];
            }
        }
        return new Matriz(resultado);
    }
    
    public Matriz restar(Matriz otra) {
        float[][] resultado = new float[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                resultado[i][j] = this.matriz[i][j] - otra.matriz[i][j];
            }
        }
        return new Matriz(resultado);
    }
    
    public boolean igual(Matriz otra) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(this.matriz[i][j] != otra.matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void mostrar() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}