/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer10;

/**
 *
 * @author yessi
 */
public class Charla {
    private String lugar;
    private String nombreCharla;
    private Speaker speaker;
    private int np;
    private Participante[] participantes;
    public Charla(String lugar, String nombreCharla, Speaker speaker) {
        this.lugar = lugar;
        this.nombreCharla = nombreCharla;
        this.speaker = speaker;
        this.np = 0;
        this.participantes = new Participante[50];
    }
    public void agregarParticipante(Participante p) {
        if (np < 50) {
            participantes[np] = p;
            np++;
        }
    }
    public boolean tienePersona(String nombre, String apellido) {
        if (speaker != null && speaker.getNombre().equals(nombre) && speaker.getApellido().equals(apellido)) {
            return true;
        }
        for (int i = 0; i < np; i++) {
            if (participantes[i].getNombre().equals(nombre) && participantes[i].getApellido().equals(apellido)) {
                return true;
            }
        }
        return false;
    }
    public boolean tieneSpeakerCI(int ci) {
        return speaker != null && speaker.getCi() == ci;
    }
    public String getLugar() {
        return lugar;
    }
    public String getNombreCharla() {
        return nombreCharla;
    }
    public Speaker getSpeaker() {
        return speaker;
    }
    public int getNp() {
        return np;
    }
    public Participante[] getParticipantes() {
        return participantes;
    }   
}