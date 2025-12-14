package repositorio;

import java.util.List;

/**
 * INTERFAZ (ABSTRACCIÓN): Storage<T>
 *
 * - Abstracción: define QUÉ operaciones CRUD existen, sin decir CÓMO se hacen.
 * - Polimorfismo: diferentes clases pueden implementar esta interfaz (memoria, fichero, SQL...)
 * - DIP (SOLID): el servicio dependerá de esta interfaz, no de clases concretas.
 *
 * Clave para la rúbrica:
 * - Esta interfaz es el "contrato" que desacopla el resto del programa del almacenamiento.
 */
public interface Storage<T> {
    // CREATE
    T create(T item);

    // READ
    T findById(int id);
    List<T> findAll();

    // UPDATE
    boolean update(T item);

    // DELETE
    boolean deleteById(int id);

    // UTIL
    int count();
}
