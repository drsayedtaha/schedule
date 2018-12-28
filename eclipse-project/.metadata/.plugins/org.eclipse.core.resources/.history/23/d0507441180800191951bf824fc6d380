package view;
import java.util.List;

import javax.annotation.PostConstruct;

import bal.algorithm.PrefProcess;
import dal.DAOFactory;
import dto.Preference;


public class ScheduleBean {
	List<Preference> sortedPrefList;

	@PostConstruct
	public void init() {
		try {
		
		DAOFactory dbfactory = new DAOFactory();
		sortedPrefList = dbfactory.createPreferenceDAO().getAllPreferences();
		
		sortedPrefList = new PrefProcess().sortBySeniority(sortedPrefList);
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Preference> getSortedPrefList() {
		return sortedPrefList;
	}

	public void setSortedPrefList(List<Preference> sortedPrefList) {
		this.sortedPrefList = sortedPrefList;
	}
	
	
}
