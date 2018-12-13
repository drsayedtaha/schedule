package bal;

import java.util.List;

import dto.Instructor;
import dto.Preference;

public interface PreferenceBAO {

	public List<Preference> getPreferences();
	public List<Preference> getPreferences(Instructor instructor);
	
	public boolean savePreference(Instructor instructor);
	
	
}
