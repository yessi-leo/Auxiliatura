/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer31;

import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class MainEjer31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE CLIENTE ---");
        Cliente cliente = new Cliente("", "", "", "", "");
        cliente.leer();
        System.out.println("\n--- REGISTRO DE JEFE ---");
        Jefe jefe = new Jefe("", "", "", "", "");
        jefe.leer();
        cliente.mostrar();
        jefe.mostrar();
    }
}