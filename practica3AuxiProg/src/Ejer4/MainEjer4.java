/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;
import java.util.ArrayList;

/**
 *
 * @author yessi
 */
public class MainEjer4 {
    public static void main(String[] args) {
        ArchiNota arch = new ArchiNota("noti.txt");
        arch.crearArchivo();
        Estudiante e1 = new Estudiante("123456", "Yessi", "Leon", "Limachi", 22);
        Estudiante e2 = new Estudiante("123457", "Belinda", "Guitierres", "Leon", 21);
        Estudiante e3 = new Estudiante("123458", "Anderson", "Linares", "Mendoza", 22);
        Estudiante e4 = new Estudiante("123459", "Ana", "Limachi", "Silva", 19);
        Nota n1 = new Nota("Programacion", 85.5, e1);
        Nota n2 = new Nota("Calculo", 90.0, e2);
        Nota n3 = new Nota("Estadistica", 92.5, e3);
        Nota n4 = new Nota("Calculo", 88.0, e4);
        Nota n5 = new Nota("Programacion", 90.0, e4);
        Nota n6 = new Nota("Estadistica", 90.0, e2);
        // b) 
        ArrayList<Nota> notas = new ArrayList<>();
        notas.add(n1);
        notas.add(n2);
        notas.add(n3);
        notas.add(n4);
        notas.add(n5);
        notas.add(n6);
        System.out.println("\n b) AGREGAR VARIOS ESTUDIANTES ");
        arch.agregarVariosEstudiantes(notas);
        arch.mostrarTodasNotas();
        // c)
        System.out.println("\n c) PROMEDIO DE NOTAS ");
        arch.obtenerPromedioNotas();        
        // d) 
        System.out.println("\n d) MEJORES NOTAS ");
        ArrayList<Nota> mejores = arch.buscarMejorNota();
        for (Nota nota : mejores) {
            System.out.println(nota);
        }
        // e) 
        System.out.println("\n e) ELIMINAR ESTUDIANTES DE PROGRAMACION ");
        arch.eliminarEstudiantesPorMateria("Programacion");
        arch.mostrarTodasNotas();
    }
}