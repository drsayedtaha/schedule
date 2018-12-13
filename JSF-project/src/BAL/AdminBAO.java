package bal;
import dto.*;


public interface AdminBAO {

    
    public boolean saveInstructor(Instructor instructor);
    public boolean saveCourse(Course course);
    public boolean saveHall(Hall hall);
    public boolean savePeriod(Period period);

    public boolean deleteInstructor(Instructor instructor);
    public boolean deleteCourse(Course course);
    public boolean deleteHall(Hall hall);
    public boolean deletePeriod(Period period);

    public boolean updateInstructor(Instructor instructor);
    public boolean updateCourse(Course course);
    public boolean updateHall(Hall hall);
    public boolean updatePeriod(Period period);


}
