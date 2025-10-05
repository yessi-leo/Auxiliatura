/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer27;

/**
 *
 * @author yessi
 */
public class MainEjer27 {
    public static void main(String[] args) {
        System.out.println("---- CREANDO PARADAS ----");
        Parada parDef = new Parada(); 
        Parada parNorte = new Parada("Parada Norte"); 
        System.out.println("\n--- Estado Inicial ---");
        parDef.mostrar();
        parNorte.mostrar();
        System.out.println("\n---- AGREGANDO ADMINISTRADORES ----");
        parDef.adicionar("Juan Perez");
        parDef.adicionar("Maria Garcia");
        parNorte.adicionar("Carlos Lopez");
        parNorte.adicionar("Ana Torres");
        parNorte.adicionar("Pedro Gomez");
        System.out.println("\n---- AGREGANDO AUTOS ----");
        parDef.adicionar("Toyota Corolla", "Luis Ramirez", "ABC-123");
        parDef.adicionar("Honda Civic", "Marta Jimenez", "XYZ-789");
        parDef.adicionar("Nissan Sentra", "Roberto Diaz", "DEF-456");
        parNorte.adicionar("Ford Focus", "Sofia Castro", "GHI-159");
        parNorte.adicionar("Chevrolet Spark", "Diego Morales", "JKL-753");
        parNorte.adicionar("Mazda 3", "Laura Fernandez", "MNO-486");
        parNorte.adicionar("Hyundai Accent", "Javier Ruiz", "PQR-264");
        System.out.println("\n---- ESTADO FINAL ----");
        parDef.mostrar();
        parNorte.mostrar();
        System.out.println("\n---- RESUMEN FINAL ----");
        System.out.println("Parada '" + parDef.getNombreP() + "': " + parDef.getNroAdmins() + " admins, " +parDef.getNroAutos() + " autos");
        System.out.println("Parada '" + parNorte.getNombreP() + "': " + parNorte.getNroAdmins() + " admins, " + parNorte.getNroAutos() + " autos");
    }
}