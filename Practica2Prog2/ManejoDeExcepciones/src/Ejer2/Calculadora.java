/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;

/**
 *
 * @author yessi
 */
public class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }
    public static int restar(int a, int b) {
        return a - b;
    }
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("ERROR: No se puede dividir por cero");
        }
        return (double) a / b;
    }
    public static int convertirStringAInt(String texto) throws NumeroInvalidoException {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new NumeroInvalidoException("ERROR: '" + texto + "' no es un numero valido");
        }
    }
}