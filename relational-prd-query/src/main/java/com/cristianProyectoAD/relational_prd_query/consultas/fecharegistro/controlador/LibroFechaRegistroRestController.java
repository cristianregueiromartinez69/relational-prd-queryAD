package com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.servicio.LibroFechaRegistroService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroFechaRegistroRestController {

    private final LibroFechaRegistroService libroFechaRegistroService;

    public LibroFechaRegistroRestController(LibroFechaRegistroService libroFechaRegistroService) {
        this.libroFechaRegistroService = libroFechaRegistroService;
    }

    @GetMapping("/fecharegistro")
    public ResponseEntity<List<Libros>> getLibrosByFechaRegistro(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        List<Libros> librosListFechaR = libroFechaRegistroService.getLibrosByFechaRegistro(fechaInicio, fechaFin);
        return ResponseEntity.ok().body(librosListFechaR);
    }
}
