/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer27;

/**
 *
 * @author yessi
 */
public class Parada {
    private String[] admins;
    private String[][] autos;
    private String nombreP;
    private int nroAdmins;
    private int nroAutos;
    public Parada() {
        this.admins = new String[10];
        this.autos = new String[10][2]; 
        this.nombreP = "Parada Desconocida";
        this.nroAdmins = 0;
        this.nroAutos = 0;
    }
    public Parada(String nombre) {
        this.admins = new String[10];
        this.autos = new String[10][2]; 
        this.nombreP = nombre;
        this.nroAdmins = 0;
        this.nroAutos = 0;
    }
    public void mostrar() {
        System.out.println("---- INFORMACION DE LA PARADA ----");
        System.out.println("Nombre: " + nombreP);
        System.out.println("\n--- Administradores (" + nroAdmins + ") ---");
        if (nroAdmins == 0) {
            System.out.println("No hay administradores registrados");
        } else {
            for (int i = 0; i < nroAdmins; i++) {
                System.out.println((i + 1) + ". " + admins[i]);
            }
        }
        System.out.println("\n--- Autos Registrados (" + nroAutos + ") ---");
        if (nroAutos == 0) {
            System.out.println("No hay autos registrados");
        } else {
            for (int i = 0; i < nroAutos; i++) {
                System.out.println((i + 1) + ". Modelo: " + autos[i][0] +  ", Conductor: " + autos[i][1]);
            }
        }
        System.out.println("--------------------------");
    }
    public void adicionar(String admin) {
        if (nroAdmins < 10) {
            admins[nroAdmins] = admin;
            nroAdmins++;
            System.out.println("Administrador '" + admin + "' agregado");
        } else {
            System.out.println("No se pueden agregar mas administradores (limite: 10)");
        }
    }
    public void adicionar(String modelo, String conductor, String placa) {
        if (nroAutos < 10) {
            autos[nroAutos][0] = modelo;    
            autos[nroAutos][1] = conductor + " (" + placa + ")"; 
            nroAutos++;
            System.out.println("Auto '" + modelo + "' agregado");
        } else {
            System.out.println("No se pueden agregar mas autos (limite: 10)");
        }
    }
    public int getNroAdmins() {
        return nroAdmins;
    }
    
    public int getNroAutos() {
        return nroAutos;
    }
    
    public String getNombreP() {
        return nombreP;
    }
}