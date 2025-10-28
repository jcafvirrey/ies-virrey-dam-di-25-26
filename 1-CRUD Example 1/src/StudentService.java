/**
 * Clase: StudentService
 *
 * Descripción:
 * Actúa como capa intermedia entre el repositorio (almacenamiento) y el programa principal.
 * Aplica reglas de validación y lógica de negocio antes de llamar a las operaciones CRUD.
 *
 * Principios POO aplicados:
 * - Abstracción: usa la interfaz StudentRepository sin conocer su implementación.
 * - Polimorfismo: puede trabajar con cualquier clase que implemente StudentRepository.
 * - Reutilización: separa la lógica de negocio del almacenamiento, lo que permite
 *                  reutilizar este servicio con distintas bases de datos o repositorios.
 *
 * Responsabilidad:
 * - Validar los datos antes de crear o actualizar estudiantes.
 * - Llamar a los métodos CRUD del repositorio.
 * - Mostrar mensajes informativos al usuario.
 *
 * Nota:
 * Esta clase representa la "lógica de negocio" del programa.
 * No muestra menús ni imprime datos en consola, aunque en este ejemplo lo hace
 * para simplificar la demostración.
 */

import java.util.List;
public class StudentService {
    private StudentRepository repo;
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }
    // CREATE
    public Student register(String name, String email, double grade) {
        if (name == null || name.isBlank()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return null;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("Error: Email no válido.");
            return null;
        }
        if (grade < 0 || grade > 10) {
            System.out.println("Error: La nota debe estar entre 0 y 10.");
            return null;
        }
        Student s = new Student(name, email, grade);
        return repo.create(s);
    }
    // READ
    public Student getById(int id) {
        Student s = repo.findById(id);
        if (s == null) {
            System.out.println("No existe alumno con ID " + id);
        }
        return s;
    }
    public List<Student> listAll() {
        return repo.findAll();
    }
    // UPDATE
    public boolean update(Student student) {
        boolean ok = repo.update(student);
        if (!ok) System.out.println("Alumno no encontrado para actualizar.");
        return ok;
    }
    // DELETE
    public boolean delete(int id) {
        boolean ok = repo.deleteById(id);
        if (!ok) System.out.println("Alumno no encontrado para eliminar.");
        return ok;
    }
    public int count() {
        return repo.count();
    }
}
