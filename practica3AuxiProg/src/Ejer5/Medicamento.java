/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer5;

import java.util.Scanner;

/**
 *
 * @author yessi
 */
public class Medicamento {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;
    
    public Medicamento() {
        this.nombre = "";
        this.codMedicamento = 0;
        this.tipo = "";
        this.precio = 0.0;
    }
    
    public Medicamento(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void mostrar() {
        System.out.println("--------------------------------------");
        System.out.println("Medicamento: " + nombre);
        System.out.println("Codigo: " + codMedicamento);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: Bs" + precio);
    }
    
    public void leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------MEDICAMENTOS-----------");
        System.out.print("Nombre del medicamento: ");
        this.nombre = scanner.nextLine();
        System.out.print("Codigo: ");
        this.codMedicamento = scanner.nextInt();
        System.out.print("Tipo (ej: tos, resfriado, analgesico): ");
        this.tipo = scanner.nextLine();
        System.out.print("Precio: ");
        this.precio = scanner.nextDouble();        
    }
    
    @Override
    public String toString() {
        return codMedicamento + " - " + nombre + " (" + tipo + ") - Bs" + precio;
    }
}