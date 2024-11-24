package com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.fecharegistro.servicio.LibroFechaRegistroService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relational-prd-query/libros/consultas/")
public class LibroFechaRegistroRestController {

    private final LibroFechaRegistroService libroFechaRegistroService;

    public LibroFechaRegistroRestController(LibroFechaRegistroService libroFechaRegistroService) {
        this.libroFechaRegistroService = libroFechaRegistroService;
    }

    @GetMapping("fecharegistro/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<Libros>> getLibrosByFechaRegistro(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin) {
        List<Libros> librosListFechaR = libroFechaRegistroService.getLibrosByFechaRegistro(fechaInicio, fechaFin);
        return ResponseEntity.ok().body(librosListFechaR);
    }
}
