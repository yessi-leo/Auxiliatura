/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer13;

/**
 *
 * @author yessi
 */
public class Main13 {
    public static void main(String[] args) {
        Fruta fruta1 = new Fruta("Kiwi", "Subtropical", new String[]{"K", "C", "E"});
        Fruta fruta2 = new Fruta("Naranja", "Citrica", new String[]{"C", "A"});
        Fruta fruta3 = new Fruta("Manzana", "Templada", new String[]{"C", "K"});
        
        System.out.println("Fruta con mas vitaminas:");
        if (fruta1.nroVitaminas > fruta2.nroVitaminas && fruta1.nroVitaminas > fruta3.nroVitaminas) {
            System.out.println(fruta1.nombre);
        } else if (fruta2.nroVitaminas > fruta3.nroVitaminas) {
            System.out.println(fruta2.nombre);
        } else {
            System.out.println(fruta3.nombre);
        }
        
        System.out.println("\nVitaminas de la Naranja:");
        fruta2.mostrarVitaminas();
        
        int contadorC = 0;
        for (int i = 0; i < fruta1.v.length; i++) {
            if (fruta1.v[i].equals("C")) contadorC++;
        }
        for (int i = 0; i < fruta2.v.length; i++) {
            if (fruta2.v[i].equals("C")) contadorC++;
        }
        for (int i = 0; i < fruta3.v.length; i++) {
            if (fruta3.v[i].equals("C")) contadorC++;
        }
        System.out.println("\nTotal de vitaminas C: " + contadorC);
    }
}
