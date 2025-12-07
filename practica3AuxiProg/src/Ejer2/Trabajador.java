/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;
import java.io.*;

/**
 *
 * @author yessi
 */
public class Trabajador implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int carnet;
    private double salario;
    
    public Trabajador(String nombre, int carnet, double salario) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.salario = salario;
    }
    public String getNombre() {
        return nombre;
    }
    
    public int getCarnet() {
        return carnet;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void aumentarSalario(double porcentaje) {
        if (porcentaje > 0) {
            this.salario += this.salario * (porcentaje / 100);
        }
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre: " + nombre + ", carnet: " + carnet + ", salario:Bs " + salario + '}';
    }
}