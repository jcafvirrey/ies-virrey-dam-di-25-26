import java.util.List;
public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new InMemoryStudentRepository();
        StudentService service = new StudentService(repo);

        System.out.println("=== CREAR ALUMNOS ===");
        service.register("Laura", "laura@example.com", 8.5);
        service.register("Carlos", "carlos@example.com", 7.2);
        service.register("Sofía", "sofia@example.com", 9.1);

        System.out.println("\n=== LISTAR ALUMNOS ===");
        print(service.listAll());

        System.out.println("\n=== BUSCAR POR ID ===");
        Student s = service.getById(2);
        if (s != null) System.out.println("Encontrado: " + s);

        System.out.println("\n=== ACTUALIZAR ===");
        if (s != null) {
            s.setGrade(8.0);
            service.update(s);
        }
        print(service.listAll());

        System.out.println("\n=== ELIMINAR ===");
        service.delete(1);
        print(service.listAll());

        System.out.println("\nTotal de alumnos: " + service.count());
    }

    private static void print(List<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
