/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer1;
import java.util.*;

/**
 *
 * @author yessi
 */
public class MainEjer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Charango> charangos = Charango.cargarDesdeArchivo();
        int opcion;
        do {
            System.out.println("\n------- MENU CHARANGOS --------");
            System.out.println("1. Agregar charango");
            System.out.println("2. Mostrar todos los charangos");
            System.out.println("3. b)Eliminar charangos con mas de 6 cuerdas false");
            System.out.println("4. c)Listaa de charangos por material");
            System.out.println("5. d)Buscar charangos con 10 cuerdas");
            System.out.println("6. e)Ordenar charangos por material alfabetico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarCharango(scanner, charangos);
                    break;
                case 2:
                    Charango.mostrarTodos(charangos);
                    break;
                case 3:
                    charangos = Charango.eliminarPorCuerdasFalse(charangos);
                    break;
                case 4:
                    listarPorMaterial(scanner, charangos);
                    break;
                case 5:
                    Charango.buscarCon10Cuerdas(charangos);
                    break;
                case 6:
                    charangos = Charango.ordenarPorMaterial(charangos);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        scanner.close();
    }
    private static void agregarCharango(Scanner scanner, List<Charango> charangos) {
        System.out.println("\n--- AGREGAR NUEVO CHARANGO ---");
        System.out.print("Material: ");
        String material = scanner.nextLine();
        System.out.print("Numero de cuerdas: ");
        int nroCuerdas = scanner.nextInt();
        boolean[] cuerdas = new boolean[10];
        System.out.println("Estado de las cuerdas (true = buena, false = mala):");
        for (int i = 0; i < Math.min(nroCuerdas, 10); i++) {
            System.out.print("Cuerda " + (i+1) + ": ");
            cuerdas[i] = scanner.nextBoolean();
        }
        Charango nuevo = new Charango(material, nroCuerdas, cuerdas);
        charangos.add(nuevo);
        System.out.println("Charango agregado correctamente.");
    }
    private static void listarPorMaterial(Scanner scanner, List<Charango> charangos) {
        System.out.println("\n--- LISTA POR MATERIAL ---");
        System.out.print("Material a buscar: ");
        String materialBuscado = scanner.nextLine();
        Charango.listarPorMaterial(charangos, materialBuscado);
    }
}