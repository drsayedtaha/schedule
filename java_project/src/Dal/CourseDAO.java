package 	Dal;
import DTO.*;


import java.util.List;

public interface CourseDAO {

    public abstract List<Course> getAllCourses();
    public abstract Course getCourse(String code);

    public abstract List<Course> getCourses(Department department);
    public abstract List<Course> getCourses(Grade grade);
    public abstract List<Course> getCourses(Division division);


    public boolean insert(Course course);
    public boolean exists(Course course);
    public boolean update(Course course);
    public boolean delete(Course course);
}
