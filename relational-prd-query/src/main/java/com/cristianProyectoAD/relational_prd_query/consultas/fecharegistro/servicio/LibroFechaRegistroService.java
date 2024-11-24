package com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.servicio;

import com.cristianProyectoAD.relational_prd_query.excepciones.BookNotFoundException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaRegistroService {

    private final LibrosRepositorio librosRepositorio;

    public LibroFechaRegistroService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    public List<Libros> getLibrosByFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Libros> librosFechaRList = librosRepositorio.findByFechaRegistroBetween(fechaInicio, fechaFin);

        if(librosFechaRList.isEmpty()){
            throw new BookNotFoundException("Libro entre fechas de registro no encontrado");
        }
        return librosFechaRList;
    }
}
