/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

/**
 *
 * @author yessi
 */
public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Vendidos: " + cantidad + " " + nombre);
        } else {
            System.out.println("Stock insuficiente. Solo hay: " + stock);
        }
    }
    
    public void reabastecer(int cantidad) {
        stock += cantidad;
        System.out.println("Reabastecidos: " + cantidad + " " + nombre);
    }
    
    public void mostrarStock() {
        System.out.println("Stock actual de " + nombre + ": " + stock);
    }
}