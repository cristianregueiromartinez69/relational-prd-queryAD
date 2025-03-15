package com.cristianProyectoAD.relational_prd_query.consultas.isbn.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.isbn.servicio.LibroIsbnService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

/**
 * Controlador REST para gestionar las consultas de libros por ISBN.
 * Permite consultar un libro por su ISBN en la base de datos.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroConsultaIsbnRestController {

    private final LibroIsbnService libroIsbnService;

    /**
     * Constructor que inyecta el servicio encargado de la consulta de libros por ISBN.
     *
     * @param libroIsbnService El servicio que gestiona las consultas de libros por ISBN.
     */
    public LibroConsultaIsbnRestController(LibroIsbnService libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    /**
     * Consulta un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a consultar.
     * @return Una respuesta HTTP con el libro encontrado o un error 404 si no se encuentra.
     */
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Libros> getLibroByIsbn(@PathVariable String isbn) {

            Libros libro = libroIsbnService.getLibroByIsbn(isbn);
            return ResponseEntity.ok(libro);
    }
}
