package bal;
/*
 * Author: Mohamed Osama
 * Created on Dec 12, 2018
 * Last edited on 3/12/208
 */

import java.util.List;

import dto.*;


public interface InstructorBAO {
    

    // These methods for returning previously-created courses,periods and preference from database
        public List<Course> getCourses();
    public List<Period> getPeriods();
    public List<Preference> getPreferences();
    /* these methods for access on courses, periods and preferences to save all of them or update
     if they are found or delete any one of them. */
    public boolean saveCourse(Course course);
    public boolean updateCourse (Course course);
    public boolean deleteCourse(Course course);
    public boolean savePeriod(Period period);
    public boolean updatePeriod(Period period);
    public boolean deletePeriod(Period period);
    public boolean savePreference(Preference preference);

    

}
