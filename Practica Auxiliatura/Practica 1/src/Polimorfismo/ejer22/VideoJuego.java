/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer22;

/**
 *
 * @author yessi
 */
public class VideoJuego {
    
    String nombre;
    String plataforma;
    int cantidadJugadores;
    
    public VideoJuego() {
        this.nombre = "Sin nombre";
        this.plataforma = "Sin plataforma";
        this.cantidadJugadores = 0;
    }
    
    public VideoJuego(String nombre, String plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.cantidadJugadores = 0;
    }
    
    public VideoJuego(String nombre, String plataforma, int cantidadJugadores) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.cantidadJugadores = cantidadJugadores;
    }
    
    public void agregarJugadores() {
        cantidadJugadores++;
        System.out.println("Se agrego 1 jugador. Total: " + cantidadJugadores);
    }
    
    public void agregarJugadores(int cantidad) {
        cantidadJugadores += cantidad;
        System.out.println("Se agregaron " + cantidad + " jugadores. Total: " + cantidadJugadores);
    }
    
    public void mostrarDatos() {
        System.out.println(nombre + " - " + plataforma + " - " + cantidadJugadores + " jugadores");
    }
}