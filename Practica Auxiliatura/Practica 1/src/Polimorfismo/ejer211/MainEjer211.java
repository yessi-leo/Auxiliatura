/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer211;

/**
 *
 * @author yessi
 */
public class MainEjer211 {
    public static void main(String[] args) {
        System.out.println("---- INSTANCIANDO CRUCEROS Y PASAJEROS ----\n");
        Crucero caribe = new Crucero("Caribe Paradise", "Mexico", "Bahamas");
        Crucero mediterraneo = new Crucero("Mediterranean Dream", "Espana", "Italia");
        Pasajero p1 = new Pasajero("Juan Vargas", 35, "M", 502, 500.0);
        Pasajero p2 = new Pasajero("Martina Vasques", 28, "F", 603, 1000.0);
        Pasajero p3 = new Pasajero("Wilmer Montero", 42, "M", 401, 925.0);
        Pasajero p4 = new Pasajero("Ana Garcia", 31, "F", 305, 750.0);
        Pasajero p5 = new Pasajero("Carlos Lopez", 45, "M", 208, 850.0);
        caribe.agregarPasajero(0, p1);
        caribe.agregarPasajero(1, p2);
        caribe.agregarPasajero(2, p3);
        mediterraneo.agregarPasajero(0, p4);
        mediterraneo.agregarPasajero(1, p5);
        mediterraneo.agregarPasajero(2, p2); 
        System.out.println("---- OPERADORES ++ Y -- (LECTURA Y MUESTRA) ----\n");
        System.out.println("--- Operador ++ (Lectura) ---");
        caribe.incrementar();
        p1.incrementar();
        System.out.println("\n--- Operador -- (Mostrar) ---");
        caribe.decrementar();
        p1.decrementar();
        System.out.println("\n---- OPERADOR == (SUMA TOTAL COSTOS) -----");
        caribe.igualIgual();
        mediterraneo.igualIgual();
        System.out.println("\n---- OPERADOR + (COMPARAR CANTIDAD PASAJEROS) ----");
        caribe.mas(mediterraneo);
        System.out.println("\n---- OPERADOR - (DISTRIBUCION POR GENERO) ----");
        caribe.menos();
        mediterraneo.menos();
    }
}
