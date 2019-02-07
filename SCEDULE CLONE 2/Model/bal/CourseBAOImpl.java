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
		if(dAOFactory.createCourseDAO().update(course))
		return true;
                else 
                return false;
	}
    
    
    
    public boolean deleteCourse(Course course) {
		if(dAOFactory.createCourseDAO().delete(course))
		return true;
                else
                return false;
	}

	
}
