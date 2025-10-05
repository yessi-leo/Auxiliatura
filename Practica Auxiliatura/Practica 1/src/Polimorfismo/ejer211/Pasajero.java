/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer211;

/**
 *
 * @author yessi
 */
public class Pasajero {
    private String nombre;
    private int edad;
    private String genero;
    private int nroHabitacion;
    private double costoPasaje;
    
    public Pasajero() {
        this.nombre = "";
        this.edad = 0;
        this.genero = "";
        this.nroHabitacion = 0;
        this.costoPasaje = 0.0;
    }
    
    public Pasajero(String nombre, int edad, String genero, int nroHabitacion, double costoPasaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.nroHabitacion = nroHabitacion;
        this.costoPasaje = costoPasaje;
    }
    
    public void incrementar() {
        System.out.println("Leyendo datos del pasajero: " + this.nombre);
    }
    
    public void decrementar() {
        System.out.println("Mostrando pasajero: " + this.nombre + ", Edad: " + this.edad + ", Genero: " + this.genero + ", Habitacion: " + this.nroHabitacion + ", Costo: Bs" + this.costoPasaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public double getCostoPasaje() {
        return costoPasaje;
    }

    public void setCostoPasaje(double costoPasaje) {
        this.costoPasaje = costoPasaje;
    }
    
}
