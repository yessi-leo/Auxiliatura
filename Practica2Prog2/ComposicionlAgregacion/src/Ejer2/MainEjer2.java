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
public class MainEjer2 {
    public static void main(String[] args) {
        System.out.println(" a) INSTANCIAR DEPARTAMENTOS ");
        Departamento departamento1 = new Departamento("Ventas1");
        Departamento departamento2 = new Departamento("Ventas2");
        
        Empleado emp1 = new Empleado("Juan", 3000);
        Empleado emp2 = new Empleado("Maria", 3500);
        Empleado emp3 = new Empleado("Carlos", 3200);
        Empleado emp4 = new Empleado("YEssica", 3800);
        Empleado emp5 = new Empleado("Leoni", 3100);
        
        departamento1.agregarEmpleado(emp1);
        departamento1.agregarEmpleado(emp2);
        departamento1.agregarEmpleado(emp3);
        departamento1.agregarEmpleado(emp4);
        departamento1.agregarEmpleado(emp5);
        
        System.out.println("Departamento 1: " + departamento1.getNombre());
        System.out.println("Departamento 2: " + departamento2.getNombre());
        System.out.println();
        
        System.out.println("b) MOSTRAR EMPLEADOS ");
        departamento1.mostrarEmpleados();
        departamento2.mostrarEmpleados();
        
        System.out.println(" c) CAMBIO DE SALARIO ");
        departamento1.cambioSalario(10); 
        departamento1.mostrarEmpleados();
        
        System.out.println("d) VERIFICAR EMPLEADOS COMPARTIDOS ");
        boolean encontrado = false;
        ArrayList<Empleado> empleadosDepto1 = departamento1.getEmpleados();
        
        for (int i = 0; i < empleadosDepto1.size(); i++) {
            Empleado empleado = empleadosDepto1.get(i);
            if (departamento2.contieneEmpleado(empleado)) {
                System.out.println("EMPLEADO COMPARTIDO: " + empleado.getNombre());
                encontrado = true;
            }
        }
        
        if (encontrado == false) {
            System.out.println("No hay empleados compartidos entre departamentos");
        }
        System.out.println();
        
        System.out.println("e) MOVER EMPLEADOS ");
        System.out.println("Antes de mover:");
        departamento1.mostrarEmpleados();
        departamento2.mostrarEmpleados();
        
        departamento1.moverEmpleadosA(departamento2);
        
        System.out.println("Despues de mover:");
        departamento1.mostrarEmpleados();
        departamento2.mostrarEmpleados();
    }
}