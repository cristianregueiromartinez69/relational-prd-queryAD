package com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.servicio;

import com.cristianProyectoAD.relational_prd_query.excepciones.BookNotFoundException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.relational_prd_query.repositorio.LibrosRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio encargado de realizar las consultas de libros registrados dentro de un rango de fechas en la base de datos.
 * Utiliza el repositorio {@link LibrosRepositorio} para acceder a los datos de los libros almacenados.
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaRegistroService {

    private final LibrosRepositorio librosRepositorio;

    /**
     * Constructor del servicio que inyecta el repositorio de libros.
     *
     * @param librosRepositorio El repositorio utilizado para consultar los libros en la base de datos.
     */
    public LibroFechaRegistroService(LibrosRepositorio librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    /**
     * Obtiene una lista de libros registrados entre dos fechas específicas.
     *
     * @param fechaInicio La fecha de inicio del rango de búsqueda.
     * @param fechaFin La fecha de fin del rango de búsqueda.
     * @return Una lista de objetos {@link Libros} que cumplen con el criterio de fechas de registro.
     * @throws BookNotFoundException Si no se encuentran libros dentro del rango de fechas proporcionado.
     */
    public List<Libros> getLibrosByFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Libros> librosFechaRList = librosRepositorio.findByFechaRegistroBetween(fechaInicio, fechaFin);

        if(librosFechaRList.isEmpty()){
            throw new BookNotFoundException("Libro entre fechas de registro no encontrado");
        }
        return librosFechaRList;
    }
}
