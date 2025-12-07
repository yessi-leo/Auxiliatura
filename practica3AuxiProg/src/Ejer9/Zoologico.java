/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer9;

import java.io.Serializable;

/**
 *
 * @author yessi
 */
public class Zoologico implements Serializable {
    private int id;
    private String nombre;
    private int noAnimales;
    private Animal[] animales;
    private static final int MAX_ANIMALES = 30;
    
    public Zoologico() {
        this.animales = new Animal[MAX_ANIMALES];
        this.noAnimales = 0;
    }
    
    public Zoologico(int id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoAnimales() {
        return noAnimales;
    }

    public void setNoAnimales(int noAnimales) {
        this.noAnimales = noAnimales;
    }
    public boolean agregarAnimal(Animal animal) {
        if (noAnimales < MAX_ANIMALES) {
            animales[noAnimales] = animal;
            noAnimales++;
            return true;
        }
        return false;
    }
    public boolean eliminarAnimal(int indice) {
        if (indice >= 0 && indice < noAnimales) {
            for (int i = indice; i < noAnimales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            animales[noAnimales - 1] = null;
            noAnimales--;
            return true;
        }
        return false;
    }
    
    public boolean eliminarAnimalPorNombre(String nombreAnimal) {
        for (int i = 0; i < noAnimales; i++) {
            if (animales[i].getNombre().equalsIgnoreCase(nombreAnimal)) {
                eliminarAnimal(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean modificarAnimal(int indice, Animal nuevoAnimal) {
        if (indice >= 0 && indice < noAnimales) {
            animales[indice] = nuevoAnimal;
            return true;
        }
        return false;
    }
    public int getVariedadEspecies() {
        int especiesDiferentes = 0;
        String[] especiesUnicas = new String[noAnimales];
        for (int i = 0; i < noAnimales; i++) {
            String especieActual = animales[i].getEspecie();
            boolean encontrada = false;
            for (int j = 0; j < especiesDiferentes; j++) {
                if (especiesUnicas[j].equals(especieActual)) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                especiesUnicas[especiesDiferentes] = especieActual;
                especiesDiferentes++;
            }
        }
        return especiesDiferentes;
    }
    public boolean estaVacio() {
        return noAnimales == 0;
    }
    public Animal[] getAnimalesPorEspecie(String especie) {
        int contador = 0;
        for (int i = 0; i < noAnimales; i++) {
            if (animales[i].getEspecie().equalsIgnoreCase(especie)) {
                contador++;
            }
        }
        Animal[] resultado = new Animal[contador];
        int posicion = 0;
        for (int i = 0; i < noAnimales; i++) {
            if (animales[i].getEspecie().equalsIgnoreCase(especie)) {
                resultado[posicion] = animales[i];
                posicion++;
            }
        }
        return resultado;
    }
    public void moverAnimalesA(Zoologico destino) {
        for (int i = 0; i < noAnimales; i++) {
            destino.agregarAnimal(animales[i]);
        }
        for (int i = 0; i < noAnimales; i++) {
            animales[i] = null;
        }
        noAnimales = 0;
    }
    public boolean moverAnimalA(int indice, Zoologico destino) {
        if (indice >= 0 && indice < noAnimales) {
            if (destino.agregarAnimal(animales[indice])) {
                eliminarAnimal(indice);
                return true;
            }
        }
        return false;
    }
    public boolean estaLleno() {
        return noAnimales >= MAX_ANIMALES;
    }
    public void mostrarAnimales() {
        if (estaVacio()) {
            System.out.println("  Este zoológico está vacío.");
            return;
        }
        System.out.println("  Animales en " + nombre + " (" + noAnimales + " tipos):");
        for (int i = 0; i < noAnimales; i++) {
            System.out.print("  " + (i + 1) + ". ");
            animales[i].mostrar();
        }
    }
    public void mostrar() {
        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Animales: " + noAnimales + ", Variedad de especies: " + getVariedadEspecies());
    }
    public Animal buscarAnimalPorNombre(String nombreAnimal) {
        for (int i = 0; i < noAnimales; i++) {
            if (animales[i].getNombre().equalsIgnoreCase(nombreAnimal)) {
                return animales[i];
            }
        }
        return null;
    }
    public Animal[] getAnimales() {
        Animal[] copia = new Animal[noAnimales];
        for (int i = 0; i < noAnimales; i++) {
            copia[i] = animales[i];
        }
        return copia;
    }
    public Animal getAnimal(int indice) {
        if (indice >= 0 && indice < noAnimales) {
            return animales[indice];
        }
        return null;
    }
}