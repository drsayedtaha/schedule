package view;
import java.util.List;
import dal.DAOFactory;
import dto.Instructor;
import dto.Preference;
public class MainTest {
	
	
	
	
	public static void main(String[] args) {
		try {
		 List<Preference> prefList = null;
		 List<Instructor> insts = null;
		 
		DAOFactory dbfactory = new DAOFactory();
		// prefList = dbfactory.createPreferenceDAO().getAllPreferences();
		insts = dbfactory.createInstructorDAO().getAllInstructors();
		
		/*
		for(int i=0;i<prefList.size();i++) {
			System.out.println("course name: " + prefList.get(i).getCourse().getName());
			System.out.println("instr name"+prefList.get(i).getInstructor().getFullName());
			System.out.println("rank: " +prefList.get(i).getRank());
		
		}
		*/
		
		for(int i=0;i<insts.size();i++) {
			System.out.println("Name: " + insts.get(i).getFullName());
		
		}
		
		
		}
		catch (Exception e) {
			System.out.println("exception at main test");
			e.printStackTrace();
		}
		
		
	}

}
