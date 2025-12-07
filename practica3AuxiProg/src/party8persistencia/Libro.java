/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package party8persistencia;

import java.io.Serializable;

/**
 *
 * @author yessi
 */
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String titulo;
    private String autor;
    private String isbn;
    private int añoPublicacion;
    
    public Libro(String titulo, String autor, String isbn, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.añoPublicacion = añoPublicacion;
    }
    
    public Libro(String titulo, String autor) {
        this(titulo, autor, "N/A", 0);
    }
    
    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public int getAñoPublicacion() { return añoPublicacion; }
    public void setAñoPublicacion(int añoPublicacion) { this.añoPublicacion = añoPublicacion; }
    
    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + añoPublicacion + ")";
    }
}