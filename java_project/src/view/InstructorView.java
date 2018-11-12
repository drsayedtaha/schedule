package view;
import DTO.*;
import java.util.List;

public interface InstructorView {
    
    //  These methods will control the view of the instructor
    // Shows the instrucotr available courses,periods and their past preferences
    
    public void viewCourses (List<Course> courses);
    public void viewPeriods (List<Period> periods);
    public void viewPreferences (List<Preference> preferences);
    
}
