package com.cristianProyectoAD.relational_prd_query.consultas.autor.servicio;

import com.cristianProyectoAD.relational_prd_query.excepciones.BookNotFoundException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio para consultar libros por autor en la base de datos PostgreSQL.
 * Utiliza el repositorio de libros para obtener la información.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroAutorService {

    private final LibrosRepositorio librosRepositorio;

    /**
     * Constructor que inyecta el repositorio de libros.
     *
     * @param libroRepositorio El repositorio que maneja las consultas a la base de datos de libros.
     */
    public LibroAutorService(LibrosRepositorio libroRepositorio) {
        this.librosRepositorio = libroRepositorio;
    }

    /**
     * Obtiene una lista de libros asociados a un autor específico desde la base de datos.
     *
     * @param autor El nombre del autor de los libros a consultar.
     * @return Una lista de libros asociados al autor proporcionado.
     */
    public List<Libros> getListLibrosByAutor(String autor){
        List<Libros> librosList = librosRepositorio.findByAutor(autor);
        if(librosList.isEmpty()){
            throw new BookNotFoundException("Lista de libros por autor inexistentes");
        }
        return librosList;
    }
}
