package Dal;

import DTO.Course;
import DTO.Instructor;
import DTO.Period;
import DTO.Preference;

import java.sql.Connection;

import java.util.List;

public abstract class InstructorDAOImpl {
    
    public abstract boolean exists(Instructor instructor);
    
    public abstract List<Course> getCourses();
    public abstract List<Period> getPeriods();
    public abstract List<Preference> getPreferences();
    
    public abstract boolean insertPreference(Preference preference);
    public abstract boolean updatePreference(Preference preference);
    public abstract boolean deletePreference(Preference preference); 
    
    
    
}
