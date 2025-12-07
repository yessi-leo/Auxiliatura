package Ejer1;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Charango implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas;
    
    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = new boolean[10];
        
        for (int i = 0; i < Math.min(cuerdas.length, 10); i++) {
            this.cuerdas[i] = cuerdas[i];
        }
    }
    
    public String getMaterial() {
        return material;
    }
    
    public int getNroCuerdas() {
        return nroCuerdas;
    }
    
    public boolean[] getCuerdas() {
        return cuerdas;
    }
    
    public int contarCuerdasFalse() {
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            if (!cuerdas[i]) {
                contador++;
            }
        }
        return contador;
    }
    
    @Override
    public String toString() {
        return "Charango [Material: " + material + 
               ", Cuerdas: " + nroCuerdas + 
               ", CuerdasFalse(usadas): " + contarCuerdasFalseUsadas() + 
               ", CuerdasFalse: " + contarCuerdasFalse() + "]";
    }
    public int contarCuerdasFalseUsadas() {
        int contador = 0;
        for (int i = 0; i < nroCuerdas; i++) {  
            if (!cuerdas[i]) {
                contador++;
            }
        }
        return contador;
    }
    //------------------------------------------
    public static void guardarEnArchivo(List<Charango> charangos) {
        String ARCHIVO_DAT = "charangos.dat";
        try (FileOutputStream file = new FileOutputStream(ARCHIVO_DAT);
             ObjectOutputStream sal = new ObjectOutputStream(file)) {
            for (Charango charango : charangos) {
                sal.writeObject(charango);
            }
            System.out.println("Charangos guardados en archivo binario.");
        } catch (IOException e) {
            System.out.println("Error al guardar binario: " + e.getMessage());
        }
    }
    public static List<Charango> cargarDesdeArchivo() {
        String ARCHIVO_DAT = "charangos.dat";
        List<Charango> charangos = new ArrayList<>();
        File archivo = new File(ARCHIVO_DAT);
        if (!archivo.exists()) {
            System.out.println("Archivo binario no encontrado. Se creara uno nuevo.");
            return charangos;
        }
        try (FileInputStream file = new FileInputStream(ARCHIVO_DAT);
             ObjectInputStream ent = new ObjectInputStream(file)) {
            while (true) {
                try {
                    Charango charango = (Charango) ent.readObject();
                    charangos.add(charango);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println( charangos.size() + " Charangos cargados desde archivo binario.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar binario: " + e.getMessage());
        }
        
        return charangos;
    }
    private static void guardarJSONAutomatico(List<Charango> charangos) {
        Gson gson = new Gson();
        String ARCHIVO_JSON = "charangos.json";
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON)) {
            gson.toJson(charangos, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar JSON automatico: " + e.getMessage());
        }
    }    
    private static List<Charango> cargarJSONAutomatico() {
        Gson gson = new Gson();
        String ARCHIVO_JSON = "charangos.json";
        List<Charango> charangos = new ArrayList<>();
        File archivo = new File(ARCHIVO_JSON);
        if (!archivo.exists()) {
            return charangos;
        }
        try (FileReader reader = new FileReader(ARCHIVO_JSON)) {
            Type tipoLista = new TypeToken<ArrayList<Charango>>(){}.getType();
            charangos = gson.fromJson(reader, tipoLista);
            System.out.println(charangos.size() + " Charangos cargados desde JSON (respaldo).");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        return charangos;
    }
    public static void guardarAutomatico(List<Charango> charangos) {
        guardarEnArchivo(charangos);
        guardarJSONAutomatico(charangos);
    }
    // b) 
    public static List<Charango> eliminarPorCuerdasFalse(List<Charango> charangos) {
        List<Charango> resultado = new ArrayList<>();
        for (Charango charango : charangos) {
            if (charango.contarCuerdasFalse() <= 6) {
                resultado.add(charango);
            }
        }
        int eliminados = charangos.size() - resultado.size();
        System.out.println("Se eliminaron " + eliminados + " charangos con mas de 6 cuerdas false.");
        if (eliminados > 0) {
            guardarAutomatico(resultado);
        }
        return resultado;
    }
    public static List<Charango> agregarCharango(List<Charango> charangos, Charango nuevo) {
        charangos.add(nuevo);
        System.out.println("Charango agregado.");
        guardarAutomatico(charangos);
        return charangos;
    }
    // e) 
    public static List<Charango> ordenarPorMaterial(List<Charango> charangos) {
        List<Charango> ordenados = new ArrayList<>(charangos);
        Collections.sort(ordenados, new Comparator<Charango>() {
            @Override
            public int compare(Charango c1, Charango c2) {
                return c1.getMaterial().compareToIgnoreCase(c2.getMaterial());
            }
        });
        System.out.println("Charangos ordenados por material.");
        guardarAutomatico(ordenados);
        return ordenados;
    }
    // c) 
    public static void listarPorMaterial(List<Charango> charangos, String materialBuscado) {
        System.out.println("\nCharangos de material: " + materialBuscado);
        boolean encontrado = false;
        for (int i = 0; i < charangos.size(); i++) {
            Charango charango = charangos.get(i);
            if (charango.getMaterial().equals(materialBuscado)) {
                System.out.println((i+1) + ". " + charango);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay charangos con ese material.");
        }
    }
    // d)
    public static void buscarCon10Cuerdas(List<Charango> charangos) {
        System.out.println("\nCharangos con 10 cuerdas:");
        int contador = 0;
        int i = 0;
        while (i < charangos.size()) {
            Charango charango = charangos.get(i);
            if (charango.getNroCuerdas() == 10) {
                System.out.println((contador+1) + ". " + charango);
                contador++;
            }
            i++;
        }
        if (contador == 0) {
            System.out.println("No se encontraron charangos con 10 cuerdas.");
        } else {
            System.out.println("Total encontrados: " + contador);
        }
    }
    // Mostrar
    public static void mostrarTodos(List<Charango> charangos) {
        System.out.println("\n------ LISTA DE CHARANGOS (" + charangos.size() + ") ---------");
        if (charangos.isEmpty()) {
            System.out.println("No hay charangos registrados.");
            return;
        }
        for (int i = 0; i < charangos.size(); i++) {
            System.out.println((i+1) + ". " + charangos.get(i));
        }
    }
}