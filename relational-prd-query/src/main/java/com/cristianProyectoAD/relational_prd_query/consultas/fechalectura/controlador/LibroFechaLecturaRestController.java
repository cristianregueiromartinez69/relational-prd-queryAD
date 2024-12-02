package com.cristianProyectoAD.relational_prd_query.consultas.fechalectura.controlador;

import com.cristianProyectoAD.relational_prd_query.consultas.fechalectura.servicio.LibroFechaLecturaService;
import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relational-prd-query/libros/consultas")
public class LibroFechaLecturaRestController {

    private final LibroFechaLecturaService libroFechaLecturaService;

    public LibroFechaLecturaRestController(LibroFechaLecturaService libroFechaLecturaService) {
        this.libroFechaLecturaService = libroFechaLecturaService;
    }

    @GetMapping("/fechalectura")
    public ResponseEntity<List<Libros>> getLibrosFechaLectura(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Libros> librosList = libroFechaLecturaService.getLibrosFechaLectura(fechaInicio, fechaFin);
        return ResponseEntity.ok(librosList);
    }
}
