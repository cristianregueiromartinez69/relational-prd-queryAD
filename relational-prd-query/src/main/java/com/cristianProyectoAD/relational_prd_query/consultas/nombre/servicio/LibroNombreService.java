package com.cristianProyectoAD.relational_prd_query.consultas.nombre.servicio;

import com.cristianProyectoAD.relational_prd_query.excepciones.BookNotFoundException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona las consultas de libros por nombre en la base de datos relacional.
 * Proporciona la lógica de negocio para buscar libros por nombre y manejar posibles excepciones.
 * Utiliza el repositorio {@link LibrosRepositorio} para interactuar con la base de datos.
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroNombreService {

    private final LibrosRepositorio librosRepositorio;

    /**
     * Constructor que inyecta el repositorio de libros.
     *
     * @param librosRepositorio Repositorio utilizado para realizar consultas en la base de datos.
     */
    public LibroNombreService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    /**
     * Busca libros en la base de datos por su nombre.
     * Si no se encuentran libros con el nombre proporcionado, lanza una excepción {@link BookNotFoundException}.
     *
     * @param nombre Nombre del libro a buscar en la base de datos.
     * @return Una lista de objetos {@link Libros} que coinciden con el nombre proporcionado.
     * @throws BookNotFoundException Si no se encuentran libros con el nombre especificado.
     */
    public List<Libros> getLibrosByNombre(String nombre) {
        List<Libros> listaLibros = librosRepositorio.findByNombre(nombre);
        if(listaLibros.isEmpty()){
            throw new BookNotFoundException("Lista de libros por nombre no encontrado");
        }
        return listaLibros;
    }
}
