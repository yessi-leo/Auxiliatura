/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer7;

/**
 *
 * @author yessi
 */
public class Main7 {
    public static void main(String[] args) {
        Mascota m1 = new Mascota("Firulais", "Perro", 50);
        Mascota m2 = new Mascota("Michi", "Gato", 30);
        
        m1.mostrarEnergia();
        m2.mostrarEnergia();
        
        m1.alimentar();
        m2.alimentar();
        
        m1.jugar();
        m2.jugar();
        
        m1.alimentar();
        m2.jugar();
        
        m1.mostrarEnergia();
        m2.mostrarEnergia();
    }
}
