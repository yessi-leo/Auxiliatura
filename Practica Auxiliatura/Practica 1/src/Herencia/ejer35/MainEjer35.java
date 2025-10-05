/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer35;

/**
 *
 * @author yessi
 */
public class MainEjer35 {
    public static void main(String[] args) {
        System.out.println("---- VEHICULOS ----");
        Bus bus = new Bus("Carlos", "ABC-123", 1, 50, "Sindicato Transporte");
        Auto auto = new Auto("Maria", "XYZ-789", 2, 150, true);
        Moto moto = new Moto("Juan", "DEF-456", 3, 250, true);
        System.out.println("\n---- PLACA Y CONDUCTOR DE CADA VEHICULO ----");
        bus.mostrarPlacaConductor();
        auto.mostrarPlacaConductor();
        moto.mostrarPlacaConductor();
        System.out.println("\n--- CAMBIANDO CONDUCTORES ----");
        bus.cambiarConductor("Roberto");
        auto.cambiarConductor("Ana");
        System.out.println("\n---- DESPUES DEL CAMBIO DE CONDUCTORES -----");
        bus.mostrarPlacaConductor();
        auto.mostrarPlacaConductor();
        moto.mostrarPlacaConductor();
    }
}