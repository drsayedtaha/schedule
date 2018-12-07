package Dal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import DTO.Course;
import DTO.Instructor;
import DTO.Period;
import DTO.Preference;
import utils.DBUtils;


/**
 * @author Ahmed Hassan
 * created on Dec2, 2018
 * last edited on Dec 3, 2018
 */


public class PreferenceDAOImpl implements PreferenceDAO {
	
	
	/**
	 * The following method "getPreferences()" gets all Preferences of one instructor
	 * And takes one parameter (Instructor object)
	 */
	@Override
	public List<Preference> getPreferences(Instructor instructor) {
		List<Preference> prefrences = new ArrayList<Preference>();
		Preference prefrence = new Preference();
		Course course  = new Course();
		Period period = new Period();
		DAOFactory dAOFactory = new DAOFactory();
		try {
			String sql = "SELECT * FROM SCHEDULE.Prefrences WHERE USER_ID = ?";
			Connection connection = DBUtils.getConnection();
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, instructor.getId().toString());
			ResultSet result = pstatement.executeQuery();
		while(result.next()) {
			String courseID = result.getString("COURSE_ID");
			String periodID = result.getString("PERIOD_ID");
			Integer rank = result.getInt("RANK");
			course = dAOFactory.createCourseDAO().getCourse(courseID);
			period = dAOFactory.createPeriodDAO().getPeriod(periodID);
			prefrence.setCourse(course);
			prefrence.setPeriod(period);
			prefrence.setRank(rank);
			prefrence.setInstructor(instructor);
			prefrences.add(prefrence);
			}
		connection.close();
		pstatement.close();
		result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return prefrences;
	}

	
	/**
	 * The following method "getPreferences()" gets all Preferences of one course
	 * And takes one parameter (Course object)
	 */
	@Override
	public List<Preference> getPreferences(Course course) {
		List<Preference> prefrences = new ArrayList<Preference>();
		Preference prefrence = new Preference();
		Instructor instructor  = new Instructor();
		Period period = new Period();
		DAOFactory dAOFactory = new DAOFactory();
		try {
			String sql = "SELECT * FROM SCHEDULE.Prefrences WHERE COURSE_ID = ?";
			Connection connection = DBUtils.getConnection();
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, course.getiD().toString());
			ResultSet result = pstatement.executeQuery();
		while(result.next()) {
			String instructorID = result.getString("INSTRUCTOR_ID");
			String periodID = result.getString("PERIOD_ID");
			Integer rank = result.getInt("RANK");
			instructor = dAOFactory.createInstructorDAO().getInstructor(instructorID);
			period = dAOFactory.createPeriodDAO().getPeriod(periodID);
			prefrence.setCourse(course);
			prefrence.setPeriod(period);
			prefrence.setRank(rank);
			prefrence.setInstructor(instructor);
			prefrences.add(prefrence);
			}
		connection.close();
		pstatement.close();
		result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return prefrences;
	}

	
	/**
	 * The following method adds the preferences of the instructor to database
	 * before adding it deletes the old preferences
	 * it takes on parameter (List of Preference")
	 */
	@Override
	public boolean insert(List<Preference> preferences) {
		delete(preferences.get(0).getInstructor());
		try {
			Connection connection = DBUtils.getConnection();
			for (int i = 0; i < preferences.size(); i++) {
				String sql = "INSERT INTO SCHEDULE.Preferences(USER_ID, COURSE_ID, PERIOD_ID, RANK) VALUES (?, ?, ?, ?)";
				PreparedStatement pstatement = connection.prepareStatement(sql);
				pstatement.setString(1, preferences.get(i).getInstructor().getId().toString());
				pstatement.setString(2, preferences.get(i).getCourse().getID().toString());
				pstatement.setString(3, preferences.get(i).getPeriod().getID().toString());
				pstatement.setString(4, preferences.get(i).getRank().toString());
				pstatement.executeQuery();
				pstatement.close();
			}
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * The following method "delete()" deletes the old preferences of the instructor
	 * it takes one parameter (Instructor object)
	 */
	@Override
	public boolean delete(Instructor instructor) {
		try {
			Connection connection = DBUtils.getConnection();
			String sql = "DELETE FROM SCHEDULE.Preferences WHERE USER_ID = ?";
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, instructor.getId().toString());
			pstatement.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
