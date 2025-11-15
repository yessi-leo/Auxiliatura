/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer12;

/**
 *
 * @author yessi
 */
public class MainEjer12 {
    public static void main(String[] args) {
        System.out.println("----------- CREANDO DOCTORES ----------");
        Doctor doctor1 = new Doctor("Dr. Yessica Leon", "Cardiologia");
        Doctor doctor2 = new Doctor("Dra. Ana Lopez", "Pediatria");
        Doctor doctor3 = new Doctor("Dr. Roberto Garcia", "Cirugia");
        Doctor doctor4 = new Doctor("Dra. Laura Torres", "Neurologia");
        System.out.println("Doctores creados:");
        System.out.println("1. " + doctor1);
        System.out.println("2. " + doctor2);
        System.out.println("3. " + doctor3);
        System.out.println("4. " + doctor4);
        System.out.println();
        System.out.println("----------- CREANDO HOSPITALES --------------");
        Hospital hospital1 = new Hospital("Hospital Central");
        Hospital hospital2 = new Hospital("Hospital del Norte");
        Hospital hospital3 = new Hospital("Clinica Sur");
        System.out.println("Hospitales creados:");
        System.out.println("1. " + hospital1.getNombre());
        System.out.println("2. " + hospital2.getNombre());
        System.out.println("3. " + hospital3.getNombre());
        System.out.println();
        System.out.println("------------- ASIGNANDO DOCTORES A HOSPITALES ------------");
        hospital1.asignarDoctor(doctor1);
        hospital1.asignarDoctor(doctor2);
        hospital1.asignarDoctor(doctor3);
        hospital2.asignarDoctor(doctor2); 
        hospital2.asignarDoctor(doctor4);
        hospital3.asignarDoctor(doctor1); 
        hospital3.asignarDoctor(doctor3); 
        hospital3.asignarDoctor(doctor4); 
        System.out.println();
        System.out.println("------------ DOCTORES POR HOSPITAL -------------------");
        hospital1.mostrarDoctores();
        hospital2.mostrarDoctores();
        hospital3.mostrarDoctores();
        System.out.println("----------- DEMOSTRACION DE AGREGACION -------------");
        System.out.println("Los doctores existen independientemente de los hospitales:");
        System.out.println("Doctor 1: " + doctor1.getNombre() + " existe sin hospital");
        System.out.println("Doctor 2: " + doctor2.getNombre() + " existe sin hospital");
        System.out.println("Doctor 3: " + doctor3.getNombre() + " existe sin hospital");
        System.out.println("Doctor 4: " + doctor4.getNombre() + " existe sin hospital");
    }
}