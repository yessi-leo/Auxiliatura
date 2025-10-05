/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer11;

/**
 *
 * @author yessi
 */
public class Pedido {
    private int numero;
    private String estado;
    
    public Pedido(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void mostrar() {
        System.out.println("Pedido " + numero + " - Estado: " + estado);
    }
}
