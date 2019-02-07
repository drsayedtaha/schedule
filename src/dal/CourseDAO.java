package 	dal;
import enums.Department;

import java.util.List;

import dto.Course;
import dto.Division;

/**last edited by abdallah saied 2-12-2018 11:25pm
 *
 */
public interface CourseDAO {

	
  public  List<Course> getAllCourses();
  public  Course getCourse(Integer iD);
  public  Course getCourse(String code);

  public  List<Course> getCourses(Department department);

  public  List<Course> getCourses(Division division);

  public  boolean insert(Course course);
  public  boolean exists(Course course);
  public  boolean update(Course course);
  public  boolean delete(Course course);
}