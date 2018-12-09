package 	com.fym.cse.dao;
import DTO.*;

import java.util.List;
import enums.*;
public interface InstructorDAO {


    public Instructor getInstructor(String email);
    public List<Instructor> getAllInstructors();
    public  List<Instructor> getInstructors(Department department);
    public  List<Instructor> getInstructors(AcademicDegree academicDegree);

    public boolean insert(Instructor instructor);
    public boolean exists(Instructor instructor);
    public boolean update(Instructor instructor);
    public boolean delete(Instructor instructor);


}
