package BAL;
import DTO.*;
import view.*;
import view.InstructorView;


public interface AdminBAO {
    
    AdminOperations viewAccessObject;
    
    // These methods' parameter are gotten throught the AdminOperations view object
    // Example: viewAccessObject.getInstructor
    
    public boolean insertInstructor(Instructor instructor);
    public boolean insertCourse(Course course);
    public boolean insertHall(Hall hall);
    public boolean insertPeriod(Period period);

    public boolean updateInstructor(Instructor instructor);
    public boolean updateCourse(Course course);
    public boolean updateHall(Hall hall);
    public boolean updatePeriod(Period period);
    
    public boolean deleteInstructor(Instructor instructor);
    public boolean deleteCourse(Course course);
    public boolean deleteHall(Hall hall);
    public boolean deletePeriod(Period period);
    
    
    
}
