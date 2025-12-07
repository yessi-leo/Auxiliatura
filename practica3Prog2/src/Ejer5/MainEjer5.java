/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer5;

/**
 *
 * @author yessi
 */
public class MainEjer5 {
    public static void main(String[] args) {        
        ArchFarmacia archivo = new ArchFarmacia("farmacia.txt");
        archivo.crearArchivo();
        Medicamento m1 = new Medicamento("Tapsin", 1001, "analgesico", 15.50);
        Medicamento m2 = new Medicamento("Jarabe para la tos", 1002, "tos", 12.75);
        Medicamento m3 = new Medicamento("Aspirina", 1003, "analgesico", 8.90);
        Medicamento m4 = new Medicamento("Antigripal", 1004, "resfriado", 18.25);
        Medicamento m5 = new Medicamento("Jarabe expectorante", 1005, "tos", 14.30);
        Medicamento m6 = new Medicamento("Paracetamol", 1006, "analgesico", 7.50);
        System.out.println("\nMedicamentos creados");
        m1.mostrar();
        m2.mostrar();
        m3.mostrar();
        m4.mostrar();
        m5.mostrar();
        m6.mostrar();
        Farmacia f1 = new Farmacia("Central",1, "Av. Principal 123");
        Farmacia f2 = new Farmacia("Corea de Norte",2, "Calle Norte 456");
        Farmacia f3 = new Farmacia("Sur",3, "Av. Sur 789");

        f1.agregarMedicamento(m1); 
        f1.agregarMedicamento(m2); 
        f1.agregarMedicamento(m3); 

        f2.agregarMedicamento(m4); 
        f2.agregarMedicamento(m5); 
        f2.agregarMedicamento(m1); 
        
        f3.agregarMedicamento(m6);
        f3.agregarMedicamento(m2); 
        f3.agregarMedicamento(m4); 
        System.out.println("\n------FARMACIAS CREADAS------");
        f3.mostrar();
        f3.mostrar();
        f3.mostrar();
        // a)
        System.out.println("\n a) MEDICAMENTOS PARA LA TOS DE SUCURSAL 1");
        archivo.mostrarMedicamentosTosSucursal(1);
        // b)
        System.out.println("\n b) FARMACIAS QUE TIENEN TAPSIN");
        archivo.mostrarSucursalesConTapsin();
        
        // c) 
        System.out.println("\n c) BUSCAR MEDICAMENTOS ANALGESICOS");
        archivo.buscarMedicamentosPorTipo("analgesico");
        // d) 
        System.out.println("\n d) FARMACIAS ORDENADAS POR DIRECCION");
        archivo.ordenarFarmaciasPorDireccion();
        // e) 
        System.out.println("\n e) MOVER MEDICAMENTOS");
        System.out.println("Medicamentos para la tos en Sucursal 1");
        archivo.mostrarMedicamentosTosSucursal(1);
        System.out.println("\nMedicamentos para la tos en Sucursal 3:");
        archivo.mostrarMedicamentosTosSucursal(3);
        archivo.moverMedicamentosTipo("tos", 1, 3);
        System.out.println("\n----------------despues--------------");
        System.out.println("Medicamentos para la tos en Sucursal 1:");
        archivo.mostrarMedicamentosTosSucursal(101);
        System.out.println("\nMedicamentos para la tos en Sucursal 3:");
        archivo.mostrarMedicamentosTosSucursal(3);
    }
}