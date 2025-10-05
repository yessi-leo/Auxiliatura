/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer33;

/**
 *
 * @author yessi
 */
public class Canguro extends Animal {
    
    public Canguro(String nombre, int edad) {
        super(nombre, edad);
    }
    
    @Override
    public void desplazarse() {
        System.out.println(nombre + " (edad: " + edad + " anios) esta saltando  con sus patas traseras");
    }
}