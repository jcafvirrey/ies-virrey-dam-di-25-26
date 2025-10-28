/**
 * Clase: Student
 * Descripción:
 * Representa el modelo de datos de un estudiante dentro del sistema.
 * Contiene atributos privados (encapsulación) y métodos públicos para acceder
 * y modificar su información de forma controlada mediante getters y setters.
 *
 * Principios POO aplicados:
 * - Encapsulación: los datos están protegidos y solo se accede a ellos mediante métodos.
 * - Reutilización: puede usarse en cualquier otro programa que gestione estudiantes.
 *
 * Responsabilidad:
 * - Almacenar los datos de un estudiante (id, nombre, email, nota).
 * - Proporcionar métodos para consultarlos y modificarlos.
 *
 * Esta clase no realiza ninguna lógica de negocio ni guarda los datos por sí misma.
 * Su única función es representar la información (modelo).
 */

public class Student {
    private int id;
    private String name;
    private String email;
    private double grade;

    public Student(int id, String name, String email, double grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    // Constructor para crear sin ID (el repositorio lo asigna)
    public Student(String name, String email, double grade) {
        this(0, name, email, grade);
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getGrade() { return grade; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setGrade(double grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | " + email + " | Nota: " + grade;
    }
}

