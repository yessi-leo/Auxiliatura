/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer10;

/**
 *
 * @author yessi
 */
public class Participante extends Persona {
    private int noTicket;
    public Participante(String nombre, String apellido, int edad, int ci, int noTicket) {
        super(nombre, apellido, edad, ci);
        this.noTicket = noTicket;
    }
    public int getNoTicket() { return noTicket; }
}