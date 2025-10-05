/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer25;

/**
 *
 * @author yessi
 */
public class Celular {
    
    String nroTel;
    String dueño;
    int espacio;
    int ram;
    int nroApp;
    
    public Celular(String nroTel, String dueño, int espacio, int ram, int nroApp) {
        this.nroTel = nroTel;
        this.dueño = dueño;
        this.espacio = espacio;
        this.ram = ram;
        this.nroApp = nroApp;
    }
    
    public void aumentarApps() {
        nroApp += 10;
    }
    
    public void disminuirEspacio() {
        espacio -= 5;
    }
    
    public void mostrarDatos() {
        System.out.println("Nro: " + nroTel);
        System.out.println("Dueno: " + dueño);
        System.out.println("Espacio: " + espacio + " GB");
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Apps: " + nroApp);
        System.out.println("-------------------");
    }
}
