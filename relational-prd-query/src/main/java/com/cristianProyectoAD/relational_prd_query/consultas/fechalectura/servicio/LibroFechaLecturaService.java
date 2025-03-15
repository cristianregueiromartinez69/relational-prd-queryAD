package com.cristianProyectoAD.relational_prd_query.consultas.fechalectura.servicio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaLecturaService {

    private final LibrosRepositorio librosRepositorio;

    public LibroFechaLecturaService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    public List<Libros> getLibrosFechaLectura(LocalDate fechaInicio, LocalDate fechaFin) {
        return librosRepositorio.findByFechaLecturaBetween(fechaInicio, fechaFin);
    }
}
