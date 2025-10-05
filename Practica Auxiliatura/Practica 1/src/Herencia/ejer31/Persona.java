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
public class Persona {
    protected String nombre;
    protected String apellido;
    protected String ci;

    public Persona(String nombre, String apellido, String ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
    }
    public void leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        this.apellido = scanner.nextLine();
        System.out.print("Ingrese ci: ");
        this.ci = scanner.nextLine();
    }
    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Ci: " + ci);
    }
}
