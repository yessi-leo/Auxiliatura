/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

/**
 *
 * @author yessi
 */
public class Fraternidad {
    private String nombre;
    private Persona encargado;
    private Bailarin[] bailarines;
    private int cont;
    public Fraternidad(String nombre, Persona encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.bailarines = new Bailarin[50];
        this.cont = 0;
    }
    public void agregarBailarin(Bailarin b) {
        if (cont < bailarines.length) {
            bailarines[cont] = b;
            cont++;
            b.setFraternidad(this);
        }
    }
    public void mostrarBailarines() {
        for (int i = 0; i < cont; i++) {
            System.out.println(bailarines[i].getNombre());
        }
    }
    
    public String getNombre() { return nombre; }
    public Persona getEncargado() { return encargado; }

    public Bailarin[] getBailarines() {
        return bailarines;
    }

    public int getCont() {
        return cont;
    }
}