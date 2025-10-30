import java.util.List;

public interface CourseRepository {
    Course create(Course c);
    Course findById(int id);
    List<Course> findAll();
    boolean update(Course c);
    boolean deleteById(int id);
    int count();
}

