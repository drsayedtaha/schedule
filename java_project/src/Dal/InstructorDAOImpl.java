package Dal;

import DTO.Course;
import DTO.Period;
import DTO.Preference;

import java.sql.Connection;

import java.util.List;

public abstract class InstructorDAOImpl {
    
    public abstract List<Course> getCourses();
    public abstract List<Period> getPeriods();
    public abstract List<Preference> getPreferences();
    
    public abstract boolean insertPreference();
    public abstract boolean updatePreference();
    public abstract boolean deletePreference(); 
    
    
    
}
