package com.cristianProyectoAD.relational_prd_query.registrolibros.dto;

import java.time.LocalDate;


/**
 * DT0 de la clase Libros que sirve de intermediaria entre la entidad y las demás capas de la aplicación
 * @author cristian
 * @version 1.0
 */
public class LibrosRegistroDTO {

    /**
     * Atributos privados de la clase
     */
    private String isbn;

    private String autor;

    private String nombre;


    private LocalDate fechaLectura;


    private LocalDate fechaRegistro;

    /**
     * Contructor de la clase
     * @param isbn el isbn del libro que será la clave primaria
     * @param autor el autor del libro
     * @param nombre el nombre del libro
     * @param fechaLectura la fecha de lectura del libro
     * @param fechaRegistro la fecha en que fue registrado el libro
     */
    public LibrosRegistroDTO(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public LibrosRegistroDTO() {

    }


    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(LocalDate fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

