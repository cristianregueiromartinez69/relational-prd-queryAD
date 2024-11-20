package com.cristianProyectoAD.relational_prd_query.repositorio;

import com.cristianProyectoAD.relational_prd_query.registrolibros.modelo.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz repositorio donde hacemos los crud de los libros
 * @author cristian
 * @version 1.0
 */
@Repository
public interface LibrosRepositorio extends JpaRepository <Libros, String> {

    //verificar si existe un usuario con el isbn indicado
    boolean existsByIsbn(String isbn);

    //metodo que devuelve objeto tipo libro si se encuentra el isbn que introduce el usuario
    Libros findByIsbn(String isbn);

    //metodo que devuelve una lista de libros según los autores
    List<Libros> findByAutor(String autor);

    //metodo que devuelve una lista de libros según el nombre del libro
    List<Libros> findByNombre(String nombre);

    //Metodo que devuelve una lista de libros segun un rango que le demos
    List <Libros> findByFechaRegistroBetween(LocalDate startDate, LocalDate endDate);

    //metodo para encontrar una lista de libros entre fechas de lectura
    List <Libros> findByFechaLecturaBetween(LocalDate startDate, LocalDate endDate);

}
