package bal.algorithm;
import dto.Preference;
import dal.DAOFactory;
import java.util.List;
import dto.Hall;


public class ScheduleContainer {
	
	private List<Preference> finalSortedPrefs;
	private Hall hall;
	
	public List<Preference> getFinalSortedPrefs() {
		return finalSortedPrefs;
	}
	public void setFinalSortedPrefs(List<Preference> finalSortedPrefs) {
		this.finalSortedPrefs = finalSortedPrefs;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	
	
	

}
