package bal;

import dal.DAOFactory;
import dto.Course;
import dto.Hall;
import dto.Instructor;
import dto.Period;

/**
 * @author Ahmed Hassan
 * created on Dec 2, 2018
 * last edited on Dec 2, 2018
 */


public class AdminBAOImpl implements AdminBAO {
	DAOFactory dAOFactory = new DAOFactory();
	/**
	 * The following method "saveInstructor()" saves instructor data to database 
	 * it takes on parameter (Instructor object)
	 * it checks if the instructor exists before adding
	 */
	@Override
	public boolean saveInstructor(Instructor instructor) {
		if (dAOFactory.createInstructorDAO().exists(instructor))
			return false;
		else
			dAOFactory.createInstructorDAO().insert(instructor);
		return true;
	}

	
	/**
	 * The following method "saveCourse()" saves course data to database 
	 * it takes on parameter (Course object)
	 * it checks if the course exists before adding
	 */
	@Override
	public boolean saveCourse(Course course) {
		if (dAOFactory.createCourseDAO().exists(course))
			return false;
		else
			dAOFactory.createCourseDAO().insert(course);
		return true;
	}

	
	/**
	 * The following method "saveHall()" saves hall data to database 
	 * it takes on parameter (Hall object)
	 * it checks if the hall exists before adding
	 */
	@Override
	public boolean saveHall(Hall hall) {
		if (dAOFactory.createHallDAO().exists(hall))
			return false;
		else
			dAOFactory.createHallDAO().insert(hall);
		return true;
	}

	
	/**
	 * The following method "savePeriod()" saves period data to database 
	 * it takes on parameter (Period object)
	 * it checks if the period exists before adding
	 */
	@Override
	public boolean savePeriod(Period period) {
		if (dAOFactory.createPeriodDAO().exists(period))
			return false;
		else
			dAOFactory.createPeriodDAO().insert(period);
		return true;
	}

	
	/**
	 * The following method "deleteInstructor()" deletes instructor from database 
	 * it takes on parameter (Instructor object)
	 */
	@Override
	public boolean deleteInstructor(Instructor instructor) {
		dAOFactory.createInstructorDAO().delete(instructor);
		return true;
	}

	
	/**
	 * The following method "deleteCourse()" deletes course from database 
	 * it takes on parameter (Course object)
	 */
	@Override
	public boolean deleteCourse(Course course) {
		dAOFactory.createCourseDAO().delete(course);
		return true;
	}
	

	/**
	 * The following method "deleteHall()" deletes hall from database 
	 * it takes on parameter (Hall object)
	 */
	@Override
	public boolean deleteHall(Hall hall) {
		dAOFactory.createHallDAO().delete(hall);
		return true;
	}

	/**
	 * The following method "deletePeriod()" deletes period from database 
	 * it takes on parameter (Period object)
	 */
	@Override
	public boolean deletePeriod(Period period) {
		dAOFactory.createPeriodDAO().delete(period);
		return true;
	}

	
	/**
	 * The following method "updateInstructor()" updates instructor data in database 
	 * it takes on parameter (Instructor object)
	 */
	@Override
	public boolean updateInstructor(Instructor instructor) {
		dAOFactory.createInstructorDAO().update(instructor);
		return true;
	}

	
	/**
	 * The following method "updateCourse()" updates course data in database 
	 * it takes on parameter (Course object)
	 */
	@Override
	public boolean updateCourse(Course course) {
		dAOFactory.createCourseDAO().update(course);
		return true;
	}

	
	/**
	 * The following method "updateHall()" updates hall data in database 
	 * it takes on parameter (Hall object)
	 */
	@Override
	public boolean updateHall(Hall hall) {
		dAOFactory.createHallDAO().update(hall);
		return true;
	}

	
	/**
	 * The following method "updatePeriod()" updates period data in database 
	 * it takes on parameter (Period object)
	 */
	@Override
	public boolean updatePeriod(Period period) {
		dAOFactory.createPeriodDAO().update(period);
		return true;
	}
	
	

}
