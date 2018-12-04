package Dal;

import DTO.AcademicDegree;
import DTO.Course;
import DTO.Department;
import DTO.Instructor;

import java.util.Collections;
import java.util.List;

public class InstructorDAOImpl implements InstructorDAO {
    public InstructorDAOImpl() {
        super();
    }

    @Override
    public Instructor getInstructor(String email) {
        // TODO Implement this method
        return null;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public List<Course> getInstructors(Department department) {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public List<Course> getInstructors(AcademicDegree academicDegree) {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public boolean insert(Instructor instructor) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean exists(Instructor instructor) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean update(Instructor instructor) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean delete(Instructor instructor) {
        // TODO Implement this method
        return false;
    }
}
