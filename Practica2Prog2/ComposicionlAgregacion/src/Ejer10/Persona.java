/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer10;

/**
 *
 * @author yessi
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int ci;
    public Persona(String nombre, String apellido, int edad, int ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ci = ci;
    }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public int getCi() { return ci; }
}