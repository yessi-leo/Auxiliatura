/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer211;

/**
 *
 * @author yessi
 */
public class Crucero {
    private String nombre;
    private String paisOrigen;
    private String paisDestino;
    private int moPasajeros;
    private Pasajero[][] pasajeros;
    
    public Crucero(String nombre, String paisOrigen, String paisDestino) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.moPasajeros = 0;
        this.pasajeros = new Pasajero[3][100]; 
    }
    public void agregarPasajero(int categoria, Pasajero pasajero) {
        if (categoria >= 0 && categoria < 3 && moPasajeros < 100) {
            for (int i = 0; i < 100; i++) {
                if (pasajeros[categoria][i] == null) {
                    pasajeros[categoria][i] = pasajero;
                    moPasajeros++;
                    break;
                }
            }
        }
    }
    public void incrementar() {
        System.out.println("Leyendo datos del crucero: " + this.nombre);
    }
    public void decrementar() {
        System.out.println("---- CRUCERO " + this.nombre + " ----");
        System.out.println("Origen: " + this.paisOrigen);
        System.out.println("Destino: " + this.paisDestino);
        System.out.println("Total pasajeros: " + this.moPasajeros);
        int contador = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 100; j++) {
                if (pasajeros[i][j] != null) {
                System.out.println(contador + ". " + pasajeros[i][j].getNombre() + " - Hab: " + pasajeros[i][j].getNroHabitacion() + " - Costo: Bs" + pasajeros[i][j].getCostoPasaje());
                contador++;
                }
            }
        }
    }
    public void igualIgual() {
        double sumaTotal = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 100; j++) {
                if (pasajeros[i][j] != null) {
                    sumaTotal += pasajeros[i][j].getCostoPasaje();
                }
            }
        }
        System.out.println("Suma total de pasajes del crucero " + this.nombre + ": Bs" + sumaTotal);
    }
    public void mas(Crucero otroCrucero) {
        if (this.moPasajeros == otroCrucero.moPasajeros) {
            System.out.println("Ambos cruceros tienen la misma cantidad de pasajeros: " + this.moPasajeros);
        } else {
            System.out.println("Los cruceros tienen diferente cantidad de pasajeros:");
            System.out.println("  " + this.nombre + ": " + this.moPasajeros + " pasajeros");
            System.out.println("  " + otroCrucero.nombre + ": " + otroCrucero.moPasajeros + " pasajeros");
        }
    }
    public void menos() {
        int hombres = 0;
        int mujeres = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 100; j++) {
                if (pasajeros[i][j] != null) {
                    if (pasajeros[i][j].getGenero().equals("M") || 
                        pasajeros[i][j].getGenero().equals("Masculino")) {
                        hombres++;
                    } else if (pasajeros[i][j].getGenero().equals("F") || 
                               pasajeros[i][j].getGenero().equals("Femenino")) {
                        mujeres++;
                    }
                }
            }
        }
        System.out.println("---- DISTRIBUCION POR GENERO - " + this.nombre + " -----");
        System.out.println("Hombres: " + hombres);
        System.out.println("Mujeres: " + mujeres);
        System.out.println("Total: " + (hombres + mujeres));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getMoPasajeros() {
        return moPasajeros;
    }

    public void setMoPasajeros(int moPasajeros) {
        this.moPasajeros = moPasajeros;
    }

    public Pasajero[][] getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero[][] pasajeros) {
        this.pasajeros = pasajeros;
    }
    
}
