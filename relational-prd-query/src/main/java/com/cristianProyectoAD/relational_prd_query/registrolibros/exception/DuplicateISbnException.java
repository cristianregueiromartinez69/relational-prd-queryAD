package com.cristianProyectoAD.relational_prd_query.registrolibros.exception;

public class DuplicateISbnException extends RuntimeException {
    public DuplicateISbnException(String message) {
        super(message);
    }
}
