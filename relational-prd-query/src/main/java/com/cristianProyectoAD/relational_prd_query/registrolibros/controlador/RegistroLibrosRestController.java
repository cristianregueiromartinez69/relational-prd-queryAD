package com.cristianProyectoAD.relational_prd_query.registrolibros.controlador;

import com.cristianProyectoAD.relational_prd_query.registrolibros.dto.LibrosRegistroDTO;
import com.cristianProyectoAD.relational_prd_query.registrolibros.exception.DuplicateISbnException;
import com.cristianProyectoAD.relational_prd_query.registrolibros.servicio.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RestController del guardado de libros en postgres
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/relational-prd-query/libros")
public class RegistroLibrosRestController {

    //variable del servicio de registro de libros
    private final LibroService libroService;

    /**
     * Constructor de la clase
     * @param libroService el servicio de registro de libros
     */
    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Metodo para guardar los libros en la base de datos
     * @param registro los libros que se registran en la base
     * @return un mensaje indicando si se realizó el registro
     */
    @PostMapping("/guardar")
    public ResponseEntity<String> saveBooksPostgres(@RequestBody LibrosRegistroDTO registro) {
        try{
            libroService.saveBook(registro);
        } catch (DuplicateISbnException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Registro de libro en postgresSQL");
    }


}
