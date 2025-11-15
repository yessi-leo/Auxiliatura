/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;
/**
 *
 * @author yessi
 */
public class Empleado {
    private String nombre;
    private double salario;
    private Departamento departamento;
    
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = null;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        return "Empleado{nombre='" + nombre + "', salario=" + salario + "}";
    }
}