package com.cristianProyectoAD.relational_prd_query.registrolibros.servicio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.dto.LibrosRegistroDTO;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.registrolibros.repositorio.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibrosRepositorio librosRepositorio;

    public void saveBook(LibrosRegistroDTO libro) {
        Libros librosGuardar = new Libros(libro.getIsbn(), libro.getAutor(),
                libro.getNombre(), libro.getFechaLectura(), libro.getFechaRegistro());
        librosRepositorio.save(librosGuardar);
    }
}
