package 	Dal;
import DTO.*;

import java.util.List;

public interface InstructorDAO {


    public Instructor getInstructor(String email);
    public List<Instructor> getAllInstructors();
    public abstract List<Course> getInstructors(Department department);
    public abstract List<Course> getInstructors(AcademicDegree academicDegree);

    public boolean insert(Instructor instructor);
    public boolean exists(Instructor instructor);
    public boolean update(Instructor instructor);
    public boolean delete(Instructor instructor);


}
