package bal;

import dto.*;

public interface CourseBAO {


	
	public boolean saveCourse(Course course);
    public boolean updateCourse (Course course);
    public boolean deleteCourse(Course course);
	
}
