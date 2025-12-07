/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package party8persistencia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yessi
 */
public class Biblioteca1  extends JFrame {
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private JTextField txtTitulo, txtAutor, txtISBN, txtAño;
    private JButton btnAgregar, btnEliminar, btnGuardarJSON, btnCargarJSON, btnGuardarBin, btnCargarBin;
    private List<Libro> libros;
    private GestorPersistencia gestor;
    
    public Biblioteca1() {
        libros = new ArrayList<>();
        gestor = new GestorPersistencia();
        
        inicializarComponentes();
        configurarVentana();
        cargarDatosIniciales();
    }
    
    private void inicializarComponentes() {
        // Configurar modelo de tabla
        String[] columnas = {"Título", "Autor", "ISBN", "Año"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable directamente
            }
        };
        tablaLibros = new JTable(modeloTabla);
        
        // Panel para formulario
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Nuevo Libro"));
        
        panelFormulario.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelFormulario.add(txtTitulo);
        
        panelFormulario.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelFormulario.add(txtAutor);
        
        panelFormulario.add(new JLabel("ISBN:"));
        txtISBN = new JTextField();
        panelFormulario.add(txtISBN);
        
        panelFormulario.add(new JLabel("Año:"));
        txtAño = new JTextField();
        panelFormulario.add(txtAño);
        
        // Panel para botones de acciones
        JPanel panelBotones = new JPanel(new FlowLayout());
        
        btnAgregar = new JButton("Agregar Libro");
        btnEliminar = new JButton("Eliminar Seleccionado");
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        
        // Panel para persistencia
        JPanel panelPersistencia = new JPanel(new GridLayout(2, 2, 10, 10));
        panelPersistencia.setBorder(BorderFactory.createTitledBorder("Persistencia"));
        
        btnGuardarJSON = new JButton("Guardar JSON");
        btnCargarJSON = new JButton("Cargar JSON");
        btnGuardarBin = new JButton("Guardar Binario");
        btnCargarBin = new JButton("Cargar Binario");
        
        panelPersistencia.add(btnGuardarJSON);
        panelPersistencia.add(btnCargarJSON);
        panelPersistencia.add(btnGuardarBin);
        panelPersistencia.add(btnCargarBin);
        
        // Configurar acciones de botones
        configurarAcciones();
        
        // Organizar componentes en la ventana
        setLayout(new BorderLayout(10, 10));
        
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(new JScrollPane(tablaLibros), BorderLayout.SOUTH);
        add(panelPersistencia, BorderLayout.EAST);
    }
    
    private void configurarAcciones() {
        // Agregar libro
        btnAgregar.addActionListener(e -> agregarLibro());
        
        // Eliminar libro seleccionado
        btnEliminar.addActionListener(e -> eliminarLibro());
        
        // Persistencia JSON
        btnGuardarJSON.addActionListener(e -> gestor.guardarJSON(libros));
        btnCargarJSON.addActionListener(e -> {
            libros = gestor.cargarJSON();
            actualizarTabla();
        });
        
        // Persistencia binaria
        btnGuardarBin.addActionListener(e -> gestor.guardarBinario(libros));
        btnCargarBin.addActionListener(e -> {
            libros = gestor.cargarBinario();
            actualizarTabla();
        });
        
        // Permitir agregar con Enter en cualquier campo
        KeyListener enterListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    agregarLibro();
                }
            }
        };
        
        txtTitulo.addKeyListener(enterListener);
        txtAutor.addKeyListener(enterListener);
        txtISBN.addKeyListener(enterListener);
        txtAño.addKeyListener(enterListener);
    }
    
    private void agregarLibro() {
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String isbn = txtISBN.getText().trim();
        String añoStr = txtAño.getText().trim();
        
        if (titulo.isEmpty() || autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Título y Autor son obligatorios", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int año = 0;
        try {
            if (!añoStr.isEmpty()) {
                año = Integer.parseInt(añoStr);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Año debe ser un número válido", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Libro nuevoLibro = new Libro(titulo, autor, isbn, año);
        libros.add(nuevoLibro);
        actualizarTabla();
        
        // Limpiar campos
        txtTitulo.setText("");
        txtAutor.setText("");
        txtISBN.setText("");
        txtAño.setText("");
        txtTitulo.requestFocus();
    }
    
    private void eliminarLibro() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, 
                "Seleccione un libro para eliminar", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar este libro?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            libros.remove(filaSeleccionada);
            actualizarTabla();
        }
    }
    
    private void actualizarTabla() {
        // Limpiar tabla
        modeloTabla.setRowCount(0);
        
        // Agregar libros a la tabla
        for (Libro libro : libros) {
            Object[] fila = {
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getAñoPublicacion()
            };
            modeloTabla.addRow(fila);
        }
    }
    
    private void cargarDatosIniciales() {
        // Intentar cargar desde JSON primero
        libros = gestor.cargarJSON();
        
        // Si no hay datos en JSON, intentar cargar desde binario
        if (libros.isEmpty()) {
            libros = gestor.cargarBinario();
        }
        
        // Si aún no hay datos, crear algunos ejemplos
        if (libros.isEmpty()) {
            libros.add(new Libro("Mi Planta de Naranja Lima", "José Mauro de Vasconcelos", "978-841-664-190", 1968));
            libros.add(new Libro("La Divina Comedia", "Dante Alighieri", "978-843-761-511", 1320));
            libros.add(new Libro("El Alquimista", "Paulo Coelho", "978-840-804-364", 1988));
        }
        
        actualizarTabla();
    }
    
    private void configurarVentana() {
        setTitle("Sistema de Biblioteca - Práctica 6");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Configurar cierre para guardar automáticamente
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    Biblioteca1.this,
                    "¿Desea guardar los datos antes de salir?",
                    "Guardar cambios",
                    JOptionPane.YES_NO_CANCEL_OPTION);
                
                if (opcion == JOptionPane.YES_OPTION) {
                    gestor.guardarJSON(libros);
                    gestor.guardarBinario(libros);
                    dispose();
                } else if (opcion == JOptionPane.NO_OPTION) {
                    dispose();
                }
                // Si es CANCEL_OPTION, no hacer nada (cancelar cierre)
            }
        });
    }
    
    public static void main(String[] args) {
        // Usar Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            Biblioteca1 gui = new Biblioteca1();
            gui.setVisible(true);
        });
    }
}