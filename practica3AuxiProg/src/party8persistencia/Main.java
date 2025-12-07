/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package party8persistencia;

/**
 *
 * @author yessi
 */
public class Main {
    public static void main(String[] args) {
        // Iniciar la interfaz gráfica
        //Biblioteca1.main(args);
        java.awt.EventQueue.invokeLater(() -> {
            try {
                // Usar Look and Feel del sistema
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new Biblioteca1().setVisible(true);
        });
    
    }
}
