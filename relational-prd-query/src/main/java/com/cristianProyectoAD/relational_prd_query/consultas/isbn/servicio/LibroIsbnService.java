package com.cristianProyectoAD.relational_prd_query.consultas.isbn.servicio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.dto.LibrosRegistroDTO;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.registrolibros.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

@Service
public class LibroIsbnService {

    private final LibrosRepositorio librosRepositorio;

    public LibroIsbnService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    public Libros getLibroByIsbn(String isbn) {
        return librosRepositorio.findByIsbn(isbn);
    }
}
