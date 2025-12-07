/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer9;

import java.io.*;

/**
 *
 * @author yessi
 */
public class ArchZoo implements Serializable {
    private String nombre;
    private Zoologico[] zoologicos;
    private int cantidadZoos;
    private final String ARCHIVO = "zoologicos.dat";
    private static final int MAX_ZOOS = 100;
    
    public ArchZoo(String nombre) {
        this.nombre = nombre;
        this.zoologicos = new Zoologico[MAX_ZOOS];
        this.cantidadZoos = 0;
    }
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void crearZoologico(Zoologico zoo) {
        if (cantidadZoos < MAX_ZOOS) {
            zoologicos[cantidadZoos] = zoo;
            cantidadZoos++;
            System.out.println("Zoologico '" + zoo.getNombre() + "' creado exitosamente.");
        } else {
            System.out.println("No se pueden crear");
        }
    }
    public boolean modificarZoologico(int id, Zoologico nuevoZoo) {
        for (int i = 0; i < cantidadZoos; i++) {
            if (zoologicos[i].getId() == id) {
                zoologicos[i] = nuevoZoo;
                System.out.println("Zoologico con ID " + id );
                return true;
            }
        }
        System.out.println("No se encontro" + id );
        return false;
    }
    public boolean eliminarZoologico(int id) {
        for (int i = 0; i < cantidadZoos; i++) {
            if (zoologicos[i].getId() == id) {
                for (int j = i; j < cantidadZoos - 1; j++) {
                    zoologicos[j] = zoologicos[j + 1];
                }
                zoologicos[cantidadZoos - 1] = null;
                cantidadZoos--;
                System.out.println("Zoologico con ID " + id + " eliminado");
                return true;
            }
        }
        System.out.println("No se encontro" + id);
        return false;
    }
    
    // b) 
    public void listarZoosMayorVariedad() {
        if (cantidadZoos == 0) {
            System.out.println("No hay zoologicos registrados.");
            return;
        }
        int maxVariedad = 0;
        for (int i = 0; i < cantidadZoos; i++) {
            int variedad = zoologicos[i].getVariedadEspecies();
            if (variedad > maxVariedad) {
                maxVariedad = variedad;
            }
        }
        System.out.println("\n ZOOLOGICOS CON MAYOR VARIEDAD (" + maxVariedad + " especies)");
        for (int i = 0; i < cantidadZoos; i++) {
            if (zoologicos[i].getVariedadEspecies() == maxVariedad) {
                zoologicos[i].mostrar();
            }
        }
    }
    
    // c)
    public void eliminarZoosVacios() {
        int vacios = 0;
        for (int i = 0; i < cantidadZoos; i++) {
            if (zoologicos[i].estaVacio()) {
                vacios++;
            }
        }
        if (vacios == 0) {
            System.out.println("No hay zoologicos vacios.");
            return;
        }
        
        System.out.println("\n ZOOLOGICOS VACIOS A ELIMINAR ");
        for (int i = 0; i < cantidadZoos; i++) {
            if (zoologicos[i].estaVacio()) {
                zoologicos[i].mostrar();
            }
        }
        int eliminados = 0;
        int i = 0;
        while (i < cantidadZoos) {
            if (zoologicos[i].estaVacio()) {
                for (int j = i; j < cantidadZoos - 1; j++) {
                    zoologicos[j] = zoologicos[j + 1];
                }
                zoologicos[cantidadZoos - 1] = null;
                cantidadZoos--;
                eliminados++;
            } else {
                i++;
            }
        }
        
        System.out.println("Se eliminaron " + eliminados + " zoológicos vacíos.");
    }
    
    // d)
    public void mostrarAnimalesPorEspecie(String especie) {
        System.out.println("\n ANIMALES DE LA ESPECIE: " + especie.toUpperCase());
        boolean encontrados = false;
        for (int i = 0; i < cantidadZoos; i++) {
            Animal[] animalesEspecie = zoologicos[i].getAnimalesPorEspecie(especie);
            if (animalesEspecie.length > 0) {
                System.out.println("\nEn zoologico: " + zoologicos[i].getNombre() + " (ID: " + zoologicos[i].getId() + ")");
                for (int j = 0; j < animalesEspecie.length; j++) {
                    animalesEspecie[j].mostrar();
                }
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron animales de la especie " + especie);
        }
    }
    
    // e) 
    public boolean moverAnimalesEntreZoos(int idOrigen, int idDestino) {
        Zoologico origen = buscarZoologicoPorId(idOrigen);
        Zoologico destino = buscarZoologicoPorId(idDestino);
        if (origen == null) {
            System.out.println("No se encontro el origen con ID " + idOrigen);
            return false;
        }
        if (destino == null) {
            System.out.println("No se encontro destino con ID " + idDestino);
            return false;
        }
        if (origen == destino) {
            System.out.println("No se pueden mover animales al mismo zoo");
            return false;
        }
        if (origen.estaVacio()) {
            System.out.println("El zoo origen esta vacio");
            return false;
        }
        int animalesAntes = destino.getNoAnimales();
        origen.moverAnimalesA(destino);
        int animalesMovidos = destino.getNoAnimales() - animalesAntes;
        System.out.println("Se movieron " + animalesMovidos + " tipos de animales de " +  origen.getNombre() + "  a  " + destino.getNombre());
        return true;
    }
    public Zoologico buscarZoologicoPorId(int id) {
        for (int i = 0; i < cantidadZoos; i++) {
            if (zoologicos[i].getId() == id) {
                return zoologicos[i];
            }
        }
        return null;
    }
    public void mostrarTodos() {
        if (cantidadZoos == 0) {
            System.out.println("No hay zoológicos registrados.");
            return;
        }
        
        System.out.println("\n=== LISTADO DE ZOOLÓGICOS ===");
        System.out.println("Total: " + cantidadZoos + " zoológicos");
        
        for (int i = 0; i < cantidadZoos; i++) {
            System.out.print((i + 1) + ". ");
            zoologicos[i].mostrar();
        }
    }
    public void cargarDatos() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO));
            ArchZoo temp = (ArchZoo) ois.readObject();
            ois.close();
            
            this.nombre = temp.nombre;
            this.zoologicos = temp.zoologicos;
            this.cantidadZoos = temp.cantidadZoos;
            System.out.println("Datos cargados exitosamente del archivo '" + nombre + "'.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo. Se creara uno nuevo.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void guardarDatos() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
            oos.writeObject(this);
            oos.close();
            System.out.println("Datos guardados exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean agregarAnimalAZoo(int idZoo, Animal animal) {
        Zoologico zoo = buscarZoologicoPorId(idZoo);
        if (zoo != null) {
            return zoo.agregarAnimal(animal);
        }
        return false;
    }
    
    public int getCantidadZoos() {
        return cantidadZoos;
    }
    
    public Zoologico getZoologico(int indice) {
        if (indice >= 0 && indice < cantidadZoos) {
            return zoologicos[indice];
        }
        return null;
    }
}