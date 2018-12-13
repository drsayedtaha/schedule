package view;
import dal.*;
import dto.*;
import enums.*;
public class Main {
	
	public static void main(String[] args) {
		try
		{
			
		Course course = new Course();
		course.setName("Circuits");
		course.setCode("ECE111");
		course.setDepartment(Department.Electrical);
		course.setGrade(Grade.FirstYear);
		course.setWeeklyLectureHours(4);
		course.setWeeklySectionHours(2);
		
		DAOFactory factory = new DAOFactory();
		factory.createCourseDAO().insert(course);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}


	}


}
