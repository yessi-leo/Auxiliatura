/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

/**
 *
 * @author yessi
 */
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    } 
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getDni() { return dni; }
}