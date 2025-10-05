/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer5;

/**
 *
 * @author yessi
 */
public class Persona {
    
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    private String ci;
    
    public Persona(String nombre, String paterno, String materno, int edad, String ci) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        this.ci = ci;
    }
    
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + paterno + " " + materno);
        System.out.println("Edad: " + edad);
        System.out.println("CI: " + ci);
    }
    
    public boolean mayorDeEdad() {
        return edad >= 18;
    }
    
    public void modificarEdad(int nuevaEdad) {
        edad = nuevaEdad;
        System.out.println("Edad modificada a: " + edad);
    }
    
    public String getPaterno() {
        return paterno;
    }
}