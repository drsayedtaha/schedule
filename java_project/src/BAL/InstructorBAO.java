package BAL;
import DTO.*;
import java.util.List;

public interface InstructorBAO {
    
    public boolean exists();
    
    
    // These method for returning previously-created courses,periods from database 
    
    public List<Course> getCourses();
    public List<Period> getPeriods();
    public List<Preference> getPreferences();
    
    public boolean insertPreference(Preference preference);
    public boolean updatePreference(Preference preference);
    public boolean deletePreference(Preference preference);
    
    
    
    
}
