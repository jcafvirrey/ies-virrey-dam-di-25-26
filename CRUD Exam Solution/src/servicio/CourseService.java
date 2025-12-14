package servicio;

import modelo.Course;
import repositorio.Storage;

import java.util.List;

/**
 * CAPA DE SERVICIO: CourseService
 *
 * - Responsabilidad: validar datos y coordinar operaciones antes de llamar al almacenamiento.
 * - DIP: depende de la interfaz Storage<Course>, no de una implementación concreta.
 * - Esto permite cambiar Memoria/Fichero/SQL sin modificar el servicio.
 *
 * Para la rúbrica:
 * - Validaciones básicas
 * - CRUD coherente y mensajes claros
 */
public class CourseService {

    private final Storage<Course> storage;

    public CourseService(Storage<Course> storage) {
        this.storage = storage;
    }

    // CREATE (alta)
    public Course create(String title, int hours, String modality) {
        String normalized = validateAndNormalize(title, hours, modality);
        if (normalized == null) return null;
        return storage.create(new Course(title.trim(), hours, normalized));
    }

    // READ
    public Course findById(int id) {
        Course c = storage.findById(id);
        if (c == null) {
            System.out.println("Aviso: no existe curso con id " + id);
        }
        return c;
    }

    public List<Course> findAll() {
        return storage.findAll();
    }

    // UPDATE
    public boolean update(int id, String title, int hours, String modality) {
        Course existing = storage.findById(id);
        if (existing == null) {
            System.out.println("Aviso: no existe curso con id " + id + " para actualizar.");
            return false;
        }

        String normalized = validateAndNormalize(title, hours, modality);
        if (normalized == null) return false;

        Course updated = new Course(id, title.trim(), hours, normalized);
        boolean ok = storage.update(updated);
        if (!ok) System.out.println("Aviso: no se pudo actualizar (id=" + id + ")");
        return ok;
    }

    // DELETE
    public boolean delete(int id) {
        boolean ok = storage.deleteById(id);
        if (!ok) System.out.println("Aviso: no existe curso con id " + id + " para eliminar.");
        return ok;
    }

    public int count() {
        return storage.count();
    }

    /**
     * Validación mínima para el examen:
     * - title no vacío
     * - hours > 0
     * - modality debe ser ONLINE o PRESENTIAL (normalizamos a mayúsculas)
     */
    private String validateAndNormalize(String title, int hours, String modality) {
        if (title == null || title.isBlank()) {
            System.out.println("Error: el título no puede estar vacío.");
            return null;
        }
        if (hours <= 0) {
            System.out.println("Error: las horas deben ser mayores que 0.");
            return null;
        }
        if (modality == null || modality.isBlank()) {
            System.out.println("Error: la modalidad es obligatoria (ONLINE/PRESENTIAL).");
            return null;
        }
        String m = modality.trim().toUpperCase();
        if (!m.equals("ONLINE") && !m.equals("PRESENTIAL")) {
            System.out.println("Error: modalidad inválida. Usa ONLINE o PRESENTIAL.");
            return null;
        }
        return m;
    }
}
