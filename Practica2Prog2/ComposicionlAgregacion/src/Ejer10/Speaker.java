/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer10;

/**
 *
 * @author yessi
 */
public class Speaker extends Persona {
    private String especialidad;
    public Speaker(String nombre, String apellido, int edad, int ci, String especialidad) {
        super(nombre, apellido, edad, ci);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() { 
        return especialidad; 
    }
}