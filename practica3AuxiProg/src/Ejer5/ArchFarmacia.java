/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer5;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author yessi
 */
public class ArchFarmacia {
    private String na; 
    
    public ArchFarmacia(String na) {
        this.na = na;
    }
    
    public void crearArchivo() {
        try {
            File archivo = new File(na);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // a) 
    public void mostrarMedicamentosTosSucursal(int sucursalX) {
        ArrayList<Farmacia> farmacias = leerTodasFarmacias();
        boolean encontrado = false;
        for (Farmacia farmacia : farmacias) {
            if (farmacia.getSucursal() == sucursalX) {
                encontrado = true;
                ArrayList<Medicamento> medicamentosTos = farmacia.getMedicamentosTos();
                if (medicamentosTos.isEmpty()) {
                    System.out.println("La sucursal " + sucursalX + " no tiene medicamentos para la tos");
                } else {
                    System.out.println("\n MEDICAMENTOS PARA LA TOS - SUCURSAL " + sucursalX );
                    for (Medicamento med : medicamentosTos) {
                        med.mostrar();
                    }
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro la sucursal " + sucursalX);
        }
    }
    // b) 
    public void mostrarSucursalesConTapsin() {
        ArrayList<Farmacia> farmacias = leerTodasFarmacias();
        boolean encontrado = false;
        System.out.println("\n FARMACIAS CON TAPSIN");
        for (Farmacia farmacia : farmacias) {
            Medicamento tapsin = farmacia.buscaMedicamento("Tapsin");
            if (tapsin != null) {
                encontrado = true;
                System.out.println("Sucursal: " + farmacia.getSucursal() + ", Direccion: " + farmacia.getDireccion());
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro el medicamento");
        }
    }
    // c)
    public void buscarMedicamentosPorTipo(String tipo) {
        ArrayList<Farmacia> farmacias = leerTodasFarmacias();
        boolean encontrado = false;
        System.out.println("\n MEDICAMENTOS DE TIPO: " + tipo.toUpperCase() + " ===");
        for (Farmacia farmacia : farmacias) {
            ArrayList<Medicamento> medicamentos = farmacia.buscaMedicamentosPorTipo(tipo);
            if (!medicamentos.isEmpty()) {
                encontrado = true;
                System.out.println("Farmacia: " + farmacia.getNombreFarmacia() + " , Sucursal " + farmacia.getSucursal());
                for (Medicamento med : medicamentos) {
                    System.out.println("  - " + med.getNombre() + " - Bs" + med.getPrecio());
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron los medicamentos");
        }
    }
    // d) 
    public void ordenarFarmaciasPorDireccion() {
        ArrayList<Farmacia> farmacias = leerTodasFarmacias();
        if (farmacias.isEmpty()) {
            System.out.println("No hay farmacias registradas");
            return;
        }
        for (int i = 0; i < farmacias.size() - 1; i++) {
            for (int j = 0; j < farmacias.size() - i - 1; j++) {
                String dir1 = farmacias.get(j).getDireccion();
                String dir2 = farmacias.get(j + 1).getDireccion();
                if (dir1.compareToIgnoreCase(dir2) > 0) {
                    Farmacia temp = farmacias.get(j);
                    farmacias.set(j, farmacias.get(j + 1));
                    farmacias.set(j + 1, temp);
                }
            }
        }
        System.out.println("\n FARMACIAS ORDENADAS POR DIRECCION");
        for (Farmacia farmacia : farmacias) {
            System.out.println("Direccion: " + farmacia.getDireccion() + ", Sucursal: " + farmacia.getSucursal() +",  Nombre: " + farmacia.getNombreFarmacia());
        }
    }
    // e) 
    public void moverMedicamentosTipo(String tipo, int sucursalOrigen, int sucursalDestino) {
        ArrayList<Farmacia> farmacias = leerTodasFarmacias();
        Farmacia origen = null;
        Farmacia destino = null;
        for (Farmacia farmacia : farmacias) {
            if (farmacia.getSucursal() == sucursalOrigen) {
                origen = farmacia;
            }
            if (farmacia.getSucursal() == sucursalDestino) {
                destino = farmacia;
            }
        }
        if (origen == null) {
            System.out.println("No se encontro la farmacia origen (sucursal " + sucursalOrigen + ")");
            return;
        }
        if (destino == null) {
            System.out.println("No se encontro la farmacia destino (sucursal " + sucursalDestino + ")");
            return;
        }
        ArrayList<Medicamento> medicamentosMover = origen.buscaMedicamentosPorTipo(tipo);
        if (medicamentosMover.isEmpty()) {
            System.out.println("No hay medicamentos de tipo '" + tipo + "' en la sucursal origen");
            return;
        }
        int movidos = 0;
        for (Medicamento med : medicamentosMover) {
            if (destino.agregarMedicamento(med)) {
                if (origen.eliminarMedicamento(med.getCodMedicamento())) {
                    movidos++;
                }
            }
        }
        guardarFarmacias(farmacias);
        System.out.println("Se movieron " + movidos + " medicamentos de tipo '" + tipo + "' de sucursal " + sucursalOrigen + " a sucursal " + sucursalDestino);
    }
    private ArrayList<Farmacia> leerTodasFarmacias() {
        ArrayList<Farmacia> farmacias = new ArrayList<>();
        File archivo = new File(na);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return farmacias;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(na))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                if (datos.length >= 3) {
                    String nombre = datos[0].trim();
                    int sucursal = Integer.parseInt(datos[1].trim());
                    String direccion = datos[2].trim();
                    Farmacia farmacia = new Farmacia(nombre, sucursal, direccion);
                    if (datos.length > 3 && datos[3].startsWith("Medicamentos:")) {
                        String medicamentosStr = datos[3].substring("Medicamentos:".length());
                        String[] medicamentosData = medicamentosStr.split(";");
                        for (String medData : medicamentosData) {
                            if (!medData.trim().isEmpty()) {
                                String[] medParts = medData.split(",");
                                if (medParts.length == 4) {
                                    String medNombre = medParts[0].trim();
                                    int codMed = Integer.parseInt(medParts[1].trim());
                                    String tipo = medParts[2].trim();
                                    double precio = Double.parseDouble(medParts[3].trim());
                                    Medicamento med = new Medicamento(medNombre, codMed, tipo, precio);
                                    farmacia.agregarMedicamento(med);
                                }
                            }
                        }
                    }
                    farmacias.add(farmacia);
                }
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            }
        return farmacias;
    }
    private void guardarFarmacias(ArrayList<Farmacia> farmacias) {
        try (PrintWriter out = new PrintWriter(new FileWriter(na))) {
            for (Farmacia farmacia : farmacias) {
                String linea = "";
                linea = linea + farmacia.getNombreFarmacia() + "|";
                linea = linea + farmacia.getSucursal() + "|";
                linea = linea + farmacia.getDireccion() + "|";
                linea = linea + "Medicamentos:";
                for (int i = 0; i < farmacia.getNroMedicamentos(); i++) {
                    Medicamento med = farmacia.getMedicamento(i);
                    linea = linea + med.getNombre() + ",";
                    linea = linea + med.getCodMedicamento() + ",";
                    linea = linea + med.getTipo() + ",";
                    linea = linea + med.getPrecio() + ";";
                }
                out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void agregarFarmacia(Farmacia farmacia) {
        ArrayList<Farmacia> farmacias = leerTodasFarmacias();
        farmacias.add(farmacia);
        guardarFarmacias(farmacias);
        System.out.println("Farmacia agregada: " + farmacia.getNombreFarmacia());
    }
}