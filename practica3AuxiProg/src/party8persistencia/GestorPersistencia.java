/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package party8persistencia;

/**
 *
 * @author yessi
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {
    private static final String ARCHIVO_JSON = "biblioteca.json";
    private static final String ARCHIVO_BINARIO = "biblioteca.dat";
    private final Gson gson;
    
    public GestorPersistencia() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    public void guardarJSON(List<Libro> libros) {
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON)) {
            gson.toJson(libros, writer);
            System.out.println("✓ Libros guardados en JSON correctamente.");
        } catch (IOException e) {
            System.err.println("✗ Error al guardar en JSON: " + e.getMessage());
        }
    }
    
    public List<Libro> cargarJSON() {
        List<Libro> libros = new ArrayList<>();
        File archivo = new File(ARCHIVO_JSON);
        
        if (!archivo.exists()) {
            System.out.println("ℹ Archivo JSON no encontrado, se creará uno nuevo.");
            return libros;
        }
        
        try (Reader reader = new FileReader(ARCHIVO_JSON)) {
            Type tipoListaLibros = new TypeToken<ArrayList<Libro>>(){}.getType();
            List<Libro> librosCargados = gson.fromJson(reader, tipoListaLibros);
            
            if (librosCargados != null) {
                libros = librosCargados;
                System.out.println("✓ " + libros.size() + " libros cargados desde JSON.");
            }
        } catch (IOException e) {
            System.err.println("✗ Error al cargar desde JSON: " + e.getMessage());
        }
        
        return libros;
    }
    
    public void guardarBinario(List<Libro> libros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_BINARIO))) {
            oos.writeObject(libros);
            System.out.println("✓ Libros guardados en binario correctamente.");
        } catch (IOException e) {
            System.err.println("✗ Error al guardar en binario: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Libro> cargarBinario() {
        List<Libro> libros = new ArrayList<>();
        File archivo = new File(ARCHIVO_BINARIO);
        
        if (!archivo.exists()) {
            System.out.println("ℹ Archivo binario no encontrado.");
            return libros;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO_BINARIO))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                libros = (List<Libro>) obj;
                System.out.println("✓ " + libros.size() + " libros cargados desde binario.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✗ Error al cargar desde binario: " + e.getMessage());
        }
        
        return libros;
    }
}