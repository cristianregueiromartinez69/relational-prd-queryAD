package com.cristianProyectoAD.relational_prd_query.consultas.nombre.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.nombre.servicio.LibroNombreService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para manejar consultas de libros por nombre en la base de datos relacional.
 * Proporciona un endpoint para buscar libros utilizando un nombre específico.
 * Utiliza el servicio {@link LibroNombreService} para realizar las consultas.
 *
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroNombreRestController {

    private final LibroNombreService libroNombreService;

    /**
     * Constructor del controlador que inyecta el servicio de consulta de libros por nombre.
     *
     * @param libroNombreService Servicio utilizado para manejar la lógica de negocio relacionada con la consulta de libros por nombre.
     */
    public LibroNombreRestController(LibroNombreService libroNombreService) {
        this.libroNombreService = libroNombreService;
    }

    /**
     * Endpoint para obtener una lista de libros por su nombre.
     * Realiza una búsqueda en la base de datos utilizando el nombre proporcionado como parámetro.
     *
     * @param nombre El nombre del libro a buscar.
     * @return Un {@link ResponseEntity} que contiene una lista de objetos {@link Libros} con los libros encontrados.
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Libros>> getLibrosByNombrePostgres(@PathVariable String nombre) {
        List<Libros> libros = libroNombreService.getLibrosByNombre(nombre);
        return ResponseEntity.ok(libros);
    }
}
