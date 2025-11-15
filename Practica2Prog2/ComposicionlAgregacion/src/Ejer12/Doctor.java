/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer12;

/**
 *
 * @author yessi
 */
public class Doctor {
    private String nombre;
    private String especialidad;
    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }
}