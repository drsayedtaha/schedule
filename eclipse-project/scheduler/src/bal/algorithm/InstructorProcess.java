package bal.algorithm;
import dto.Instructor;
import java.util.*;
import enums.AcademicDegree;
/**
 * 
 * @author Ahmed Fayez
 * This class provides methods that sort instructors by date and position
 */
public class InstructorProcess  {
	
	/**
	 * 
	 * @param instructors
	 * @return sorted instructors by date of employment 
	 */
	public List<Instructor> sortByDate(List<Instructor> instructors){
		
		Comparator<Instructor> order =  new Comparator<Instructor>() {
			public int compare(Instructor inst1, Instructor inst2) {
				// Negative sign to sort in descending order as the natural order of date is ascending
				return -inst2.getDateOfEmployment().compareTo(inst1.getDateOfEmployment());
			}
		};
			
		Collections.sort(instructors , order);
		
		return instructors;
		
	}
	
	public List<Instructor> sortByDegree(List<Instructor> instructors){
		// Get a list of academic position sorted using comparator based on natural declaration
		
		List<AcademicDegree> positions = new ArrayList<AcademicDegree>();
		positions.add(AcademicDegree.Demonstrator);
		positions.add(AcademicDegree.AssistantLecturer);
		positions.add(AcademicDegree.Lecturer);
		positions.add(AcademicDegree.AssistantProfessor);
		positions.add(AcademicDegree.Professor);
		Collections.sort(positions);
		
		
		// Natural sort of collections based on declaration, so the negative sign for seniority order
		Comparator<Instructor> order =  new Comparator<Instructor>() {
			
			public int compare(Instructor inst1, Instructor inst2) {
				
				return -inst1.getAcademicDegree().compareTo(inst2.getAcademicDegree());
		
			}
		};
	
		Collections.sort(instructors, order);
		return instructors;
		
	}


	
}
