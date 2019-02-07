package bal;

import dto.Course;

public interface CourseBAO {


	
    public boolean saveCourse(Course course);
    public boolean updateCourse (Course course);
    public boolean deleteCourse(Course course);
	
}
