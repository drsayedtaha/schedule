package view;

import javax.faces.event.ActionEvent;
import javax.annotation.ManagedBean;
import bal.BaoFactory;
import dto.Course;

@ManagedBean
public class CoursesBean {
	private Course course =new Course();
	   private BaoFactory db = new BaoFactory();
	   
		public void buttonAction(ActionEvent e1) {
			try {
			db.createCourseBAO().saveCourse(course);
			System.out.println("course added");

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		
		
		
	}