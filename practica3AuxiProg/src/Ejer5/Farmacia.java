/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer5;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author yessi
 */
public class Farmacia {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion; 
    private int nroMedicamentos;
    private Medicamento[] m; 
    
    public Farmacia() {
        this.nombreFarmacia = "";
        this.sucursal = 0;
        this.direccion = "";
        this.m = new Medicamento[100];
        this.nroMedicamentos = 0;
    }
    
    public Farmacia(String nombreFarmacia, int sucursal, String direccion) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.m = new Medicamento[100];
        this.nroMedicamentos = 0;
    }
    public boolean agregarMedicamento(Medicamento medicamento) {
        if (nroMedicamentos < 100) {
            m[nroMedicamentos] = medicamento;
            nroMedicamentos++;
            return true;
        }
        return false;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNroMedicamentos() {
        return nroMedicamentos;
    }

    public void setNroMedicamentos(int nroMedicamentos) {
        this.nroMedicamentos = nroMedicamentos;
    }

    public Medicamento[] getM() {
        return m;
    }

    public void setM(Medicamento[] m) {
        this.m = m;
    }
    
    public Medicamento getMedicamento(int index) {
        if (index >= 0 && index < nroMedicamentos) {
            return m[index];
        }
        return null;
    }
    public void mostrar() {
        System.out.println("\n----------INFORMACION DE LA FARMACIA-----------");
        System.out.println("Nombre: " + nombreFarmacia);
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Direccion: " + direccion);
        System.out.println("Nro de Medicamentos: " + nroMedicamentos);
        if (nroMedicamentos == 0) {
            System.out.println("No hay medicamentos en esta farmacia");
        } else {
            System.out.println("\n LISTA DE MEDICAMENTOS ");
            for (int i = 0; i < nroMedicamentos; i++) {
                System.out.println("  " + (i+1) + ". " + m[i]);
            }
        }
    }
    public void leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------DATOS DE LA FARMACIA ---------");
        System.out.print("Nombre: ");
        this.nombreFarmacia = scanner.nextLine();
        System.out.print("Numero de sucursal: ");
        this.sucursal = scanner.nextInt();        
        System.out.print("Direccion: ");
        this.direccion = scanner.nextLine();
        System.out.print("Desea agregar medicamentos? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equals("s")) {
            System.out.print("Cuantos medicamentos desea agregar? ");
            int cantidad = scanner.nextInt();            
            if (cantidad > 100) {
                System.out.println("Error: No puede agregar mas de 100 medicamentos.");
                cantidad = 100;
            }
            for (int i = 0; i < cantidad; i++) {
                System.out.println("\n--- Medicamento " + (i+1) + " de " + cantidad + " ---");
                Medicamento nuevoMed = new Medicamento();
                nuevoMed.leer();
                agregarMedicamento(nuevoMed);
            }
        }
        System.out.println("Se agrego medicamento");
    }
    public Medicamento buscaMedicamento(String nombre) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i] != null && m[i].getNombre().equals(nombre)) {
                return m[i];
            }
        }
        return null;
    }
    public ArrayList<Medicamento> buscaMedicamentosPorTipo(String tipo) {
        ArrayList<Medicamento> resultado = new ArrayList<>();
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i] != null && m[i].getTipo().equals(tipo)) {
                resultado.add(m[i]);
            }
        }
        return resultado;
    }
    public ArrayList<Medicamento> getMedicamentosTos() {
        return buscaMedicamentosPorTipo("tos");
    }
    public boolean eliminarMedicamento(int codMedicamento) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i] != null && m[i].getCodMedicamento() == codMedicamento) {
                for (int j = i; j < nroMedicamentos - 1; j++) {
                    m[j] = m[j + 1];
                }
                m[nroMedicamentos - 1] = null;
                nroMedicamentos--;
                return true;
            }
        }
        return false;
    }
}