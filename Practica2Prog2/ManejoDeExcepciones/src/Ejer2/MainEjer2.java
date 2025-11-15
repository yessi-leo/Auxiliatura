/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;

/**
 *
 * @author yessi
 */
public class MainEjer2 {
    public static void main(String[] args) {
        System.out.println("-------- CALCULADORA - PRUEBAS NORMALES ---------\n");
        System.out.println("Suma: 10 + 5 = " + Calculadora.sumar(10, 5));
        System.out.println("Resta: 10 - 5 = " + Calculadora.restar(10, 5));
        System.out.println("Multiplicacion: 10 * 5 = " + Calculadora.multiplicar(10, 5));
        try {
            System.out.println("Division: 10 / 5 = " + Calculadora.dividir(10, 5));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        try {
            int numero = Calculadora.convertirStringAInt("123");
            System.out.println("Conversion: '123' -> " + numero);
        } catch (NumeroInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n---------- PRUEBAS CON ERRORES ---------\n");
        System.out.println("1. Probando division por cero:");
        try {
            double resultado = Calculadora.dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n2. Probando conversion de String invalido:");
        try {
            int numero = Calculadora.convertirStringAInt("abc");
            System.out.println("Numero convertido: " + numero);
        } catch (NumeroInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n3. Probando conversion de String con decimales:");
        try {
            int numero = Calculadora.convertirStringAInt("12.5");
            System.out.println("Numero convertido: " + numero);
        } catch (NumeroInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n4. Probando conversion de String vacio:");
        try {
            int numero = Calculadora.convertirStringAInt("");
            System.out.println("Numero convertido: " + numero);
        } catch (NumeroInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n5. Mas pruebas de conversion exitosa:");
        String[] textosValidos = {"0", "-50", "999", " 42 "};
        for (int i = 0; i < textosValidos.length; i++) {
            try {
                int numero = Calculadora.convertirStringAInt(textosValidos[i]);
                System.out.println("'" + textosValidos[i] + "' -> " + numero);
            } catch (NumeroInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\n6. Operaciones con numeros convertidos:");
        try {
            int num1 = Calculadora.convertirStringAInt("20");
            int num2 = Calculadora.convertirStringAInt("4");
            
            System.out.println("Suma: " + Calculadora.sumar(num1, num2));
            System.out.println("Resta: " + Calculadora.restar(num1, num2));
            System.out.println("Multiplicacion: " + Calculadora.multiplicar(num1, num2));
            System.out.println("Division: " + Calculadora.dividir(num1, num2));
        } catch (NumeroInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n------- FIN DE LAS PRUEBAS ---");
    }
}