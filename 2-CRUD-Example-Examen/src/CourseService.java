import java.util.List;

public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Course register(String title, int hours, String modality) {
        if (title == null || title.isBlank()) {
            System.out.println("Error: el título no puede estar vacío.");
            return null;
        }
        if (hours <= 0) {
            System.out.println("Error: las horas deben ser > 0.");
            return null;
        }
        if (modality == null) {
            System.out.println("Error: modalidad requerida.");
            return null;
        }
        String m = modality.trim().toUpperCase();
        if (!m.equals("ONLINE") && !m.equals("PRESENTIAL")) {
            System.out.println("Error: modalidad debe ser ONLINE o PRESENTIAL.");
            return null;
        }
        return repo.create(new Course(title.trim(), hours, m));
    }

    public Course getById(int id) {
        Course c = repo.findById(id);
        if (c == null) System.out.println("Aviso: no existe curso con id " + id);
        return c;
    }

    public List<Course> listAll() {
        return repo.findAll();
    }

    public boolean update(Course c) {
        if (c == null || c.getId() <= 0) {
            System.out.println("Error: curso inválido para actualizar.");
            return false;
        }
        // Validaciones mínimas en update
        if (c.getTitle() == null || c.getTitle().isBlank()) {
            System.out.println("Error: título vacío.");
            return false;
        }
        if (c.getHours() <= 0) {
            System.out.println("Error: horas deben ser > 0.");
            return false;
        }
        String m = c.getModality();
        if (m == null) {
            System.out.println("Error: modalidad requerida.");
            return false;
        }
        m = m.trim().toUpperCase();
        if (!m.equals("ONLINE") && !m.equals("PRESENTIAL")) {
            System.out.println("Error: modalidad debe ser ONLINE o PRESENTIAL.");
            return false;
        }
        c.setModality(m);
        boolean ok = repo.update(c);
        if (!ok) System.out.println("Aviso: no se encontró el curso para actualizar (id=" + c.getId() + ")");
        return ok;
    }

    public boolean delete(int id) {
        boolean ok = repo.deleteById(id);
        if (!ok) System.out.println("Aviso: no se encontró el curso para eliminar (id=" + id + ")");
        return ok;
    }

    public int count() {
        return repo.count();
    }
}

