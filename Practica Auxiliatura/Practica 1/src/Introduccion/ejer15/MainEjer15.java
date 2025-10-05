/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer15;

/**
 *
 * @author yessi
 */
public class MainEjer15 {
     public static void main(String[] args) {
        Carta c1 = new Carta("C123", "Juan Alvarez", "Paola Chaves", "Querido amigo te escribo para decirte ...");
        Carta c2 = new Carta("C456", "Pepe Mujica", "Wilmer Perez", "Querido amigo te escribo para...");
        Carta c3 = new Carta("C789", "Paty Vasques", "Pepe Mujica", "Hola Pepito, espero que estes bien. Te extraño mucho.");
        Carta c4 = new Carta("C101", "Ana Garcia", "Paola Chaves", "Hola Ani, tenemos que hablar sobre el proyecto de informatica.");
        Carta c5 = new Carta("C102", "Carlos Lopez", "Maria Rodriguez", "Querida Maria, nuestro tarea es para mañana.");
        Carta c6 = new Carta("C103", "Wilmer Perez", "Juan Alvarez", "Hola Juan, necesitamos reunirnos pronto.");
        Carta c7 = new Carta("C104", "Maria Rodriguez", "Carlos Lopez", "Carlos, recibi tu carta del proyecto de informatica.");
        Carta c8 = new Carta("C105", "Paola Chaves", "Ana Garcia", "Ana, el amor que siento por ti es inmenso.");
        Carta c9 = new Carta("C106", "Wilmer Perez", "Paty Vasques", "Hola Paty, todo bien por aqui.");
        Buzon b1 = new Buzon(1);
        b1.agregarCarta(c1);
        b1.agregarCarta(c2);
        b1.agregarCarta(c3);
        Buzon b2 = new Buzon(2);
        b2.agregarCarta(c4);
        b2.agregarCarta(c5);
        b2.agregarCarta(c6);
        b2.agregarCarta(c7);
        Buzon b3 = new Buzon(3);
        b3.agregarCarta(c8);
        b3.agregarCarta(c9);
        b3.agregarCarta(c1);
        b3.agregarCarta(c4);
        System.out.println("---- BUZONES INSTANCIADOS ----");
        b1.mostrarCartas();
        b2.mostrarCartas();
        b3.mostrarCartas();
        String destinatario = "Paola Chaves";
        System.out.println("\n---- CARTAS RECIBIDAS POR " + destinatario + " ----");
        int totalCartas = contarCartasPorDestinatario(destinatario, b1, b2, b3);
        System.out.println(destinatario + " recibio " + totalCartas + " cartas");
        String codigoEliminar = "C456";
        System.out.println("\n---- ELIMINAR CARTA CODIGO: " + codigoEliminar + " ----");
        boolean eliminada = false;
        if (b1.eliminarCartaPorCodigo(codigoEliminar)) {
            System.out.println("Carta " + codigoEliminar + " eliminada del Buzon 1");
            eliminada = true;
        }
        if (b2.eliminarCartaPorCodigo(codigoEliminar)) {
            System.out.println("Carta " + codigoEliminar + " eliminada del Buzon 2");
            eliminada = true;
        }
        if (b3.eliminarCartaPorCodigo(codigoEliminar)) {
            System.out.println("Carta " + codigoEliminar + " eliminada del Buzon 3");
            eliminada = true;
        }
        if (!eliminada) {
            System.out.println("Carta " + codigoEliminar + " no encontrada en ningun buzon");
        }
        System.out.println("\n---- BUZONES DESPUES DE ELIMINAR -----");
        b1.mostrarCartas();
        b2.mostrarCartas();
        b3.mostrarCartas();
        System.out.println("\n---- VERIFICAR REMITENTES QUE RECIBIERON CARTAS ----");
        verificarRemitentesQueRecibieron(b1, b2, b3);
        String palabraClave = "informatica";
        System.out.println("\n---- BUSCAR PALABRA CLAVE: " + palabraClave + " ----");
        buscarPalabraEnDescripciones(palabraClave, b1, b2, b3);
    }
    public static int contarCartasPorDestinatario(String destinatario, Buzon... buzones) {
        int contador = 0;    
        for (int i = 0; i < buzones.length; i++) {
            Buzon buzon = buzones[i];
            for (int j = 0; j < buzon.moc; j++) {
                if (buzon.cartas[j].destinatario.equals(destinatario)) {
                    contador++;
                    System.out.println("Encontrada en Buzon " + buzon.numero + ": Codigo " + buzon.cartas[j].codigo + " de " + buzon.cartas[j].remitente);
                }
            }
        }
        return contador;
    }
    public static void verificarRemitentesQueRecibieron(Buzon... buzones) {
        String[] todosRemitentes = new String[150]; 
        int totalRemitentes = 0;
        for (int i = 0; i < buzones.length; i++) {
            Buzon buzon = buzones[i];
            for (int j = 0; j < buzon.moc; j++) {
                todosRemitentes[totalRemitentes] = buzon.cartas[j].remitente;
                totalRemitentes++;
            }
        }
        boolean encontrado = false;
        boolean continuarBusqueda = true;
        for (int i = 0; i < totalRemitentes && continuarBusqueda; i++) {
            String remitente = todosRemitentes[i];
            for (int j = 0; j < buzones.length && continuarBusqueda; j++) {
                Buzon buzon = buzones[j];
                for (int k = 0; k < buzon.moc && continuarBusqueda; k++) {
                    if (buzon.cartas[k].destinatario.equals(remitente)) {
                        System.out.println(remitente + " (remitente) recibio carta de: " + buzon.cartas[k].remitente);
                        encontrado = true;
                        continuarBusqueda = false; 
                    }
                }
            }
            continuarBusqueda = true;
        }
        if (!encontrado) {
            System.out.println("Ningun remitente ha recibido cartas");
        }
    }
    public static void buscarPalabraEnDescripciones(String palabra, Buzon... buzones) {
        boolean encontrada = false;
        for (int i = 0; i < buzones.length; i++) {
            Buzon buzon = buzones[i];
            for (int j = 0; j < buzon.moc; j++) {
                Carta carta = buzon.cartas[j];
                if (carta.descripcion.toLowerCase().contains(palabra.toLowerCase())) {
                    System.out.println("Coincidencia encontrada:");
                    System.out.println("  Codigo: " + carta.codigo);
                    System.out.println("  Remitente: " + carta.remitente);
                    System.out.println("  Destinatario: " + carta.destinatario);
                    System.out.println("  Descripcion: " + carta.descripcion.substring(0, Math.min(50, carta.descripcion.length())) + "...");
                    System.out.println();
                    encontrada = true;
                }
            }
        }
        
        if (!encontrada) {
            System.out.println("No se encontro la palabra '" + palabra + "' en ninguna descripcion");
        }
    }
}
