/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer15;

/**
 *
 * @author yessi
 */
public class Buzon {
    public int numero;
    public int moc; 
    public Carta[] cartas;
        
    public Buzon(int numero) {
        this.numero = numero;
        this.moc = 0;
        this.cartas = new Carta[50]; 
    }
        
    public void agregarCarta(Carta carta) {
        if (moc < 50) {
            cartas[moc] = carta;
            moc++;
        }
    }
        
    public void mostrarCartas() {
    System.out.println("Buzon " + numero + " (Cartas: " + moc + "):");
        for (int i = 0; i < moc; i++) {
            System.out.println("  Codigo: " + cartas[i].codigo + ", Remitente: " + cartas[i].remitente + ", Destinatario: " + cartas[i].destinatario);
        }
    }
        
    public boolean eliminarCartaPorCodigo(String codigo) {
        for (int i = 0; i < moc; i++) {
            if (cartas[i].codigo.equals(codigo)) {
                for (int j = i; j < moc - 1; j++) {
                    cartas[j] = cartas[j + 1];
                }
                cartas[moc - 1] = null;
                moc--;
                return true;
            }
        }
        return false;
    }
}