/**
 * Clase: InMemoryStudentRepository
 *
 * Descripción:
 * Implementa la interfaz StudentRepository almacenando los datos en memoria
 * mediante una lista (ArrayList). Es una simulación sencilla de una base de datos.
 *
 * Principios POO aplicados:
 * - Polimorfismo: esta clase puede ser usada a través del tipo StudentRepository,
 *                 lo que permite sustituirla fácilmente por otra implementación (por ejemplo,
 *                 una basada en ficheros o base de datos).
 * - Abstracción: oculta los detalles del almacenamiento; el resto del programa no sabe
 *                cómo ni dónde se guardan los datos.
 * - Encapsulación: la lista interna de estudiantes está protegida y solo se manipula
 *                  mediante los métodos públicos definidos por la interfaz.
 *
 * Responsabilidad:
 * - Gestionar la colección de estudiantes en memoria.
 * - Asignar identificadores automáticos (id) a los nuevos registros.
 * - Ofrecer los métodos CRUD para crear, leer, actualizar y eliminar estudiantes.
 *
 * Limitación:
 * - Los datos se pierden al cerrar el programa, ya que no se guardan en disco.
 */

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository{
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Student create(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    @Override
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null; // Si no existe
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return students.size();
    }
}
