/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer25;

/**
 *
 * @author yessi
 */
public class Main25 {
    public static void main(String[] args) {
        Celular celular = new Celular("77712345", "Juan", 64, 4, 20);
        
        System.out.println("ANTES:");
        celular.mostrarDatos();
        
        celular.aumentarApps();
        celular.disminuirEspacio();
        
        System.out.println("DESPUES:");
        celular.mostrarDatos();
        
        celular.aumentarApps();
        celular.disminuirEspacio();
        
        System.out.println("DESPUES DE SEGUNDA OPERACIEN:");
        celular.mostrarDatos();
    }
}
