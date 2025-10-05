/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer5;

/**
 *
 * @author yessi
 */
public class Main5 {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "Perez", "Gomez", 25, "1234567");
        Persona persona2 = new Persona("Maria", "Perez", "Lopez", 17, "7654321");
        
        System.out.println("=== Persona 1 ===");
        persona1.mostrarDatos();
        System.out.println("Es mayor de edad: " + persona1.mayorDeEdad());
        
        System.out.println("\n=== Persona 2 ===");
        persona2.mostrarDatos();
        System.out.println("Es mayor de edad: " + persona2.mayorDeEdad());
        
        persona2.modificarEdad(20);
        System.out.println("Es mayor de edad: " + persona2.mayorDeEdad());
        
        boolean mismoPaterno = persona1.getPaterno().equals(persona2.getPaterno());
        System.out.println("\nTienen el mismo apellido paterno: " + mismoPaterno);
    }
}
