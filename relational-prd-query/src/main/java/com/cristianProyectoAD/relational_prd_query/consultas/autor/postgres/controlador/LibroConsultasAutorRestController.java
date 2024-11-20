package com.cristianProyectoAD.relational_prd_query.consultas.autor.postgres.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.autor.postgres.servicio.LibroAutorService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relational-prd-query/libros/consultas/")
public class LibroConsultasAutorRestController {

    private final LibroAutorService libroAutorService;

    public LibroConsultasAutorRestController(LibroAutorService libroAutorService) {
        this.libroAutorService = libroAutorService;
    }

    @GetMapping("autor{autor}")
    public ResponseEntity<List<Libros>> getLibrosByAutor(@PathVariable String autor) {
        List<Libros> librosByAutorList= libroAutorService.getListLibrosByAutor(autor);
        return ResponseEntity.ok(librosByAutorList);
    }
}
