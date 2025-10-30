import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseRepository repo = new InMemoryCourseRepository();
        CourseService service = new CourseService(repo);

        System.out.println("== CREATE ==");
        Course c1 = service.register("Java Fundamentals", 60, "online");
        Course c2 = service.register("Web Development", 40, "PRESENTIAL");
        Course c3 = service.register("Databases", 50, "presential"); // se normaliza a PRESENTIAL?
        // El servicio invalidará "presential" si no coincide exactamente (lo normaliza arriba).
        // En esta solución lo normalizamos a mayúsculas y validamos esos dos valores.

        System.out.println("\n== LIST ALL ==");
        print(service.listAll());

        System.out.println("\n== READ BY ID ==");
        Course found = service.getById(2);
        if (found != null) System.out.println("Encontrado: " + found);
        service.getById(999); // inexistente

        System.out.println("\n== UPDATE ==");
        if (found != null) {
            found.setHours(45);
            found.setModality("ONLINE");
            service.update(found);
        }
        print(service.listAll());

        System.out.println("\n== DELETE ==");
        service.delete(1);
        print(service.listAll());

        System.out.println("\nTotal cursos: " + service.count());
    }

    private static void print(List<Course> list) {
        for (Course c : list) System.out.println(c);
    }
}

