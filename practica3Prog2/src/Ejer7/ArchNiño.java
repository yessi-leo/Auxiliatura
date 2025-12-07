/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer7;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author yessi
 */
public class ArchNiño {
    private ArrayList<Niño> listaNiños;
    private final String ARCHIVO = "niños.dat";
    
    public ArchNiño() {
        listaNiños = new ArrayList<>();
    }
    // a) 
    public void crearNiño(Niño niño) {
        listaNiños.add(niño);
        System.out.println("Agregado exitosamente");
    }
    public void leerDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            listaNiños = (ArrayList<Niño>) ois.readObject();
            System.out.println("Datos cargados exitosamente");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(listaNiños);
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void listarNiños() {
        if (listaNiños.isEmpty()) {
            System.out.println("No hay registros");
            return;
        }
        System.out.println("\n LISTA DE NINIOS ");
        for (int i = 0; i < listaNiños.size(); i++) {
            System.out.print((i + 1) + ". ");
            listaNiños.get(i).mostrar();
        }
    }
    public void mostrarNiño(int indice) {
        if (indice >= 0 && indice < listaNiños.size()) {
            listaNiños.get(indice).mostrar();
        } else {
            System.out.println("no vlido");
        }
    }
    // b) 
    public int contarNiñosPesoAdecuado() {
        int contador = 0;
        for (Niño niño : listaNiños) {
            if (niño.pesoAdecuado()) {
                contador++;
            }
        }
        return contador;
    }
    // c) 
    public void mostrarNiñosInadecuados() {
        System.out.println("\n NIÑOS CON PESO O TALLA INADECUADA ");
        boolean encontrado = false;
        for (Niño niño : listaNiños) {
            if (!niño.pesoAdecuado() || !niño.tallaAdecuada()) {
                niño.mostrar();
                System.out.println("  - Peso adecuado: " + (niño.pesoAdecuado() ? "Si" : "No"));
                System.out.println("  - Talla adecuada: " + (niño.tallaAdecuada() ? "Si" : "No"));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Todos los ninios tienen peso y talla adecuados.");
        }
    }
    // d) 
    public double promedioEdad() {
        if (listaNiños.isEmpty()) {
            return 0;
        }
        
        int sumaEdades = 0;
        for (Niño niño : listaNiños) {
            sumaEdades += niño.getEdad();
        }
        
        return (double) sumaEdades / listaNiños.size();
    }
    // e) 
    public Niño buscarPorCarnet(int ci) {
        for (Niño niño : listaNiños) {
            if (niño.getCi() == ci) {
                return niño;
            }
        }
        return null;
    }
    // f)
    public void mostrarNiñosTallaMasAlta() {
        if (listaNiños.isEmpty()) {
            System.out.println("No hay ninios registrados.");
            return;
        }
        double tallaMaxima = 0;
        for (Niño niño : listaNiños) {
            if (niño.getTalla() > tallaMaxima) {
                tallaMaxima = niño.getTalla();
            }
        }
        System.out.println("\n NINIOS CON LA TALLA MAS ALTA (" + tallaMaxima + " cm) ===");
        for (Niño niño : listaNiños) {
            if (niño.getTalla() == tallaMaxima) {
                niño.mostrar();
            }
        }
    }
}