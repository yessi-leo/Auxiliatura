/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

/**
 *
 * @author yessi
 */
public class Estudiante {
    private String ru;
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    
    public Estudiante(String ru, String nombre, String paterno, String materno, int edad) {
        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }
    public String getRu() {
        return ru;
    }
    
    public void setRu(String ru) {
        this.ru = ru;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPaterno() {
        return paterno;
    }
    
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    
    public String getMaterno() {
        return materno;
    }
    
    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "RU: " + ru + ", Nombre: " + nombre + " " + paterno + " " + materno +", Edad: " + edad;
    }
}