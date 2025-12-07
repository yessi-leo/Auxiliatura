/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author yessi
 */
public class ArchiNota {
    private String nombreArchi;
    
    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
    }
    // a)
    public void crearArchivo() {
        try {
            File archivo = new File(nombreArchi);
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
    public void agregarVariosEstudiantes(ArrayList<Nota> notas) {
        if (notas.isEmpty()) {
            System.out.println("No hay notas para agregar.");
            return;
        }
        int agregados = 0;
        try (FileWriter fw = new FileWriter(nombreArchi, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Nota nota : notas) {
                Estudiante estudiante = nota.getEstudiante();
                out.println(estudiante.getRu() + "," + estudiante.getNombre() + "," + 
                           estudiante.getPaterno() + "," + estudiante.getMaterno() + "," + 
                           estudiante.getEdad() + "," + nota.getMateria() + "," + nota.getNotaFinal());
                agregados++;
            }
            System.out.println("Se agregaron " + agregados + " registros de estudiantes.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // c) 
    public double obtenerPromedioNotas() {
        ArrayList<Nota> notas = leerTodasNotas();
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return 0.0;
        }
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaFinal();
        }
        double promedio = suma / notas.size();
        System.out.println("Promedio general de " + notas.size() + " notas: " +String.format("%.2f", promedio));
        return promedio;
    }
    // d) 
    public ArrayList<Nota> buscarMejorNota() {
        ArrayList<Nota> todasNotas = leerTodasNotas();
        ArrayList<Nota> mejoresNotas = new ArrayList<>();
        if (todasNotas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return mejoresNotas;
        }
        double mejorNota = 0;
        for (Nota nota : todasNotas) {
            if (nota.getNotaFinal() > mejorNota) {
                mejorNota = nota.getNotaFinal();
            }
        }
        for (Nota nota : todasNotas) {
            if (nota.getNotaFinal() == mejorNota) {
                mejoresNotas.add(nota);
            }
        }
        System.out.println("Mejor nota: " + mejorNota);
        System.out.println("Estudiantes con la mejor nota: " + mejoresNotas.size());
        return mejoresNotas;
    }
    // e) 
    public void eliminarEstudiantesPorMateria(String materia) {
        ArrayList<Nota> todasNotas = leerTodasNotas();
        ArrayList<Nota> notasFiltradas = new ArrayList<>();
        int eliminados = 0;
        for (Nota nota : todasNotas) {
            if (!nota.getMateria().equalsIgnoreCase(materia)) {
                notasFiltradas.add(nota);
            } else {
                eliminados++;
            }
        }
        if (eliminados > 0) {
            try (PrintWriter out = new PrintWriter(new FileWriter(nombreArchi))) {
                for (Nota nota : notasFiltradas) {
                    Estudiante estudiante = nota.getEstudiante();
                    out.println(estudiante.getRu() + "," + estudiante.getNombre() + "," + estudiante.getPaterno() + "," + estudiante.getMaterno() + "," + estudiante.getEdad() + "," + nota.getMateria() + "," + nota.getNotaFinal());
                }
                System.out.println("Se eliminaron " + eliminados + " registros de la materia: " + materia);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No se encontraron registros de la materia: " + materia);
        }
    }
    public ArrayList<Nota> leerTodasNotas() {
        ArrayList<Nota> notas = new ArrayList<>();
        File archivo = new File(nombreArchi);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return notas;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchi))) {
            String linea;
            int lineasLeidas = 0;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    try {
                        String ru = datos[0];
                        String nombre = datos[1];
                        String paterno = datos[2];
                        String materno = datos[3];
                        int edad = Integer.parseInt(datos[4]);
                        Estudiante estudiante = new Estudiante(ru, nombre, paterno, materno, edad);
                        String materia = datos[5];
                        double notaFinal = Double.parseDouble(datos[6]);
                        Nota nota = new Nota(materia, notaFinal, estudiante);
                        notas.add(nota);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Linea " + lineasLeidas + " ignorada - formato incorrecto");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return notas;
    }
    public void mostrarTodasNotas() {
        ArrayList<Nota> notas = leerTodasNotas();
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }
        System.out.println("\n LISTA DE NOTAS (" + notas.size() + ")");
        for (Nota nota : notas) {
            System.out.println(nota);
        }
    }
}