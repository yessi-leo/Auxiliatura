/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer35;

/**
 *
 * @author yessi
 */
public class Bus extends Vehiculo {
    private int capacidad;
    private String sindicato;
    
    public Bus(String conductor, String placa, int id, int capacidad, String sindicato) {
        super(conductor, placa, id);
        this.capacidad = capacidad;
        this.sindicato = sindicato;
    }
    public int getCapacidad() {
        return capacidad;
    }
    
    public String getSindicato() {
        return sindicato;
    }
}