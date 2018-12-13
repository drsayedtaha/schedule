package bal;
import java.util.List;

import dto.*;
import enums.*;
public interface CourseBAO {

	public List<Course> getCourses();
	public List<Course> getCourses(Instructor instructor);
	public List<Course> getCourses(Department department);
	
	public boolean saveCourse(Course course);
    public boolean updateCourse (Course course);
    public boolean deleteCourse(Course course);
	
}
