/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer35;

/**
 *
 * @author yessi
 */
public class Moto extends Vehiculo {
    private int cilindrada;
    private boolean casco;
    
    public Moto(String conductor, String placa, int id, int cilindrada, boolean casco) {
        super(conductor, placa, id);
        this.cilindrada = cilindrada;
        this.casco = casco;
    }
    public int getCilindrada() {
        return cilindrada;
    }
    
    public boolean isCasco() {
        return casco;
    }
}