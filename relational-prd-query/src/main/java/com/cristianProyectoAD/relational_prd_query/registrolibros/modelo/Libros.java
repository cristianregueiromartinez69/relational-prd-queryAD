package com.cristianProyectoAD.relational_prd_query.registrolibros.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad libros que será una tabla de la base de datos
 * con entity marcamos que será una tabla y con table(name=(nombre)) indicamos el nombre de la tabla
 */
@Entity
@Table(name = "libros", uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))
public class Libros {

    /**
     * Indicamos que será la clave primaria con Id y que tiene que ser unica con unique=true, el nombre lo indicamos con name=(nombre)
     */
    @Id
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    /**
     * resto de columnas de la tabla con sus nombres
     */
    @Column(name = "autor")
    private String autor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_lectura")
    private LocalDate fechaLectura;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    /**
     * Contructos de la clase libros
     * @param isbn el isbn del libro
     * @param autor el autor del libro
     * @param nombre el nombre del libro
     * @param fechaLectura la fecha de lectura del libro
     * @param fechaRegistro la fecha de registro del libro
     */
    public Libros(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public Libros(){

    }

    /**
     * getter y setter de la clase
     * @return el valor correspondiente
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
