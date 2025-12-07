/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer3;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author yessi
 */
public class ArchivoProducto {
    private String nomA;
    
    public ArchivoProducto(String n) {
        this.nomA = n;
    }
    
    // a) 
    public void crearArchivo() {
        try {
            File archivo = new File(nomA);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }    
    // b) 
    public void guardaProducto(Producto p) {
        try (FileWriter fw = new FileWriter(nomA, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
             out.println(p.getCodigo() + "," + p.getNombre() + "," + p.getPrecio());
            System.out.println("Producto guardado: " + p.getNombre());
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }
    // c) 
    public Producto buscaProducto(int c) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int codigo = Integer.parseInt(datos[0]);
                    if (codigo == c) {
                        String nombre = datos[1];
                        float precio = Float.parseFloat(datos[2]);
                        return new Producto(codigo, nombre, precio);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            System.out.println(e.getMessage());
        }
        return null; 
    }
    // d)
    public float calcularPromedioPrecios() {
        ArrayList<Producto> productos = leerTodosProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return 0;
        }
        float suma = 0;
        for (Producto p : productos) {
            suma += p.getPrecio();
        }
        return suma / productos.size();
    }
    // e)
    public Producto obtenerProductoMasCaro() {
        ArrayList<Producto> productos = leerTodosProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return null;
        }
        Producto masCaro = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() > masCaro.getPrecio()) {
                masCaro = p;
            }
        }
        return masCaro;
    }
    private ArrayList<Producto> leerTodosProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int codigo = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    float precio = Float.parseFloat(datos[2]);
                    productos.add(new Producto(codigo, nombre, precio));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }
    public void mostrarTodosProductos() {
        ArrayList<Producto> productos = leerTodosProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("----- LISTA DE PRODUCTOS -------");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}