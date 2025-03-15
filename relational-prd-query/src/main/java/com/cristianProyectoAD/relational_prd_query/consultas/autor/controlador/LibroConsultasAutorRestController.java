package com.cristianProyectoAD.relational_prd_query.consultas.autor.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.autor.servicio.LibroAutorService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para consultar libros en la base de datos relacional (PostgreSQL) según el autor.
 * Expone un endpoint para obtener los libros asociados a un autor específico.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroConsultasAutorRestController {

    private final LibroAutorService libroAutorService;

    /**
     * Constructor que inyecta el servicio de consulta de libros por autor.
     *
     * @param libroAutorService El servicio que maneja la lógica de la consulta de libros por autor.
     */
    public LibroConsultasAutorRestController(LibroAutorService libroAutorService) {
        this.libroAutorService = libroAutorService;
    }

    /**
     * Obtiene una lista de libros asociados a un autor desde la base de datos PostgreSQL.
     *
     * @param autor El nombre del autor de los libros a consultar.
     * @return ResponseEntity que contiene la lista de libros encontrados o un error si no se encuentran libros.
     */
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Libros>> getLibrosByAutor(@PathVariable String autor) {
        List<Libros> librosByAutorList= libroAutorService.getListLibrosByAutor(autor);
        return ResponseEntity.ok(librosByAutorList);
    }
}
