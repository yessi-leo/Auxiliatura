/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer35;

/**
 *
 * @author yessi
 */
public class Vehiculo {
    protected String conductor;
    protected String placa;
    protected int id;
    
    public Vehiculo(String conductor, String placa, int id) {
        this.conductor = conductor;
        this.placa = placa;
        this.id = id;
    }
    public void cambiarConductor(String nuevoConductor) {
        this.conductor = nuevoConductor;
        System.out.println("Conductor cambiado a: " + nuevoConductor + " para el vehiculo " + placa);
    }
    public void mostrarPlacaConductor() {
        System.out.println("Placa: " + placa + " | Conductor: " + conductor);
    }
    
    public String getConductor() {
        return conductor;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public int getId() {
        return id;
    }
}