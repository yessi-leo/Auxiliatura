/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;
import java.io.*;
import java.util.*;
/**
 *
 * @author yessi
 */
public class ArchivoTrabajador {
    private static final String ARCHIVO_DAT = "trabajadore.dat";
    private List<Trabajador> trabajadores;
    
    public ArchivoTrabajador() {
        this.trabajadores = new ArrayList<>();
    }
    // a) 
    public void crearArchivo() {
        File archivo = new File(ARCHIVO_DAT);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + ARCHIVO_DAT);
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }
    public void cargarDesdeArchivo() {
        trabajadores.clear();
        File archivo = new File(ARCHIVO_DAT);
        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado.Creando lista vacia.");
            return;
        }
        try (FileInputStream file = new FileInputStream(ARCHIVO_DAT);
             ObjectInputStream entrada = new ObjectInputStream(file)) {
            while (true) {
                try {
                    Trabajador trabajador = (Trabajador) entrada.readObject();
                    trabajadores.add(trabajador);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Se cargaron " + trabajadores.size() + " trabajadores desde el archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
        }
    }
    // b) 
    public void guardarTrabajador(Trabajador t) {
        trabajadores.add(t);
        System.out.println("Trabajador guardado: " + t.getNombre());
        guardarEnArchivo();
    }
    private void guardarEnArchivo() {
        try (FileOutputStream file = new FileOutputStream(ARCHIVO_DAT);
             ObjectOutputStream salida = new ObjectOutputStream(file)) {
            for (Trabajador trabajador : trabajadores) {
                salida.writeObject(trabajador);
            }
            System.out.println("Datos guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }
    // c) 
    public void aumentaSalario(int porcentaje, Trabajador t) {
        boolean encontrado = false;
        for (int i = 0; i < trabajadores.size(); i++) {
            Trabajador trabajador = trabajadores.get(i);
            if (trabajador.getNombre().equals(t.getNombre()) && 
                trabajador.getCarnet() == t.getCarnet()) {
                double salarioActual = trabajador.getSalario();
                double aumento = salarioActual * (porcentaje / 100.0);
                trabajador.setSalario(salarioActual + aumento);
                System.out.print("Salario aumentado: "+trabajador.getNombre()+"  Nuevo salario:Bs "+trabajador.getSalario()+"  ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Trabajador no encontrado.");
        } else {
            guardarEnArchivo();
        }
    }
    // d) 
    public Trabajador buscarMayorSalario() {
        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores registrados.");
            return null;
        }
        Trabajador mayorSalario = trabajadores.get(0);
        for (int i = 1; i < trabajadores.size(); i++) {
            Trabajador actual = trabajadores.get(i);
            if (actual.getSalario() > mayorSalario.getSalario()) {
                mayorSalario = actual;
            }
        }
        System.out.println("Trabajador con mayor salario: " + mayorSalario);
        return mayorSalario;
    }
    // e) 
    public List<Trabajador> ordenarPorSalario() {
        List<Trabajador> ordenados = new ArrayList<>(trabajadores);
        for (int i = 0; i < ordenados.size() - 1; i++) {
            for (int j = 0; j < ordenados.size() - i - 1; j++) {
                if (ordenados.get(j).getSalario() > ordenados.get(j + 1).getSalario()) {
                    Trabajador temp = ordenados.get(j);
                    ordenados.set(j, ordenados.get(j + 1));
                    ordenados.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nTrabajadores ordenados por salario:");
        for (Trabajador t : ordenados) {
            System.out.println(t);
        }
        return ordenados;
    }
    public void mostrarTodos() {
        System.out.println("\n---- LISTA DE TRABAJADORES (" + trabajadores.size() + ")-----");
        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores registrados.");
            return;
        }
        int i = 0;
        while (i < trabajadores.size()) {
            System.out.println((i + 1) + ". " + trabajadores.get(i));
            i++;
        }
    }
    public Trabajador buscarPorCarnet(int carnet) {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getCarnet() == carnet) {
                return trabajador;
            }
        }
        return null;
    }
    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }
}