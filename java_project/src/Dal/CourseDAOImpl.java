package Dal;

import java.util.List;

import DTO.Course;
import DTO.Department;
import DTO.Division;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
//implemented by abdallah saied 4-12-2018 2:00 am
public class CourseDAOImpl implements CourseDAO {
               // getAllCourses() method returns a list which contains all the courses data
	@Override
	public List<Course> getAllCourses() {
		List<Course> result = new ArrayList<Course>();
		Course course=new Course();
		try {
		        String query = "SELECT * FROM SCHEDULE.COURSES";
		        Connection conn = DBUtils.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
		        
		            course.setID(rs.getInt(1));
		            course.setName(rs.getString(4));
		            course.setCode(rs.getString(5));
		            course.setWeeklyLectureHours(rs.getInt(6));
		            course.setWeeklySectionHours(rs.getInt(7));
		        result.add(course);
		        
		        }
		
		conn.close();
		stmt.close();
		rs.close();
		
		}
		catch (SQLException e) {
		        e.printStackTrace();
		}
		
		return result;
	}

	@Override
        // getCourse method takes the id and returns the course with that id
    public  Course getCourse(Integer iD){
	    try {
	    String query = "SELECT * FROM SCHEDULE.COURSES WHERE COURSE_ID=? ";
	    Connection conn = DBUtils.getConnection();
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
		    PreparedStatement pst = conn.prepareStatement(query);
		    
		    pst.setString(1,Integer.toString(iD));
                Course course=new Course();
                course.setID(iD);
                course.setName(rs.getString(4));
                course.setCode(rs.getString(5));
                course.setWeeklyLectureHours(rs.getInt(6));
                course.setWeeklySectionHours(rs.getInt(7));
                
                return course;
                
		}
            catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }
    @Override
    // getCourse method takes the code and returns the course with that code
    public  Course getCourse(String code){
        try {
        String query = "SELECT * FROM SCHEDULE.COURSES WHERE CODE=? ";
        Connection conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
                PreparedStatement pst = conn.prepareStatement(query);
                
                pst.setString(1,code);
            Course course=new Course();
            course.setID(rs.getInt(1));
            course.setName(rs.getString(4));
            course.setCode(code);
            course.setWeeklyLectureHours(rs.getInt(6));
            course.setWeeklySectionHours(rs.getInt(7));
            
            return course;
            
            }
        catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }
        @Override
    // getAllCourses(Department department) a method takes object of the class department and returns a list which contains all the courses data 
   
        

	public List<Course> getCourses(Department department) {
		List<Course> result = new ArrayList<Course>();
		Course course=new Course();
		try {
		        String query = "SELECT * FROM SCHEDULE.COURSES WHERE DEPARTMENT_ID=?";
		        Connection conn = DBUtils.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		    PreparedStatement pst = conn.prepareStatement(query);
		    
		    pst.setString(1,Integer.toString(department.getId()));
		while(rs.next()) {
		        
		            course.setID(rs.getInt(1));
                            course.setDepartment(department);
		            course.setName(rs.getString(4));
		            course.setCode(rs.getString(5));
		            course.setWeeklyLectureHours(rs.getInt(6));
		            course.setWeeklySectionHours(rs.getInt(7));
		        result.add(course);
		        
		        }
		
		conn.close();
		stmt.close();
		rs.close();
		
		}
		catch (SQLException e) {
		        e.printStackTrace();
		}
		
		return result;
	}



	@Override
    // getAllCourses(Division division) a method takes object of the class division and returns a list which contains all the courses data 

	public List<Course> getCourses(Division division) {
		List<Course> result = new ArrayList<Course>();
		Course course=new Course();
		try {
		        String query = "SELECT * FROM SCHEDULE.COURSES WHERE DIVISION_ID=?";
		        Connection conn = DBUtils.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		    PreparedStatement pst = conn.prepareStatement(query);
		    
		    pst.setString(1,Integer.toString(division.getId()));
		while(rs.next()) {
		        
		            course.setID(rs.getInt(1));           
                            course.setDivision(division);
		            course.setName(rs.getString(4));
		            course.setCode(rs.getString(5));
		            course.setWeeklyLectureHours(rs.getInt(6));
		            course.setWeeklySectionHours(rs.getInt(7));
                           
		        result.add(course);
		        
		        }
		
		conn.close();
		stmt.close();
		rs.close();
		
		}
		catch (SQLException e) {
		        e.printStackTrace();
		}
		
		return result;
	}

	@Override
        // insert(Course course) it's a method takes object of course  then insert it into the database and returns true if inserted false if not inserted
	public boolean insert(Course course) {
            
	    try {
	    String query = "INSERT INTO SCHEDULE.COURSES(NAME,CODE,LECTURE_HOURS,SECTION_HOURS,DIVISION_ID,DEPARTMENT_ID) VALUES(?,?,?,?,?,?)";
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		
		pst.setString(1,course.getName());
		pst.setString(2,course.getCode());
		pst.setString(3,Integer.toString(course.getWeeklyLectureHours()));
                pst.setString(4,Integer.toString(course.getWeeklySectionHours()));
                pst.setString(5,Integer.toString(course.getDivision().getId()))  ;    
                pst.setString(6,Integer.toString(course.getDepartment().getId()))  ;      

			
		conn.close();
		pst.close();
		
		return true;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return false;


		
	}

	@Override
        // exists(course course) a method takes object of Course class then it checks if the code of this object course is already in database if yes it returns true if not it returns false
	public boolean exists(Course course) {
	    try {
	    String query = "SELECT * FROM SCHEDULE.COURSES";
	    Connection conn = DBUtils.getConnection();
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	            while(rs.next())
	            {
	                    if(rs.getString(5).equals(course.getCode()))
	                        conn.close();
	                        stmt.close();
	                        rs.close();
                                    return true;    
	            }
	            
	            conn.close();
	            stmt.close();
	            rs.close();
	            
	    }
	    
	    catch(SQLException e) {
	            e.printStackTrace();
	    }
		return false;
	}

	@Override
    // update(Course course) a method takes object of Course class then it UPDATES all the values and if updated returns true if not returns false
        
	public boolean update(Course course) {
	    try {
	    String query = "UPDATE SCHEDULE.COURSES SET NAME=?,CODE=?,LECTURE_HOURS=?,SECTION_HOUR =?,DIVISION_ID=?,DEPARTMENT_ID=? " +
                "WHERE COURSE_ID = ?";
	        Connection conn = DBUtils.getConnection();
	        PreparedStatement pst = conn.prepareStatement(query);
	        
	        pst.setString(1,course.getName());
	        pst.setString(2,course.getCode());
	        pst.setString(3,Integer.toString(course.getWeeklyLectureHours()));
	        pst.setString(4,Integer.toString(course.getWeeklySectionHours()));
	        pst.setString(5,Integer.toString(course.getDivision().getId()))  ;    
                pst.setString(6,Integer.toString(course.getDepartment().getId()))  ;    
	            pst.setString(7,Integer.toString(course.getID()));


	        conn.close();
	        pst.close();
	        
	        return true;
	        
	        }
	        catch(SQLException e) {
	                e.printStackTrace();
	        }
	    return false;

                
		
	}

	@Override
    // delete(Course course) a method takes object of Course class then it DELETS IT FROM THE DATABASE if deleted returs true if not returns false
	public boolean delete(Course course) {
		try {
		String query = "DELETE FROM SCHEDULE.COURSES WHERE CODE=?";
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		
		    pst.setString(1,course.getCode());

		
		conn.close();
		pst.close();
		
		return true;
		}
		catch(SQLException e) {
		        e.printStackTrace();
		}
		return false;
	}

}
