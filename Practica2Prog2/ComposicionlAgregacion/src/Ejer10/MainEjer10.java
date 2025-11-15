/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer10;

/**
 *
 * @author yessi
 */
public class MainEjer10 {
    public static void main(String[] args) {
        Evento evento = new Evento("Conferencia de Tecnologia");
        Speaker speaker1 = new Speaker("Juan", "Perez", 35, 123456, "Inteligencia Artificial");
        Speaker speaker2 = new Speaker("Maria", "Garcia", 28, 789012, "Desarrollo Web");
        Speaker speaker3 = new Speaker("Carlos", "Lopez", 40, 345678, "Ciberseguridad");
        Charla charla1 = new Charla("Auditorio A", "Introduccion a IA", speaker1);
        Charla charla2 = new Charla("Auditorio B", "React Avanzado", speaker2);
        Charla charla3 = new Charla("Auditorio C", "Seguridad en la Nube", speaker3);
        Charla charla4 = new Charla("Auditorio A", "Machine Learning", speaker1);
        Participante p1 = new Participante("Yessica", "Leon", 25, 111111, 1001);
        Participante p2 = new Participante("Luis", "Rodriguez", 30, 222222, 1002);
        Participante p3 = new Participante("Pedro", "Sanchez", 22, 333333, 1003);
        Participante p4 = new Participante("Laura", "Gomez", 27, 444444, 1004);
        Participante p5 = new Participante("Miguel", "Diaz", 35, 555555, 1005);
        charla1.agregarParticipante(p1);
        charla1.agregarParticipante(p2);
        charla2.agregarParticipante(p3);
        charla3.agregarParticipante(p4);
        charla4.agregarParticipante(p5);
        charla4.agregarParticipante(p1); 
        evento.agregarCharla(charla1);
        evento.agregarCharla(charla2);
        evento.agregarCharla(charla3);
        evento.agregarCharla(charla4);
        System.out.println("--------- ESTADO INICIAL -----------");
        evento.mostrarCharlas();
        System.out.println("\n a) EDAD PROMEDIO ");
        double promedio = evento.edadPromedioParticipantes();
        System.out.println("Edad promedio de participantes: " + promedio + " anios");
        System.out.println("\n b) BUSCAR PERSONA ");
        boolean encontrado = evento.buscarPersona("Yessica", "Leon");
        System.out.println("Yessica Leon esta en alguna charla? " + (encontrado ? "SI" : "NO"));
        encontrado = evento.buscarPersona("Juan", "Perez");
        System.out.println("Juan Perez esta en alguna charla? " + (encontrado ? "SI" : "NO"));
        System.out.println("\n c) ELIMINAR CHARLAS DE SPEAKER ");
        evento.eliminarCharlasSpeaker(123456);
        System.out.println("Charlas despues de eliminar las de Juan Perez (CI: 123456):");
        evento.mostrarCharlas();
        System.out.println("\n d) ORDENAR CHARLAS POR PARTICIPANTES ");
        evento.ordenarCharlasPorParticipantes();
        System.out.println("Charlas ordenadas por numero de participantes (descendente):");
        evento.mostrarCharlas();
    }
}