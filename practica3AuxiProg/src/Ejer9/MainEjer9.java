/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer9;

import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class MainEjer9 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArchZoo archivoZoos;
    public static void main(String[] args) {
        
        System.out.print("Ingrese el nombre del archivo de zoo");
        String nombreArchivo = scanner.nextLine();
        archivoZoos = new ArchZoo(nombreArchivo);
        archivoZoos.cargarDatos();
        int opcion;
        do {
            System.out.println("1. Mostrar todos los zoo");
            System.out.println("2. a) Crear nuevo zoo");
            System.out.println("3. Modificar zoo");
            System.out.println("4. Eliminar zoo");
            System.out.println("5. Agregar animal");
            System.out.println("6. Mostrar animales de zoo");
            System.out.println("7. b) Zoo con mayor variedad de animales");
            System.out.println("8. c) Eliminar zoo vacios");
            System.out.println("9. d) Mostrar animales por especie");
            System.out.println("10. e) Mover animales entre zoológicos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    mostrarTodosZoologicos();
                    break;
                case 2:
                    crearZoologico();
                    break;
                case 3:
                    modificarZoologico();
                    break;
                case 4:
                    eliminarZoologico();
                    break;
                case 5:
                    agregarAnimalAZoologico();
                    break;
                case 6:
                    mostrarAnimalesDeZoologico();
                    break;
                case 7:
                    archivoZoos.listarZoosMayorVariedad();
                    break;
                case 8:
                    archivoZoos.eliminarZoosVacios();
                    break;
                case 9:
                    mostrarAnimalesPorEspecie();
                    break;
                case 10:
                    moverAnimalesEntreZoologicos();
                    break;
                case 0:
                    System.out.println("Guardando datos y saliendo...");
                    archivoZoos.guardarDatos();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        scanner.close();
    }
    private static void mostrarTodosZoologicos() {
        archivoZoos.mostrarTodos();
    }
    private static void crearZoologico() {
        System.out.println("\n----------CREAR NUEVO ZOOLOGICO------------");
        System.out.print("ID del zoologico: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (archivoZoos.buscarZoologicoPorId(id) != null) {
            System.out.println("Ya existe un zoo con ID " + id);
            return;
        }
        System.out.print("Nombre del zoo: ");
        String nombre = scanner.nextLine();
        Zoologico nuevoZoo = new Zoologico(id, nombre);
        archivoZoos.crearZoologico(nuevoZoo);
    }
    
    private static void modificarZoologico() {        
        System.out.print("ID del zoologico a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Zoologico existente = archivoZoos.buscarZoologicoPorId(id);
        if (existente == null) {
            System.out.println("No se encontroel zoo con ID " + id);
            return;
        }
        System.out.println("Zoologico encontrado:");
        existente.mostrar();
        System.out.print("Nuevo nombre del zoologico: ");
        String nuevoNombre = scanner.nextLine();
        Zoologico nuevoZoo = new Zoologico(id, nuevoNombre);
        Animal[] animales = existente.getAnimales();
        for (int i = 0; i < animales.length; i++) {
            nuevoZoo.agregarAnimal(animales[i]);
        }
        archivoZoos.modificarZoologico(id, nuevoZoo);
    }
    private static void eliminarZoologico() {
        System.out.println("\n=== ELIMINAR ZOOLOGICO ===");
        System.out.print("ID del zoologico a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        archivoZoos.eliminarZoologico(id);
    }
    private static void agregarAnimalAZoologico() {
        System.out.println("\n=== AGREGAR ANIMAL A ZOOLOGICO ===");
        System.out.print("ID del zoo: ");
        int idZoo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Zoologico zoo = archivoZoos.buscarZoologicoPorId(idZoo);
        if (zoo == null) {
            System.out.println("No se encontro el zoo con ID " + idZoo);
            return;
        }
        System.out.print("Especie del animal: ");
        String especie = scanner.nextLine();
        System.out.print("Nombre del animal: ");
        String nombreAnimal = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Animal nuevoAnimal = new Animal(especie, nombreAnimal, cantidad);
        if (archivoZoos.agregarAnimalAZoo(idZoo, nuevoAnimal)) {
            System.out.println("Animal agregado exitosamente al zoologico " + zoo.getNombre());
        } else {
            System.out.println("No se pudo agregar el animal");
        }
    }
    
    private static void mostrarAnimalesDeZoologico() {
        System.out.println("\n=== MOSTRAR ANIMALES DE ZOOLOGICO ===");
        System.out.print("ID del zoológico: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Zoologico zoo = archivoZoos.buscarZoologicoPorId(id);
        if (zoo == null) {
            System.out.println("No se encontro el zoo con ID " + id);
            return;
        }
        System.out.println("\nAnimales en " + zoo.getNombre() + ":");
        zoo.mostrarAnimales();
    }
    private static void mostrarAnimalesPorEspecie() {
        System.out.println("\n=== MOSTRAR ANIMALES POR ESPECIE ===");
        System.out.print("Ingrese la especie a buscar: ");
        String especie = scanner.nextLine();
        archivoZoos.mostrarAnimalesPorEspecie(especie);
    }
    private static void moverAnimalesEntreZoologicos() {
        System.out.println("\n=== MOVER ANIMALES ENTRE ZOOLOGICOS ===");
        System.out.print("ID del zoologico origen: ");
        int idOrigen = scanner.nextInt();
        System.out.print("ID del zoologico destino: ");
        int idDestino = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        archivoZoos.moverAnimalesEntreZoos(idOrigen, idDestino);
    }
}