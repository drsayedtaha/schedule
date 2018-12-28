package bal.algorithm.unit.tests;

import bal.algorithm.PrefProcess;
import dal.DAOFactory;
import dto.Preference;
import utils.DateUtils;

import java.util.List;
public class PrefUnitTest {

	
	public static void main(String[] args) {
		
		DAOFactory factory = new DAOFactory();
		List<Preference> prefs = factory.createPreferenceDAO().getAllPreferences();
		
		List<Preference> sortedPrefsByRank = new PrefProcess().sortByRank(prefs);
		
		
		for(int i=0;i<sortedPrefsByRank.size();i++) {
			System.out.println("Name: " + sortedPrefsByRank.get(i).getInstructor().getFullName()
					+" || Course: " +sortedPrefsByRank.get(i).getCourse().getName());
		
		}
		
	}
	
}
