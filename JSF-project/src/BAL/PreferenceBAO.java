package bal;

import dto.Instructor;


public interface PreferenceBAO {

	
	
	public boolean savePreference(Instructor instructor);
	public boolean updatePreference(Instructor instructor);
	public boolean deletePreference(Instructor instructor);

	
	
}
