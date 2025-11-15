/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer10;

/**
 *
 * @author yessi
 */
public class Evento {
    private String nombre;
    private int nc;
    private Charla[] charlas;
    public Evento(String nombre) {
        this.nombre = nombre;
        this.nc = 0;
        this.charlas = new Charla[50];
    }
    public void agregarCharla(Charla charla) {
        if (nc < 50) {
            charlas[nc] = charla;
            nc++;
        }
    }
    public double edadPromedioParticipantes() {
        if (nc == 0) return 0; 
        int totalEdades = 0;
        int totalPersonas = 0;
        for (int i = 0; i < nc; i++) {
            Charla charla = charlas[i];
            for (int j = 0; j < charla.getNp(); j++) {
                totalEdades += charla.getParticipantes()[j].getEdad();
                totalPersonas++;
            }
        }
        if (totalPersonas == 0) return 0;
        return (double) totalEdades / totalPersonas;
    }
    public boolean buscarPersona(String nombre, String apellido) {
        for (int i = 0; i < nc; i++) {
            if (charlas[i].tienePersona(nombre, apellido)) {
                return true;
            }
        }
        return false;
    }
    public void eliminarCharlasSpeaker(int ci) {
        int i = 0;
        while (i < nc) {
            if (charlas[i].tieneSpeakerCI(ci)) {
                for (int j = i; j < nc - 1; j++) {
                    charlas[j] = charlas[j + 1];
                }
                charlas[nc - 1] = null;
                nc--;
            } else {
                i++;
            }
        }
    }
    public void ordenarCharlasPorParticipantes() {
        for (int i = 0; i < nc - 1; i++) {
            for (int j = 0; j < nc - i - 1; j++) {
                if (charlas[j].getNp() < charlas[j + 1].getNp()) {
                    Charla temp = charlas[j];
                    charlas[j] = charlas[j + 1];
                    charlas[j + 1] = temp;
                }
            }
        }
    }  
    public void mostrarCharlas() {
        System.out.println("Charlas en el evento '" + nombre + "':");
        for (int i = 0; i < nc; i++) {
            System.out.println((i+1) + ". " + charlas[i].getNombreCharla() + " - Speaker: " + charlas[i].getSpeaker().getNombre() +" - Participantes: " + charlas[i].getNp());
        }
    }
    public String getNombre() {
        return nombre;
    }
    public int getNc() {
        return nc;
    }
    public Charla[] getCharlas() {
        return charlas;
    }  
}