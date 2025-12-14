package repositorio;

import modelo.Course;

import java.util.List;

/**
 * IMPLEMENTACIÓN SIMULADA: FileCourseStorage
 *
 * - El enunciado permite SIMULAR ficheros con mensajes por consola. :contentReference[oaicite:2]{index=2}
 * - Para que el CRUD funcione "independientemente del almacenamiento", esta clase:
 *   1) imprime mensajes como si trabajara con un fichero
 *   2) delega en un almacenamiento real en memoria (composición)
 *
 * Esto demuestra:
 * - Abstracción: cumple Storage<Course> como cualquier otra implementación.
 * - Reutilización: reutiliza la lógica real del almacenamiento en memoria.
 */
public class FileCourseStorage implements Storage<Course> {

    private final Storage<Course> realStorage;
    private final String fileName;

    public FileCourseStorage(String fileName) {
        this.fileName = fileName;
        this.realStorage = new MemoryCourseStorage(); // soporte real para que el CRUD funcione
    }

    @Override
    public Course create(Course item) {
        System.out.println("[FICHERO] Guardando en " + fileName + " ... (simulación)");
        return realStorage.create(item);
    }

    @Override
    public Course findById(int id) {
        System.out.println("[FICHERO] Leyendo id=" + id + " de " + fileName + " ... (simulación)");
        return realStorage.findById(id);
    }

    @Override
    public List<Course> findAll() {
        System.out.println("[FICHERO] Leyendo todos los cursos de " + fileName + " ... (simulación)");
        return realStorage.findAll();
    }

    @Override
    public boolean update(Course item) {
        System.out.println("[FICHERO] Actualizando id=" + item.getId() + " en " + fileName + " ... (simulación)");
        return realStorage.update(item);
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("[FICHERO] Eliminando id=" + id + " de " + fileName + " ... (simulación)");
        return realStorage.deleteById(id);
    }

    @Override
    public int count() {
        return realStorage.count();
    }
}
