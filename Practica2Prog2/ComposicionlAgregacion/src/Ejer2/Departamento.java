/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;

import java.util.ArrayList;
/**
 *
 * @author yessi
 */
public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    public void mostrarEmpleados() {
        System.out.println("Empleados del departamento " + nombre + ":");
        if (empleados.size() == 0) {
            System.out.println("  No hay empleados en este departamento.");
        } else {
            for (int i = 0; i < empleados.size(); i++) {
                Empleado empleado = empleados.get(i);
                System.out.println("  - " + empleado);
            }
        }
        System.out.println();
    }   
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(this);
    }   
    public void removerEmpleado(Empleado empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i) == empleado) {
                empleados.remove(i);
                break;
            }
        }
        empleado.setDepartamento(null);
    }   
    public void cambioSalario(double porcentaje) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
            empleado.setSalario(nuevoSalario);
        }
        System.out.println("Salarios actualizados en " + porcentaje + "s para el departamento " + nombre);
    }   
    public boolean contieneEmpleado(Empleado empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i) == empleado) {
                return true;
            }
        }
        return false;
    }   
    public void moverEmpleadosA(Departamento otroDepartamento) {
        if (empleados.size() == 0) {
            System.out.println("No hay empleados para mover del departamento " + this.nombre);
            return;
        }
        while (empleados.size() > 0) {
            Empleado empleado = empleados.get(0); 
            this.removerEmpleado(empleado);
            otroDepartamento.agregarEmpleado(empleado);
        }
        System.out.println("Todos los empleados movidos de " + this.nombre + " a " + otroDepartamento.nombre);
    }
    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> copia = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            copia.add(empleados.get(i));
        }
        return copia;
    }
    public String getNombre() {
        return nombre;
    }
}