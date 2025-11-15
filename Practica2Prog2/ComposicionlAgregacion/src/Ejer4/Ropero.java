/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

/**
 *
 * @author yessi
 */
public class Ropero {
    private String material;
    private Ropa[] ropas;
    private int nroRopas;
    public Ropero(String material) {
        this.material = material;
        this.ropas = new Ropa[20];
        this.nroRopas = 0;
    }
    public void adicionarPrendas(int n, Ropa[] nuevasRopas) {
        if (n <= 0) {
            System.out.println("El numero de prendas a agregar debe ser mayor a 0");
            return;
        }
        int espacioDisponible = 20 - nroRopas;
        if (n > espacioDisponible) {
            System.out.println("No hay espacio suficiente. Solo se pueden agregar " + espacioDisponible + " prendas");
            n = espacioDisponible;
        }
        int prendasAgregadas = 0;
        for (int i = 0; i < n && nroRopas < 20; i++) {
            if (i < nuevasRopas.length && nuevasRopas[i] != null) {
                ropas[nroRopas] = nuevasRopas[i];
                nroRopas++;
                prendasAgregadas++;
            }
        }
        System.out.println("Se agregaron " + prendasAgregadas + " prendas al ropero");
    }
    
    public void adicionarPrenda(Ropa prenda) {
        if (nroRopas >= 20) {
            System.out.println("El ropero esta lleno, no se puede agregar mas prendas");
            return;
        }
        ropas[nroRopas] = prenda;
        nroRopas++;
        System.out.println("Prenda agregada: " + prenda);
    }
    
    public void eliminarPrendas(String materialX, String tipoY) {
        int eliminadas = 0;
        int i = 0;
        while (i < nroRopas) {
            Ropa prenda = ropas[i];
            if (prenda.getMaterial().equals(materialX) || prenda.getTipo().equals(tipoY)) {
                for (int j = i; j < nroRopas - 1; j++) {
                    ropas[j] = ropas[j + 1];
                }
                ropas[nroRopas - 1] = null;
                nroRopas--;
                eliminadas++;
            } else {
                i++;
            }
        }
        System.out.println("Se eliminaron " + eliminadas + " prendas con material '" + materialX + "' o tipo '" + tipoY + "'");
    }
    public void mostrarPrendas(String materialX, String tipoY) {
        System.out.println("Prendas con material '" + materialX + "' y tipo '" + tipoY + "':");
        boolean encontradas = false;
        for (int i = 0; i < nroRopas; i++) {
            Ropa prenda = ropas[i];
            if (prenda.getMaterial().equals(materialX) && prenda.getTipo().equals(tipoY)) {
                System.out.println("  - " + prenda);
                encontradas = true;
            }
        }
        if (encontradas == false) {
            System.out.println("  No se encontraron prendas con esas caracteristicas");
        }
        System.out.println();
    }
    public void mostrarTodasLasPrendas() {
        System.out.println("Todas las prendas en el ropero (" + nroRopas + "/20):");
        if (nroRopas == 0) {
            System.out.println("  El ropero esta vacio");
        } else {
            for (int i = 0; i < nroRopas; i++) {
                System.out.println("  " + (i + 1) + ". " + ropas[i]);
            }
        }
        System.out.println();
    }
    public String getMaterial() {
        return material;
    }
    public int getNroRopas() {
        return nroRopas;
    }
}