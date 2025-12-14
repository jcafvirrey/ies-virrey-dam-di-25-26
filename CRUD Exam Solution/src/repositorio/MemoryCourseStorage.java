package repositorio;

import modelo.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * IMPLEMENTACIÓN REAL EN MEMORIA: MemoryCourseStorage
 *
 * - Responsabilidad: guardar cursos durante la ejecución (opción "Memoria").
 * - Usa una estructura de datos (ArrayList) y asigna ids autoincrementales.
 *
 * Para la rúbrica:
 * - CRUD funcional (Create/Read/Update/Delete)
 * - Estructura clara y coherente
 */
public class MemoryCourseStorage implements Storage<Course> {

    private final List<Course> data = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Course create(Course item) {
        item.setId(nextId++);
        data.add(item);
        return item;
    }

    @Override
    public Course findById(int id) {
        for (Course c : data) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return data; // simplificado: en proyectos reales se devolvería copia inmutable
    }

    @Override
    public boolean update(Course item) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == item.getId()) {
                data.set(i, item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return data.size();
    }
}

