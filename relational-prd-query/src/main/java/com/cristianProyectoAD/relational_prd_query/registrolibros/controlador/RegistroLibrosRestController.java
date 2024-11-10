package com.cristianProyectoAD.relational_prd_query.registrolibros.controlador;

import com.cristianProyectoAD.relational_prd_query.registrolibros.dto.LibrosRegistroDTO;
import com.cristianProyectoAD.relational_prd_query.registrolibros.servicio.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relational-prd-query/libros")
public class RegistroLibrosRestController {

    private final LibroService libroService;

    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveBooksPostgres(@RequestBody LibrosRegistroDTO registro) {
        libroService.saveBook(registro);
        return ResponseEntity.ok("Registro de libro en postgresSQL");
    }
}
