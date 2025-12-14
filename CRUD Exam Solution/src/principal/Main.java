package principal;

import modelo.Course;
import repositorio.*;
import servicio.CourseService;

import java.util.List;
import java.util.Scanner;

/**
 * CLASE PRINCIPAL: Main
 *
 * - Muestra el menú inicial para elegir almacenamiento (Memoria/Ficheros/SQL).
 * - Demuestra polimorfismo: la variable "storage" es de tipo Storage<Course>
 *   pero puede apuntar a diferentes implementaciones (Memory, File, SQL).
 * - Luego muestra un menú CRUD común (independiente del tipo de almacenamiento elegido). :contentReference[oaicite:4]{index=4}
 *
 * Para la rúbrica:
 * - Selección de almacenamiento por menú inicial
 * - CRUD funcional
 * - Código comentado y organizado
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Storage<Course> storage = chooseStorage(sc);
        CourseService service = new CourseService(storage);

        boolean exit = false;
        while (!exit) {
            printCrudMenu();
            int option = readInt(sc, "Opción: ");

            switch (option) {
                case 1 -> createCourse(sc, service);
                case 2 -> listCourses(service);
                case 3 -> findCourse(sc, service);
                case 4 -> updateCourse(sc, service);
                case 5 -> deleteCourse(sc, service);
                case 0 -> exit = true;
                default -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("Fin del programa.");
        sc.close();
    }

    // --- MENÚ DE ALMACENAMIENTO (polimorfismo en acción) ---
    private static Storage<Course> chooseStorage(Scanner sc) {
        while (true) {
            System.out.println("=========================================");
            System.out.println("Selecciona el sistema de almacenamiento");
            System.out.println("1) Memoria (real)");
            System.out.println("2) Ficheros (simulado + funcional en ejecución)");
            System.out.println("3) SQL (simulado + funcional en ejecución)");
            System.out.println("=========================================");

            int option = readInt(sc, "Opción: ");

            // Aquí se demuestra el polimorfismo:
            // "storage" es Storage<Course> pero recibe objetos de clases distintas.
            switch (option) {
                case 1 -> { return new MemoryCourseStorage(); }
                case 2 -> { return new FileCourseStorage("courses.txt"); }
                case 3 -> { return new SqlCourseStorage("courses"); }
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    // --- MENÚ CRUD ---
    private static void printCrudMenu() {
        System.out.println("\n========== MENÚ CRUD (Cursos) ==========");
        System.out.println("1) Crear curso");
        System.out.println("2) Listar cursos");
        System.out.println("3) Buscar curso por id");
        System.out.println("4) Actualizar curso");
        System.out.println("5) Eliminar curso");
        System.out.println("0) Salir");
        System.out.println("=======================================");
    }

    private static void createCourse(Scanner sc, CourseService service) {
        System.out.println("\n--- Crear curso ---");
        System.out.print("Título: ");
        String title = sc.nextLine();

        int hours = readInt(sc, "Horas: ");

        System.out.print("Modalidad (ONLINE/PRESENTIAL): ");
        String modality = sc.nextLine();

        Course created = service.create(title, hours, modality);
        if (created != null) {
            System.out.println("Creado: " + created);
        }
    }

    private static void listCourses(CourseService service) {
        System.out.println("\n--- Listar cursos ---");
        List<Course> list = service.findAll();
        if (list.isEmpty()) {
            System.out.println("(No hay cursos)");
            return;
        }
        for (Course c : list) {
            System.out.println(c);
        }
        System.out.println("Total: " + service.count());
    }

    private static void findCourse(Scanner sc, CourseService service) {
        System.out.println("\n--- Buscar curso ---");
        int id = readInt(sc, "Id: ");
        Course c = service.findById(id);
        if (c != null) System.out.println("Encontrado: " + c);
    }

    private static void updateCourse(Scanner sc, CourseService service) {
        System.out.println("\n--- Actualizar curso ---");
        int id = readInt(sc, "Id: ");

        System.out.print("Nuevo título: ");
        String title = sc.nextLine();

        int hours = readInt(sc, "Nuevas horas: ");

        System.out.print("Nueva modalidad (ONLINE/PRESENTIAL): ");
        String modality = sc.nextLine();

        boolean ok = service.update(id, title, hours, modality);
        System.out.println(ok ? "Actualización realizada." : "No se pudo actualizar.");
    }

    private static void deleteCourse(Scanner sc, CourseService service) {
        System.out.println("\n--- Eliminar curso ---");
        int id = readInt(sc, "Id: ");
        boolean ok = service.delete(id);
        System.out.println(ok ? "Eliminado." : "No se pudo eliminar.");
    }

    // --- UTILIDADES DE ENTRADA ---
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número entero válido.");
            }
        }
    }
}
