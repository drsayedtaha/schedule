package 	Dal;
import DTO.*;
import java.util.List;


public interface PreferenceDAO {

    public List<Preference> getPreferences(Instructor instructor);
    public List<Preference> getPreferences(Course course);

    public boolean exists(Preference preference);
    public boolean insert(Preference preference);
    public boolean update(Preference preference);
    public boolean delete(Preference preference);

}
