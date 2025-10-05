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
public class Jefe extends Persona {
    private String sucursal;
    private String tipo;
    public Jefe(String sucursal, String tipo, String nombre, String apellido, String ci) {
        super(nombre, apellido, ci);
        this.sucursal = sucursal;
        this.tipo = tipo;
    }
    public void leer() {
        super.leer(); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sucursal: ");
        this.sucursal = scanner.nextLine();
        System.out.print("Tipo: ");
        this.tipo = scanner.nextLine();
    }
    public void mostrar() {
        System.out.println("\n--- Datos del Jefe ---");
        super.mostrar(); 
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Tipo: " + tipo);
    }
}
