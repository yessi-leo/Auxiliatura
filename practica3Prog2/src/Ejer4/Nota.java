/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

/**
 *
 * @author yessi
 */
public class Nota {
    private String materia;
    private double notaFinal;
    private Estudiante estudiante;
    
    public Nota(String materia, double notaFinal, Estudiante estudiante) {
        this.materia = materia;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }
    
    public String getMateria() {
        return materia;
    }
    
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    public double getNotaFinal() {
        return notaFinal;
    }
    
    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    @Override
    public String toString() {
        return estudiante.getRu() + " - " + estudiante.getNombre() + " " + estudiante.getPaterno() + ": " + materia + " = " + notaFinal;
    }
}