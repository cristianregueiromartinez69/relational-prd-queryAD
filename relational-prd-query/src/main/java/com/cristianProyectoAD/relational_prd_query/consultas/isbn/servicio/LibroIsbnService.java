package com.cristianProyectoAD.relational_prd_query.consultas.isbn.servicio;

import com.cristianProyectoAD.relational_prd_query.excepciones.BookNotFoundException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de gestionar las consultas de libros por ISBN.
 * Interactúa con el repositorio para obtener los datos de los libros en la base de datos.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnService {

    private final LibrosRepositorio librosRepositorio;

    /**
     * Constructor que inyecta el repositorio de libros.
     *
     * @param librosRepositorio El repositorio que gestiona la interacción con la base de datos.
     */
    public LibroIsbnService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    /**
     * Obtiene un libro a partir de su ISBN.
     *
     * @param isbn El ISBN del libro a consultar.
     * @return El libro encontrado con el ISBN especificado.
     */
    public Libros getLibroByIsbn(String isbn) {
        Libros libros = librosRepositorio.findByIsbn(isbn);
        if(libros == null){
            throw new BookNotFoundException("Este libro por isbn no existe");
        }
        return libros;
    }
}
