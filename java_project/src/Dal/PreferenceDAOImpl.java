package Dal;
import java.util.List;
import java.sql.*;

import DTO.Course;
import DTO.Instructor;
import DTO.Preference;
/**
 * 
 * @author Ahmed Fayez
 * Launched on 1st of December 2018
 */
public class PreferenceDAOImpl implements PreferenceDAO {

	Connection conn = DBUtils.getConnection();
	
	@Override
	public List<Preference> getPreferences(Instructor instructor) {
		// TODO 
		return null;
	}

	@Override
	public List<Preference> getPreferences(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Preference preference) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Preference preference) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Preference preference) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Preference preference) {
		// TODO Auto-generated method stub
		return false;
	}

}
