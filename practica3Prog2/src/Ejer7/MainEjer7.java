/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer7;

import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class MainEjer7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArchNiño archivoNiños = new ArchNiño();        
        archivoNiños.leerDatos();
        int opcion;
        do {
            System.out.println("1. Crear nuevo ninio");
            System.out.println("2. Lista de todos los ninios");
            System.out.println("3. Contar ninios con peso adecuado");
            System.out.println("4. Mostrar ninios con peso/talla inadecuada");
            System.out.println("5. Mostrar promedio de edad");
            System.out.println("6. Buscar ninio por carnet");
            System.out.println("7. Mostrar ninios con talla mas alta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();            
            switch (opcion) {
                case 1:
                    System.out.println("\n agragar ninio");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido Paterno: ");
                    String apellidoPaterno = scanner.nextLine();
                    System.out.print("Apellido Materno: ");
                    String apellidoMaterno = scanner.nextLine();
                    System.out.print("CI: ");
                    int ci = scanner.nextInt();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Talla (cm): ");
                    double talla = scanner.nextDouble();
                    Niño nuevoNiño = new Niño(nombre, apellidoPaterno, apellidoMaterno, ci, edad, peso, talla);
                    archivoNiños.crearNiño(nuevoNiño);
                    break;
                case 2:
                    archivoNiños.listarNiños();
                    break;
                case 3:
                    System.out.println("\nNinios con peso adecuado: " + archivoNiños.contarNiñosPesoAdecuado());
                    break;
                case 4:
                    archivoNiños.mostrarNiñosInadecuados();
                    break;
                case 5:
                    System.out.println("\nPromedio de edad: " + String.format("%.2f", archivoNiños.promedioEdad()) + " anios");
                    break;
                case 6:
                    System.out.print("\nIngrese el carnet de identidad a buscar: ");
                    int ciBuscar = scanner.nextInt();
                    Niño encontrado = archivoNiños.buscarPorCarnet(ciBuscar);
                    if (encontrado != null) {
                        System.out.println("Ninio encontrado:");
                        encontrado.mostrar();
                    } else {
                        System.out.println("No se encontro");
                    }
                    break;
                case 7:
                    archivoNiños.mostrarNiñosTallaMasAlta();
                    break;
                case 0:
                    System.out.println("Guardando datos y saliendo...");
                    archivoNiños.guardarDatos();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        scanner.close();
    }
}