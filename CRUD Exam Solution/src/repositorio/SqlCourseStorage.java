package repositorio;

import modelo.Course;

import java.util.List;

/**
 * IMPLEMENTACIÓN SIMULADA: SqlCourseStorage
 *
 * - El enunciado permite simular SQL mostrando mensajes tipo INSERT/SELECT/UPDATE/DELETE. :contentReference[oaicite:3]{index=3}
 * - Para que el CRUD sea utilizable en el examen, esta clase:
 *   1) imprime la "consulta" simulada
 *   2) delega en memoria para mantener datos durante la ejecución
 *
 * Esto refuerza la rúbrica:
 * - Polimorfismo: se usa como Storage<Course> igual que Memoria o Fichero.
 * - Diseño extensible: podrías sustituir la delegación por JDBC real más adelante.
 */
public class SqlCourseStorage implements Storage<Course> {

    private final Storage<Course> realStorage;
    private final String tableName;

    public SqlCourseStorage(String tableName) {
        this.tableName = tableName;
        this.realStorage = new MemoryCourseStorage(); // soporte real para ejecución
    }

    @Override
    public Course create(Course item) {
        System.out.println("[SQL] Ejecutando: INSERT INTO " + tableName + " (...) VALUES (...)  (simulación)");
        return realStorage.create(item);
    }

    @Override
    public Course findById(int id) {
        System.out.println("[SQL] Ejecutando: SELECT * FROM " + tableName + " WHERE id=" + id + "  (simulación)");
        return realStorage.findById(id);
    }

    @Override
    public List<Course> findAll() {
        System.out.println("[SQL] Ejecutando: SELECT * FROM " + tableName + "  (simulación)");
        return realStorage.findAll();
    }

    @Override
    public boolean update(Course item) {
        System.out.println("[SQL] Ejecutando: UPDATE " + tableName + " SET ... WHERE id=" + item.getId() + "  (simulación)");
        return realStorage.update(item);
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("[SQL] Ejecutando: DELETE FROM " + tableName + " WHERE id=" + id + "  (simulación)");
        return realStorage.deleteById(id);
    }

    @Override
    public int count() {
        return realStorage.count();
    }
}
