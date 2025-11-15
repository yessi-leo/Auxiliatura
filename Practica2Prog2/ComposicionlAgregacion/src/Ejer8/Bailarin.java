/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

/**
 *
 * @author yessi
 */
public class Bailarin extends Persona {
    private Facultad facultad;
    private Fraternidad fraternidad; 
    public Bailarin(String nombre, int edad, String dni, Facultad facultad) {
        super(nombre, edad, dni);
        this.facultad = facultad;
    }
    public void setFraternidad(Fraternidad f) { fraternidad = f; }
    public Facultad getFacultad() { return facultad; }
    public Fraternidad getFraternidad() { return fraternidad; }
}