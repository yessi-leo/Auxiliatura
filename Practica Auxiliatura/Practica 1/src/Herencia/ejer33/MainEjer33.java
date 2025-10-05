/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer33;

/**
 *
 * @author yessi
 */
public class MainEjer33 {
    public static void main(String[] args) {
        Animal[] animales = new Animal[6];
        animales[0] = new Leon("Simba", 5);
        animales[1] = new Pinguino("Pingu", 3);
        animales[2] = new Canguro("Saltarin", 4);
        animales[3] = new Leon("Alvin", 4);
        animales[4] = new Pinguino("Lili", 2);
        animales[5] = new Canguro("Figaro", 1);
        
        System.out.println("---- DESPLAZAMIENTO -----");
        for (int i = 0; i < animales.length; i++) {
            animales[i].desplazarse();
        }
    }
}