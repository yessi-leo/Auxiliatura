/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer35;

/**
 *
 * @author yessi
 */
public class Auto extends Vehiculo {
    private int caballosFuerza;
    private boolean descapotable;
    
    public Auto(String conductor, String placa, int id, int caballosFuerza, boolean descapotable) {
        super(conductor, placa, id);
        this.caballosFuerza = caballosFuerza;
        this.descapotable = descapotable;
    }
    
    public int getCaballosFuerza() {
        return caballosFuerza;
    }
    
    public boolean isDescapotable() {
        return descapotable;
    }
}