/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer13;

/**
 *
 * @author yessi
 */
public class Fruta {

    String nombre;
    String tipo;
    int nroVitaminas;
    String[] v;
    
    public Fruta(String nombre, String tipo, String[] vitaminas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.v = vitaminas;
        this.nroVitaminas = vitaminas.length;
    }
    
    public void mostrarVitaminas() {
        System.out.print("Vitaminas de " + nombre + ": ");
        for (int i = 0; i < nroVitaminas; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}