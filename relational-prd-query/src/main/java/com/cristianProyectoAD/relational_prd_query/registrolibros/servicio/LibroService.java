package com.cristianProyectoAD.relational_prd_query.registrolibros.servicio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.dto.LibrosRegistroDTO;
import com.cristianProyectoAD.relational_prd_query.registrolibros.exception.DuplicateISbnException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio del registro de libros
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroService {

    //inyeccion de dependencias en el repositorio de libros
    @Autowired
    private LibrosRepositorio librosRepositorio;

    /**
     * Metodo para guardar libros en la base de datos
     *
     * @param libro el libro ha guardar
     */
    public void saveBook(LibrosRegistroDTO libro) throws DuplicateISbnException {
        if(!librosRepositorio.existsByIsbn(libro.getIsbn())) {
            Libros librosGuardar = new Libros(libro.getIsbn(), libro.getAutor(),
                    libro.getNombre(), libro.getFechaLectura(), libro.getFechaRegistro());
            librosRepositorio.save(librosGuardar);
        }
        else{
            throw new DuplicateISbnException("Este libro ya existe en la base de datos");
        }

    }
}
