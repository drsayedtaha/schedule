package bal;

import dto.Course;
import dal.DAOFactory;



public class CourseBAOImpl implements CourseBAO {

	DAOFactory dAOFactory = new DAOFactory();
	
	
	public boolean saveCourse(Course course) {
		// if ( factory.createHallDAO().exists(hall))
					return dAOFactory.createCourseDAO().insert(course);
				 
				 //else
				//	 return factory.createHallDAO().update(hall);
					 
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
