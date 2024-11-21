package com.cristianProyectoAD.relational_prd_query.consultas.nombre.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.nombre.servicio.LibroNombreService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relational-prd-query/libros/consultas/")
public class LibroNombreRestController {

    private final LibroNombreService libroNombreService;

    public LibroNombreRestController(LibroNombreService libroNombreService) {
        this.libroNombreService = libroNombreService;
    }

    @GetMapping("nombre{nombre}")
    public ResponseEntity<List<Libros>> getLibrosByNombrePostgres(@PathVariable String nombre) {
        List<Libros> libros = libroNombreService.getLibrosByNombre(nombre);
        return ResponseEntity.ok(libros);
    }
}
