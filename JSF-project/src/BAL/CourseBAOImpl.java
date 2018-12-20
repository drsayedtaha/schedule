package bal;

import dto.Course;
import dal.DAOFactory;



public class CourseBAOImpl implements CourseBAO {

	DAOFactory dAOFactory = new DAOFactory();
	
	
	public boolean saveCourse(Course course) {
		if (dAOFactory.createCourseDAO().exists(course))

			return false;

		else

			dAOFactory.createCourseDAO().insert(course);
		return true;
	}
	
    public boolean updateCourse (Course course){
		dAOFactory.createCourseDAO().update(course);
		return true;
	}
    
    
    
    public boolean deleteCourse(Course course) {
		dAOFactory.createCourseDAO().delete(course);
		return true;
	}
	
}
