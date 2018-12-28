package bal.algorithm;
import dal.DAOFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dto.Instructor;
import dto.Preference;


/**
 * 
 * @author Ahmed Fayez
 * Created on 24/12/2018
 * This class provides some utils methods for processing preferences sorting
 */
public class PrefProcess {

	// Sort by rank method
	// create sorted prefs list
	
	/**
	 * Comparator for binding pref rank with instructor's position
	 * @param prefs
	 * @return
	 */
	public List<Preference> sortByRank(List<Preference> prefs){
		
		Comparator<Preference> rankOrder =  new Comparator<Preference>() {
			public int compare(Preference p1, Preference p2) {
				// Negative sign to sort in descending order as the natural order of date is ascending
				return -(p1.getRank().compareTo(p2.getRank()));
			}
		};
		
		Collections.sort(prefs, rankOrder);
		
		
		return prefs;
	}
	
	/**
	 * Sort preference where instructors' position is in lead
	 * @param prefs
	 * @return
	 */
public List<Preference> sortBySeniority(List<Preference> prefs) {
		
		Comparator<Preference> rankOrder =  new Comparator<Preference>() {
			
			public int compare(Preference p1, Preference p2) {
				
				 if ((p1.getInstructor().getAcademicDegree().compareTo((p2.getInstructor().getAcademicDegree())))==0) {
					 return -p1.getInstructor().getDateOfEmployment().compareTo(p2.getInstructor().getDateOfEmployment());
				 }
				 
				 else return -p1.getInstructor().getAcademicDegree().compareTo((p2.getInstructor().getAcademicDegree()));
					 
			}
		};
		
		Collections.sort(prefs, rankOrder);
		
		return prefs;
	}
	
	
	
}
