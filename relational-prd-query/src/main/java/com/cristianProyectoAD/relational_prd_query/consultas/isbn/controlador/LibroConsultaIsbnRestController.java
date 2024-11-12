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

@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroConsultaIsbnRestController {

    private final LibroIsbnService libroIsbnService;

    public LibroConsultaIsbnRestController(LibroIsbnService libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    @GetMapping("isbn{isbn}")
    public ResponseEntity<Libros> getLibroByIsbn(@PathVariable String isbn) {
        try {
            Libros libro = libroIsbnService.getLibroByIsbn(isbn);
            return ResponseEntity.ok(libro);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
