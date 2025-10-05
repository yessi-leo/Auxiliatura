/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer7;

/**
 *
 * @author yessi
 */
public class Mascota {
    
    private String nombre;
    private String tipo;
    private int energia;
    
    public Mascota(String nombre, String tipo, int energia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.energia = energia;
    }
    
    public void alimentar() {
        energia += 20;
        if (energia > 100) {
            energia = 100;
        }
        System.out.println(nombre + " fue alimentado. Energia: " + energia);
    }
    
    public void jugar() {
        energia -= 15;
        if (energia < 0) {
            energia = 0;
        }
        System.out.println(nombre + " jugo. Energia: " + energia);
    }
    
    public void mostrarEnergia() {
        System.out.println(nombre + " tiene " + energia + " de energia");
    }
}
