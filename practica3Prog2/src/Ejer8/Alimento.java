/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yessi
 */
public class Alimento implements Serializable {
    private String nombre;
    private Date fechaVencimiento;
    private int cantidad;
    
    public Alimento() {}
    
    public Alimento(String nombre, Date fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    public void mostrar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nombre: " + nombre +  ", Vencimiento: " + sdf.format(fechaVencimiento) + ", Cantidad: " + cantidad);
    }
    public boolean estaVencido() {
        Date hoy = new Date();
        return fechaVencimiento.before(hoy);
    }
    public boolean venceAntesDe(Date fechaLimite) {
        return fechaVencimiento.before(fechaLimite);
    }
}