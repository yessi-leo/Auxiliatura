/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer8;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yessi
 */
public class ArchRefri implements Serializable {
    private String nombre;
    private ArrayList<Alimento> alimentos;
    private final String ARCHIVO = "refrigerador.dat";
    
    public ArchRefri(String nombre) {
        this.nombre = nombre;
        this.alimentos = new ArrayList<>();
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    // a) 
    public void crearAlimento(Alimento alimento) {
        alimentos.add(alimento);
        System.out.println("Alimento '" + alimento.getNombre() + "' creado exitosamente.");
    }
    public boolean modificarPorNombre(String nombre, Alimento nuevoAlimento) {
        for (int i = 0; i < alimentos.size(); i++) {
            if (alimentos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                alimentos.set(i, nuevoAlimento);
                System.out.println("Alimento '" + nombre + "' modificado exitosamente.");
                return true;
            }
        }
        System.out.println("No se encontró el alimento '" + nombre + "'.");
        return false;
    }
    public boolean eliminarPorNombre(String nombre) {
        for (int i = 0; i < alimentos.size(); i++) {
            if (alimentos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                alimentos.remove(i);
                System.out.println("Alimento '" + nombre + "' eliminado exitosamente.");
                return true;
            }
        }
        System.out.println("No se encontró el alimento '" + nombre + "'.");
        return false;
    }
    
    // b) 
    public void mostrarCaducadosAntesDe(Date fechaLimite) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\n=== ALIMENTOS QUE CADUCAN ANTES DEL " + sdf.format(fechaLimite) + " ===");
        boolean encontrados = false;
        
        for (Alimento alimento : alimentos) {
            if (alimento.venceAntesDe(fechaLimite)) {
                alimento.mostrar();
                encontrados = true;
            }
        }
        
        if (!encontrados) {
            System.out.println("No hay alimentos que caduquen antes de esa fecha.");
        }
    }
    
    // c) 
    public int eliminarAlimentosCantidadCero() {
        int eliminados = 0;
        for (int i = alimentos.size() - 1; i >= 0; i--) {
            if (alimentos.get(i).getCantidad() == 0) {
                System.out.println("Eliminando: " + alimentos.get(i).getNombre() + " (cantidad 0)");
                alimentos.remove(i);
                eliminados++;
            }
        }
        System.out.println("Se eliminaron " + eliminados + " alimentos con cantidad 0.");
        return eliminados;
    }
    
    // d) 
    public ArrayList<Alimento> buscarAlimentosVencidos() {
        ArrayList<Alimento> vencidos = new ArrayList<>();
        for (Alimento alimento : alimentos) {
            if (alimento.estaVencido()) {
                vencidos.add(alimento);
            }
        }
        return vencidos;
    }
    
    // e) 
    public void mostrarAlimentoMasCantidad() {
        if (alimentos.isEmpty()) {
            System.out.println("El refrigerador esta vacio.");
            return;
        }
        
        Alimento maxAlimento = alimentos.get(0);
        for (Alimento alimento : alimentos) {
            if (alimento.getCantidad() > maxAlimento.getCantidad()) {
                maxAlimento = alimento;
            }
        }
        
        System.out.println("\n=== ALIMENTO CON MAS CANTIDAD ===");
        maxAlimento.mostrar();
    }
    
    public void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            ArchRefri temp = (ArchRefri) ois.readObject();
            this.nombre = temp.nombre;
            this.alimentos = temp.alimentos;
            System.out.println("Datos cargados exitosamente del refrigerador '" + nombre + "'.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo. Se creara uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }
    
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(this);
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public void mostrarTodos() {
        if (alimentos.isEmpty()) {
            System.out.println("El refrigerador esta vacio.");
            return;
        }
        
        System.out.println("\n=== CONTENIDO DEL REFRIGERADOR '" + nombre.toUpperCase() + "' ===");
        System.out.println("Total de alimentos: " + alimentos.size());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy = new Date();
        
        for (int i = 0; i < alimentos.size(); i++) {
            System.out.print((i + 1) + ". ");
            alimentos.get(i).mostrar();
            
            // Indicar si está vencido
            if (alimentos.get(i).estaVencido()) {
                System.out.println("ESTE ALIMENTO ESTA VENCIDO");
            } else if (alimentos.get(i).getCantidad() == 0) {
                System.out.println("CANTIDAD AGOTADA");
            }
        }
    }
    public Alimento buscarAlimento(String nombre) {
        for (Alimento alimento : alimentos) {
            if (alimento.getNombre().equalsIgnoreCase(nombre)) {
                return alimento;
            }
        }
        return null;
    }
}
