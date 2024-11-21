package com.cristianProyectoAD.relational_prd_query.consultas.nombre.servicio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroNombreService {

    private final LibrosRepositorio librosRepositorio;

    public LibroNombreService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    public List<Libros> getLibrosByNombre(String nombre) {
        return librosRepositorio.findByNombre(nombre);
    }
}
