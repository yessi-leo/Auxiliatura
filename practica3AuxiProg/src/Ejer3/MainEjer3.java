/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer3;

/**
 *
 * @author yessi
 */
public class MainEjer3 {
    
    public static void main(String[] args) {
        ArchivoProducto arch = new ArchivoProducto("producto.txt");
        arch.crearArchivo();
        Producto p1 = new Producto(1001, "Laptop", 2200.00f);
        Producto p2 = new Producto(1002, "Mouse", 20.00f);
        Producto p3 = new Producto(1003, "Teclado", 45.00f);
        Producto p4 = new Producto(1004, "Monitor", 300.00f);
        Producto p5 = new Producto(1005, "Tablet", 1000.00f);
        
        arch.guardaProducto(p1);
        arch.guardaProducto(p2);
        arch.guardaProducto(p3);
        arch.guardaProducto(p4);
        arch.guardaProducto(p5);
        
        System.out.println("\n------ MOSTRAR TODOS LOS PRODUCTOS ------");
        arch.mostrarTodosProductos();
        // b) 
        System.out.println("\n b) BUSCAR PRODUCTO POR CODIGO ");
        Producto encontrado = arch.buscaProducto(1003);
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
        // d) 
        System.out.println("\n d) CALCULAR PROMEDIO DE PRECIOS");
        float promedio = arch.calcularPromedioPrecios();
        System.out.println("Promedio de precios: Bs" + String.format("%.2f", promedio));
        // e) 
        System.out.println("\n e) PRODUCTO MAS CARO");
        Producto masCaro = arch.obtenerProductoMasCaro();
        if (masCaro != null) {
            System.out.println("Producto mas caro: " + masCaro);
        }
    }
}