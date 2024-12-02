package com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.servicio.LibroFechaRegistroService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para manejar las consultas de libros basadas en el rango de fechas de registro.
 * Este controlador expone un endpoint para obtener libros registrados dentro de un rango de fechas especificado.
 *
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroFechaRegistroRestController {

    private final LibroFechaRegistroService libroFechaRegistroService;

    /**
     * Constructor del controlador que inyecta el servicio de consulta de libros por fecha de registro.
     *
     * @param libroFechaRegistroService Servicio utilizado para obtener los libros según el rango de fechas de registro.
     */
    public LibroFechaRegistroRestController(LibroFechaRegistroService libroFechaRegistroService) {
        this.libroFechaRegistroService = libroFechaRegistroService;
    }

    /**
     * Consulta libros registrados en un rango de fechas específico.
     *
     * @param fechaInicio La fecha de inicio del rango de búsqueda.
     * @param fechaFin La fecha de fin del rango de búsqueda.
     * @return ResponseEntity que contiene una lista de libros encontrados en formato {@link Libros},
     *         o un código de error si no se encuentran libros dentro del rango de fechas.
     */
    @GetMapping("/fecharegistro")
    public ResponseEntity<List<Libros>> getLibrosByFechaRegistro(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        List<Libros> librosListFechaR = libroFechaRegistroService.getLibrosByFechaRegistro(fechaInicio, fechaFin);
        return ResponseEntity.ok().body(librosListFechaR);
    }
}
