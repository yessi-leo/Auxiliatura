/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer3;

/**
 *
 * @author yessi
 */
public class Producto {
    private int codigo;
    private String nombre;
    private float precio;
    
    public Producto(int codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public float getPrecio() {
        return precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: Bs" + precio;
    }
}