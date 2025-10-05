/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2;

import java.util.Scanner;
/**
 *
 * @author yessi
 */
class Bus {
    private int capacidad;
    private int pasajeros;
    private double recaudacion;
    
    public Bus(int capacidad) {
        this.capacidad = capacidad;
        this.pasajeros = 0;
        this.recaudacion = 0;
    }
    
    public void subirPasajeros(int cantidad) {
        if (pasajeros + cantidad <= capacidad) {
            pasajeros += cantidad;
            System.out.println(cantidad + " pasajeros subieron al bus");
        } else {
            int disponibles = capacidad - pasajeros;
            System.out.println("Solo hay " + disponibles + " asientos disponibles");
        }
    }
    
    public void cobrarPasaje() {
        double total = pasajeros * 1.50;
        recaudacion += total;
        System.out.println("Se cobro Bs. " + total + " por " + pasajeros + " pasajeros");
    }
    
    public void mostrarAsientosDisponibles() {
        int disponibles = capacidad - pasajeros;
        System.out.println("Asientos disponibles: " + disponibles);
    }
}