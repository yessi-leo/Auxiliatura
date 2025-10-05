/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer22;

import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        VideoJuego j1 = new VideoJuego();
        VideoJuego j2 = new VideoJuego("FIFA", "PlayStation");
        VideoJuego j3 = new VideoJuego("Mario Kart", "Nintendo", 4);
        
        j1.mostrarDatos();
        j2.mostrarDatos();
        j3.mostrarDatos();
        
        j1.agregarJugadores();
        j2.agregarJugadores();
        
        System.out.print("Cuantos jugadores agregar a FIFA? ");
        int cantidad = leer.nextInt();
        j2.agregarJugadores(cantidad);
        
        System.out.print("Cuantos jugadores agregar a Mario Kart? ");
        cantidad = leer.nextInt();
        j3.agregarJugadores(cantidad);
        
        j1.mostrarDatos();
        j2.mostrarDatos();
        j3.mostrarDatos();
        
    }
}
