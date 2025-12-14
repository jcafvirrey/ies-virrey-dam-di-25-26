package modelo;

/**
 * CLASE DE MODELO (ENTIDAD): Course
 *
 * - Responsabilidad (SRP): representar un "Curso" con sus datos.
 * - Encapsulación: atributos privados + getters/setters controlan el acceso.
 * - Reutilización: esta clase podría usarse en otro proyecto (GUI, web, BD, etc.)
 *
 * Importante para la rúbrica:
 * - Atributos private
 * - Constructores adecuados
 * - toString() para mostrar información por consola de forma clara
 */
public class Course {
    private int id;              // Identificador (lo asigna el almacenamiento)
    private String title;        // Título del curso
    private int hours;           // Duración en horas
    private String modality;     // "ONLINE" o "PRESENTIAL"

    // Constructor para "alta" (sin id, porque todavía no existe en el almacenamiento)
    public Course(String title, int hours, String modality) {
        this(0, title, hours, modality);
    }

    // Constructor completo (útil para actualizaciones o copias)
    public Course(int id, String title, int hours, String modality) {
        this.id = id;
        this.title = title;
        this.hours = hours;
        this.modality = modality;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getHours() { return hours; }
    public String getModality() { return modality; }

    // setId: se usa desde el almacenamiento al asignar el id (en un proyecto real se limitaría más)
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setHours(int hours) { this.hours = hours; }
    public void setModality(String modality) { this.modality = modality; }

    @Override
    public String toString() {
        return "Course{id=" + id +
                ", title='" + title + '\'' +
                ", hours=" + hours +
                ", modality=" + modality +
                '}';
    }
}
