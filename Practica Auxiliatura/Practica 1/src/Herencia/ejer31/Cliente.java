/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer31;

import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class Cliente extends Persona {
    private String nroCompra;
    private String idCliente;
    public Cliente(String nroCompra, String idCliente, String nombre, String apellido, String ci) {
        super(nombre, apellido, ci);
        this.nroCompra = nroCompra;
        this.idCliente = idCliente;
    }
    public void leer() {
        super.leer(); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Numero de compra: ");
        this.nroCompra = scanner.nextLine();
        System.out.print("ID del cliente: ");
        this.idCliente = scanner.nextLine();
    }
    public void mostrar() {
        System.out.println("\n--- Datos del Cliente ---");
        super.mostrar(); 
        System.out.println("Numero de compra: " + nroCompra);
        System.out.println("ID Cliente: " + idCliente);
    }   
}
