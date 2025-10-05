/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer33;

/**
 *
 * @author yessi
 */
public class Animal {
    protected String nombre;
    protected int edad;
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void desplazarse() {
        System.out.println(nombre + " se esta desplazando de manera generica");
    }
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
}