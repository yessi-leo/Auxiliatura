/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer11;

/**
 *
 * @author yessi
 */
public class Main11 {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Cafe Latte", 15.50);
        Pedido pedido1 = new Pedido(101, "Registrado");
        
        producto1.mostrar();
        pedido1.mostrar();
        
        producto1.setPrecio(16.00);
        pedido1.setEstado("Preparando");
        
        producto1.mostrar();
        pedido1.mostrar();
    }
}
