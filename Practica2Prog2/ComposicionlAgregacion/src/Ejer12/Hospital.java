/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer12;

/**
 *
 * @author yessi
 */
public class Hospital {
    private String nombre;
    private Doctor[] doctores;
    private int cantidadDoctores;
    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new Doctor[100];
        this.cantidadDoctores = 0;
    }
    public void asignarDoctor(Doctor doctor) {
        if (cantidadDoctores < doctores.length) {
            doctores[cantidadDoctores] = doctor;
            cantidadDoctores++;
            System.out.println("Doctor " + doctor.getNombre() + " asignado al hospital " + nombre);
        } else {
            System.out.println("No hay espacio para más doctores en " + nombre);
        }
    }
    public void mostrarDoctores() {
        System.out.println("Doctores del hospital " + nombre + ":");
        if (cantidadDoctores == 0) {
            System.out.println("  No hay doctores asignados");
        } else {
            for (int i = 0; i < cantidadDoctores; i++) {
                System.out.println("  " + (i + 1) + ". " + doctores[i]);
            }
        }
        System.out.println();
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadDoctores() {
        return cantidadDoctores;
    }
}