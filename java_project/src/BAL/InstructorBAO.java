package BAL;
import DTO.*;
import java.util.List;

public interface InstructorBAO {
    
    // These method for returning previously-created courses,periods from database 
    
    public List<Course> getCourses();
    public List<Period> getPeriods();
    public List<Preference> getPreferences();
    
    public boolean insertPreference();
    public boolean updatePreference();
    public boolean deletePreference();
    
    
    
    
}
