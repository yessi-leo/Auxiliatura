/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer2;

/**
 *
 * @author yessi
 */
public class Main2 {
    public static void main(String[] args) {
        Bus miBus = new Bus(50);
        
        miBus.subirPasajeros(30);
        miBus.cobrarPasaje();
        miBus.mostrarAsientosDisponibles();
        
        miBus.subirPasajeros(25);
        miBus.cobrarPasaje();
        miBus.mostrarAsientosDisponibles();
    }
}
