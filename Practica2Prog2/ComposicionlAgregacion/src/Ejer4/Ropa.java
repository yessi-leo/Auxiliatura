/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

/**
 *
 * @author yessi
 */
public class Ropa {
    
    private String tipo;
    private String material;
    
    public Ropa(String tipo, String material) {
        this.tipo = tipo;
        this.material = material;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getMaterial() {
        return material;
    }
    
    @Override
    public String toString() {
        return "Ropa{tipo='" + tipo + "', material='" + material + "'}";
    }
}