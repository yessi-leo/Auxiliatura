/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

/**
 *
 * @author yessi
 */
public class MainEjer8 {
    public static void main(String[] args) {
        Facultad fac1 = new Facultad("Sistemas", "FIS");
        Facultad fac2 = new Facultad("Administración", "FAD");
        Persona enc1 = new Persona("Carlos", 25, "12345678");
        Persona enc2 = new Persona("Ana", 23, "87654321");
        Fraternidad frat1 = new Fraternidad("Los Tigres", enc1);
        Fraternidad frat2 = new Fraternidad("Las Águilas", enc2);
        Bailarin b1 = new Bailarin("Juan", 20, "11111111", fac1);
        Bailarin b2 = new Bailarin("Maria", 21, "22222222", fac1);
        Bailarin b3 = new Bailarin("Pedro", 22, "33333333", fac2);
        frat1.agregarBailarin(b1);
        frat1.agregarBailarin(b2);
        frat2.agregarBailarin(b3);
        System.out.println("Fraternidad: " + frat1.getNombre());
        System.out.println("Encargado: " + frat1.getEncargado().getNombre());
        frat1.mostrarBailarines();
    }
}
