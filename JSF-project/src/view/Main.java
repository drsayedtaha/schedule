package view;
import dal.*;
import dto.*;
import enums.*;
public class Main {
	
	public static void main(String[] args) {
		DAOFactory factory = new DAOFactory();
		try
		{
			
		Division division = new Division();
		division.setDepartment(Department.Electrical);
		division.setGrade(Grade.FirstYear);
		division.setName("Computer and systems");
		
		factory.createDivisionDAO().insert(division);
		
		Course course = new Course();
		course.setName("Circuits");
		course.setCode("ECE111");
		course.setDepartment(Department.Electrical);
		course.setGrade(Grade.FirstYear);
		course.setWeeklyLectureHours(4);
		course.setWeeklySectionHours(2);
		course.setDivision(division);
		
		factory.createCourseDAO().getAllCourses();
		
		// System.out.println(factory.createCourseDAO().delete(course));
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	

}
}
