/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer7;

/**
 *
 * @author yessi
 */
public class Niño extends Persona {
    private int edad;
    private double peso; 
    private double talla; 
    
    public Niño() {
    }
    
    public Niño(String nombre, String apellidoPaterno, String apellidoMaterno, int ci, int edad, double peso, double talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }
    public void mostrar() {
        System.out.println("CI: " + ci + ", Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + 
                          ", Edad: " + edad + " años, Peso: " + peso + " kg, Talla: " + talla + " cm");
    }

    public boolean pesoAdecuado() {
        double pesoIdeal = 0;
        if (edad >= 1 && edad <= 5) {
            pesoIdeal = edad * 2 + 8;
        } else if (edad >= 6 && edad <= 12) {
            pesoIdeal = edad * 2.5 + 5;
        } else if (edad >= 13 && edad <= 18) {
            pesoIdeal = edad * 3 + 2;
        }
        double margen = pesoIdeal * 0.15;
        return peso >= (pesoIdeal - margen) && peso <= (pesoIdeal + margen);
    }
    
    public boolean tallaAdecuada() {
        double tallaIdeal = 0;
        if (edad >= 1 && edad <= 5) {
            tallaIdeal = edad * 6 + 77; 
        } else if (edad >= 6 && edad <= 12) {
            tallaIdeal = edad * 5 + 100;
        } else if (edad >= 13 && edad <= 18) {
            tallaIdeal = edad * 3 + 140;
        }
        double margen = tallaIdeal * 0.10;
        return talla >= (tallaIdeal - margen) && talla <= (tallaIdeal + margen);
    }
}

