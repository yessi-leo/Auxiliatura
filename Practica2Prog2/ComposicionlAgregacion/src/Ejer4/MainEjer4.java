/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

/**
 *
 * @author yessi
 */
public class MainEjer4 {
    public static void main(String[] args) {
        Ropero ropero = new Ropero("Madera");        
        Ropa[] prendas = {
            new Ropa("Camisa", "Algodon"),
            new Ropa("Pantalon", "Mezclilla"),
            new Ropa("Camisa", "Seda"),
            new Ropa("Vestido", "Algodon"),
            new Ropa("Chamarra", "Cuero"),
            new Ropa("Pantalon", "Algodon"),
            new Ropa("Blusa", "Seda")
        };
        
        System.out.println("b) ADICIONAR PRENDAS AL ROPERO ");
        ropero.adicionarPrendas(5, prendas);
        ropero.mostrarTodasLasPrendas();
        System.out.println("Agregar una prenda individual:");
        Ropa nuevaPrenda = new Ropa("Falda", "Lino");
        ropero.adicionarPrenda(nuevaPrenda);
        ropero.mostrarTodasLasPrendas();
        System.out.println("d) MOSTRAR PRENDAS POR MATERIAL Y TIPO");
        ropero.mostrarPrendas("Algodon", "Camisa");
        ropero.mostrarPrendas("Seda", "Blusa");
        System.out.println("c) ELIMINAR PRENDAS POR MATERIAL O TIPO ");
        System.out.println("ANTES de eliminar:");
        ropero.mostrarTodasLasPrendas();
        ropero.eliminarPrendas("Algodon", "Pantalon");
        System.out.println("Despues de eliminar:");
        ropero.mostrarTodasLasPrendas();
        System.out.println("Agregar mas prendas despues de eliminar:");
        Ropa[] masPrendas = {
            new Ropa("Sueter", "Lana"),
            new Ropa("Shorts", "Algodon")
        };
        ropero.adicionarPrendas(2, masPrendas);
        ropero.mostrarTodasLasPrendas();
    }
}