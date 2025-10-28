/**
 * Interfaz: StudentRepository
 *
 * Descripción:
 * Define el contrato (las operaciones básicas CRUD) que debe cumplir cualquier
 * clase encargada de almacenar estudiantes (crear, leer, actualizar, eliminar).
 *
 * Principios POO aplicados:
 * - Abstracción: define qué operaciones existen sin mostrar cómo se implementan.
 * - Polimorfismo: permite que diferentes clases (repositorios) implementen este contrato
 *                 y sean utilizadas de la misma forma desde el código cliente.
 * - Reutilización: otras clases pueden usar esta interfaz sin preocuparse del tipo concreto
 *                  de almacenamiento (en memoria, archivo, base de datos, etc.).
 *
 * Responsabilidad:
 * - Especificar las operaciones básicas que un repositorio de estudiantes debe ofrecer.
 *
 * Nota:
 * La interfaz no almacena nada, solo define los métodos que las implementaciones deben tener.
 */

import java.util.List;

public interface StudentRepository {
    Student create(Student student);        // C (Create)
    Student findById(int id);               // R (Read)
    List<Student> findAll();                // R (Read All)
    boolean update(Student student);        // U (Update)
    boolean deleteById(int id);             // D (Delete)
    int count();                            // utilitario
}
