/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer14;

/**
 *
 * @author yessi
 */
public class Empresa {
    private String nombre;
    private Empleado[] empleados;
    private int cantidadEmpleados;
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new Empleado[100];
        this.cantidadEmpleados = 0;
    }
    public void agregarEmpleado(Empleado empleado) {
        if (cantidadEmpleados < empleados.length) {
            empleados[cantidadEmpleados] = empleado;
            cantidadEmpleados++;
            System.out.println("Empleado " + empleado.getNombre() + " agregado a " + nombre);
        } else {
            System.out.println("No hay espacio para mas empleados en " + nombre);
        }
    }
    public void mostrarInformacion() {
        System.out.println("------------- EMPRESA: " + nombre + " --------------");
        System.out.println("Total de empleados: " + cantidadEmpleados);
        System.out.println("Lista de empleados:");
        if (cantidadEmpleados == 0) {
            System.out.println("  No hay empleados");
        } else {
            for (int i = 0; i < cantidadEmpleados; i++) {
                System.out.println("  " + (i + 1) + ". " + empleados[i]);
            }
        }
        System.out.println();
    }
    public Empleado buscarEmpleado(String nombreBuscado) {
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].getNombre().equals(nombreBuscado)) {
                return empleados[i];
            }
        }
        return null;
    }
    public boolean eliminarEmpleado(String nombreBuscado) {
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].getNombre().equals(nombreBuscado)) {
                for (int j = i; j < cantidadEmpleados - 1; j++) {
                    empleados[j] = empleados[j + 1];
                }
                empleados[cantidadEmpleados - 1] = null;
                cantidadEmpleados--;
                System.out.println("Empleado " + nombreBuscado + " eliminado");
                return true;
            }
        }
        System.out.println("Empleado " + nombreBuscado + " no encontrado");
        return false;
    }
    public double calcularPromedioSalarial() {
        if (cantidadEmpleados == 0) {
            return 0;
        }
        double totalSalarios = 0;
        for (int i = 0; i < cantidadEmpleados; i++) {
            totalSalarios += empleados[i].getSalario();
        }
        return totalSalarios / cantidadEmpleados;
    }
    public void listarEmpleadosSalarioMayor(double salarioMinimo) {
        System.out.println("Empleados con salario mayor a Bs/" + salarioMinimo + ":");
        boolean encontrados = false;
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].getSalario() > salarioMinimo) {
                System.out.println("  " + empleados[i]);
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("  No hay empleados con salario mayor a Bs/" + salarioMinimo);
        }
        System.out.println();
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }
}