/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer14;

/**
 *
 * @author yessi
 */
public class MainEjer14 {
    public static void main(String[] args) {
        System.out.println("------------ CREANDO EMPRESA Y EMPLEADOS -----------");
        Empresa empresa = new Empresa("Tech Solutions ");
        Empleado emp1 = new Empleado("Juan Perez", "Gerente", 5000);
        Empleado emp2 = new Empleado("Yessica Leon", "Desarrollador", 3500);
        Empleado emp3 = new Empleado("Carlos Lopez", "Analista", 4000);
        Empleado emp4 = new Empleado("Ana Martinez", "Desarrollador", 3200);
        Empleado emp5 = new Empleado("Pedro Rodriguez", "Diseniador", 2800);
        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        empresa.agregarEmpleado(emp4);
        empresa.agregarEmpleado(emp5);
        System.out.println();
        System.out.println("---------- INFORMACION DE LA EMPRESA -----------");
        empresa.mostrarInformacion();
        System.out.println("----------- BUSCAR EMPLEADO ------------");
        Empleado empleadoBuscado = empresa.buscarEmpleado("Yessica Leon");
        if (empleadoBuscado != null) {
            System.out.println("Empleado encontrado: " + empleadoBuscado);
        } else {
            System.out.println("Empleado no encontrado");
        }
        empleadoBuscado = empresa.buscarEmpleado("Luis Torres");
        if (empleadoBuscado == null) {
            System.out.println("Empleado Luis Torres no encontrado");
        }
        System.out.println();
        System.out.println("--------- PROMEDIO SALARIAL ----------");
        double promedio = empresa.calcularPromedioSalarial();
        System.out.println("Promedio salarial: Bs/" + promedio);
        System.out.println();
        System.out.println("---------- EMPLEADOS CON SALARIO MAYOR A Bs/3500 ----------");
        empresa.listarEmpleadosSalarioMayor(3500);
        System.out.println("------------ ELIMINAR EMPLEADO ---------");
        empresa.eliminarEmpleado("Carlos Lopez");
        System.out.println();
        System.out.println("---------- INFORMACION ACTUALIZADA ------------");
        empresa.mostrarInformacion();
        System.out.println("------------ NUEVO PROMEDIO SALARIAL -----------");
        promedio = empresa.calcularPromedioSalarial();
        System.out.println("Nuevo promedio salarial: Bs/" + promedio);
        System.out.println();
        System.out.println("----------- EMPLEADOS CON SALARIO MAYOR A Bs/3000 -----------");
        empresa.listarEmpleadosSalarioMayor(3000);
    }
}