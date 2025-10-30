import java.util.ArrayList;
import java.util.List;

public class InMemoryCourseRepository implements CourseRepository {
    private final List<Course> data = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Course create(Course c) {
        c.setId(nextId++);
        data.add(c);
        return c;
    }

    @Override
    public Course findById(int id) {
        for (Course c : data) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return data; // simple; en producción devolver copia
    }

    @Override
    public boolean update(Course c) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == c.getId()) {
                data.set(i, c);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return data.size();
    }
}

