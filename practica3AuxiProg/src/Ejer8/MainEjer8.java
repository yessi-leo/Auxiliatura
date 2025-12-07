/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class MainEjer8 {
private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        System.out.print("Ingrese el nombre del refrigerador: ");
        String nombreRefri = scanner.nextLine();
        
        ArchRefri refrigerador = new ArchRefri(nombreRefri);
        
        // Cargar datos existentes
        refrigerador.cargarDatos();
        
        int opcion;
        
        do {
            System.out.println("\n=== MENU PRINCIPAL - " + nombreRefri.toUpperCase() + " ===");
            System.out.println("1. Mostrar todos los alimentos");
            System.out.println("2. Crear nuevo alimento");
            System.out.println("3. Modificar alimento por nombre");
            System.out.println("4. Eliminar alimento por nombre");
            System.out.println("5. Mostrar alimentos que caducan antes de fecha X");
            System.out.println("6. Eliminar alimentos con cantidad 0");
            System.out.println("7. Mostrar alimentos vencidos");
            System.out.println("8. Mostrar alimento con mas cantidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    refrigerador.mostrarTodos();
                    break;
                    
                case 2:
                    crearAlimento(refrigerador);
                    break;
                    
                case 3:
                    modificarAlimento(refrigerador);
                    break;
                    
                case 4:
                    eliminarAlimento(refrigerador);
                    break;
                    
                case 5:
                    mostrarCaducadosAntesDeFecha(refrigerador);
                    break;
                    
                case 6:
                    refrigerador.eliminarAlimentosCantidadCero();
                    break;
                    
                case 7:
                    mostrarAlimentosVencidos(refrigerador);
                    break;
                    
                case 8:
                    refrigerador.mostrarAlimentoMasCantidad();
                    break;
                    
                case 10:
                    refrigerador.guardarDatos();
                    break;
                    
                case 0:
                    System.out.println("Guardando datos y saliendo...");
                    refrigerador.guardarDatos();
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void crearAlimento(ArchRefri refrigerador) {
        System.out.println("\n=== CREAR NUEVO ALIMENTO ===");
        System.out.print("Nombre del alimento: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Fecha de vencimiento (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        try {
            Date fechaVencimiento = sdf.parse(fechaStr);
            Alimento nuevoAlimento = new Alimento(nombre, fechaVencimiento, cantidad);
            refrigerador.crearAlimento(nuevoAlimento);
        } catch (Exception e) {
            System.out.println("Error en el formato de fecha. Use dd/MM/yyyy");
        }
    }
    
    private static void modificarAlimento(ArchRefri refrigerador) {
        System.out.println("\n=== MODIFICAR ALIMENTO ===");
        System.out.print("Nombre del alimento a modificar: ");
        String nombre = scanner.nextLine();
        
        // Buscar si existe
        Alimento existente = refrigerador.buscarAlimento(nombre);
        if (existente == null) {
            System.out.println("No se encontró el alimento '" + nombre + "'.");
            return;
        }
        
        System.out.println("Alimento encontrado. Ingrese los nuevos datos:");
        existente.mostrar();
        
        System.out.print("Nuevo nombre (presione Enter para mantener): ");
        String nuevoNombre = scanner.nextLine();
        if (nuevoNombre.trim().isEmpty()) {
            nuevoNombre = existente.getNombre();
        }
        
        System.out.print("Nueva fecha de vencimiento (dd/MM/yyyy) (presione Enter para mantener): ");
        String fechaStr = scanner.nextLine();
        Date nuevaFecha;
        if (fechaStr.trim().isEmpty()) {
            nuevaFecha = existente.getFechaVencimiento();
        } else {
            try {
                nuevaFecha = sdf.parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Formato de fecha invalido. Se mantiene la fecha original.");
                nuevaFecha = existente.getFechaVencimiento();
            }
        }
        
        System.out.print("Nueva cantidad (presione Enter para mantener " + existente.getCantidad() + "): ");
        String cantidadStr = scanner.nextLine();
        int nuevaCantidad;
        if (cantidadStr.trim().isEmpty()) {
            nuevaCantidad = existente.getCantidad();
        } else {
            try {
                nuevaCantidad = Integer.parseInt(cantidadStr);
            } catch (NumberFormatException e) {
                System.out.println("Cantidad invalida");
                nuevaCantidad = existente.getCantidad();
            }
        }
        
        Alimento nuevoAlimento = new Alimento(nuevoNombre, nuevaFecha, nuevaCantidad);
        refrigerador.modificarPorNombre(nombre, nuevoAlimento);
    }
    
    private static void eliminarAlimento(ArchRefri refrigerador) {
        System.out.println("\n=== ELIMINAR ALIMENTO ===");
        System.out.print("Nombre del alimento a eliminar: ");
        String nombre = scanner.nextLine();
        
        refrigerador.eliminarPorNombre(nombre);
    }
    
    private static void mostrarCaducadosAntesDeFecha(ArchRefri refrigerador) {
        System.out.println("\n=== ALIMENTOS QUE CADUCAN ANTES DE FECHA ===");
        System.out.print("Ingrese la fecha limite (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        
        try {
            Date fechaLimite = sdf.parse(fechaStr);
            refrigerador.mostrarCaducadosAntesDe(fechaLimite);
        } catch (Exception e) {
            System.out.println("Error en el formato de fecha. Use dd/MM/yyyy");
        }
    }
    
    private static void mostrarAlimentosVencidos(ArchRefri refrigerador) {
        ArrayList<Alimento> vencidos = refrigerador.buscarAlimentosVencidos();
        
        System.out.println("\n=== ALIMENTOS VENCIDOS ===");
        if (vencidos.isEmpty()) {
            System.out.println("No hay alimentos vencidos");
        } else {
            System.out.println("Se encontraron " + vencidos.size() + " alimentos vencidos:");
            for (int i = 0; i < vencidos.size(); i++) {
                System.out.print((i + 1) + ". ");
                vencidos.get(i).mostrar();
            }
        }
    }
}