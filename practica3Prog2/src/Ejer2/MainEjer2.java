/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;
import java.util.*;
/**
 *
 * @author yessi
 */
public class MainEjer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArchivoTrabajador archivo = new ArchivoTrabajador();        
        archivo.cargarDesdeArchivo();
        int opcion;
        do {
            System.out.println("\n------ SISTEMA DE TRABAJADORES -------");
            System.out.println("1. a)Crear archivo");
            System.out.println("2. b)Agregar y guarda trabajador");
            System.out.println("3. Mostrar todos los trabajadores");
            System.out.println("4. c)Aumentar salario a trabajador por carnet");
            System.out.println("5. d)Buscar trabajador con mayor salario");
            System.out.println("6. e)Ordenar trabajadores por salario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    archivo.crearArchivo();
                    break;
                case 2:
                    agregarTrabajador(scanner, archivo);
                    break;
                case 3:
                    archivo.mostrarTodos();
                    break;
                case 4:
                    aumentarSalario(scanner, archivo);
                    break;
                case 5:
                    archivo.buscarMayorSalario();
                    break;
                case 6:
                    archivo.ordenarPorSalario();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
    private static void agregarTrabajador(Scanner scanner, ArchivoTrabajador archivo) {
        System.out.println("\n--- AGREGAR NUEVO TRABAJADOR ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Carnet: ");
        int carnet = scanner.nextInt();
        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); 
        Trabajador nuevo = new Trabajador(nombre, carnet, salario);
        archivo.guardarTrabajador(nuevo);
    }
    private static void aumentarSalario(Scanner scanner, ArchivoTrabajador archivo) {
        System.out.println("\n--- AUMENTAR SALARIO ---");
        System.out.print("Ingrese el carnet del trabajador: ");
        int carnet = scanner.nextInt();
        System.out.print("Porcentaje de aumento: ");
        int porcentaje = scanner.nextInt();
        Trabajador trabajador = archivo.buscarPorCarnet(carnet);
        if (trabajador != null) {
            archivo.aumentaSalario(porcentaje, trabajador);
        } else {
            System.out.println("Trabajador con carnet " + carnet + " no encontrado.");
        }
    }
}