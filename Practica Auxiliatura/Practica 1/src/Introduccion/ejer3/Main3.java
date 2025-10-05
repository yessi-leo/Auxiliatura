/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

/**
 *
 * @author yessi
 */
public class Main3 {
    public static void main(String[] args) {
        Producto p1 = new Producto("Laptop", 1500.0, 10);
        
        p1.mostrarStock();
        p1.vender(3);
        p1.mostrarStock();
        p1.reabastecer(5);
        p1.mostrarStock();
        p1.vender(15);
    }
}
