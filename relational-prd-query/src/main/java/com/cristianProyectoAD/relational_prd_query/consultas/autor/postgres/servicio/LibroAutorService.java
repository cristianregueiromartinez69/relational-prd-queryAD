package com.cristianProyectoAD.relational_prd_query.consultas.autor.postgres.servicio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroAutorService {

    private final LibrosRepositorio librosRepositorio;

    public LibroAutorService(LibrosRepositorio libroRepositorio) {
        this.librosRepositorio = libroRepositorio;
    }

    public List<Libros> getListLibrosByAutor(String autor){
        return librosRepositorio.findByAutor(autor);
    }
}
