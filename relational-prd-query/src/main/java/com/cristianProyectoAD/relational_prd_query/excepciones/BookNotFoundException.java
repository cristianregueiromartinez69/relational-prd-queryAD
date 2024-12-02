package com.cristianProyectoAD.relational_prd_query.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un libro en las consultas realizadas.
 * Esta excepción retorna un estado HTTP 400 (BAD_REQUEST) cuando es lanzada.
 *
 * Utiliza la anotación {@link ResponseStatus} para asociar el estado HTTP con la excepción.
 *
 * @author cristian
 * @version 1.0
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotFoundException extends RuntimeException {
    /**
     * Constructor de la excepción que recibe un mensaje descriptivo.
     *
     * @param message Mensaje que describe el motivo de la excepción.
     */
    public BookNotFoundException(String message) {
        super(message);
    }
}
