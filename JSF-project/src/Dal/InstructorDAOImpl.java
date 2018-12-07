package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.AcademicDegree;
import DTO.Department;
import DTO.Instructor;
import DTO.Period;
import DTO.Preference;
import utils.DBUtils;

public class InstructorDAOImpl implements InstructorDAO {

	@Override
	public Instructor getInstructor(String email) {
		Instructor instructor = new Instructor();
		try {
			String query = "SELECT * FROM SCHEDULE.USERS WHERE EMAIL='"+email+" ' ";		
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			
			instructor.setEmail(rs.getString(2));
			instructor.setFullName(rs.getString(4));
			instructor.setDateOfEmployment(rs.getString(5));
			instructor.setAcademicDegree(rs.getString(9));
			instructor.setDepartment(rs.getString(8));
			
			
			}
		
		conn.close();
		stmt.close();
		rs.close();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return instructor;
	}
	

	@Override
	public List<Instructor> getAllInstructors() {
		List<Instructor> instructors = new ArrayList<Instructor>();
		Instructor instructor = new Instructor();
		InstructorDAOFactory dAOFactory = new InstructorDAOFactory();
		try {
			String sql = "SELECT * FROM SCHEDULE.USERS";
			Connection connection = DBUtils.getConnection();
			PreparedStatement pstatement = connection.prepareStatement(sql);	
			ResultSet result = pstatement.executeQuery();
		while(result.next()) {
			instructor.setEmail(result.getString("EMAIL"));
			instructor.setFullName(result.getString("FULL_NAME"));
			instructor.setDateOfEmployment(result.getDate("DATE_OF_EMPLOYMENT"));
			instructor.setAcademicDegree(result.getString("ACADEMIC_DEGREE_ID"));
			instructor.setDepartment(result.getString("DEPARTMENT_ID"));
			}
		connection.close();
		pstatement.close();
		result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return instructors;
	}


	@Override
	public List<Instructor> getInstructors(Department department) {
		List<Instructor> result = new ArrayList<Instructor>();
		Instructor instructor = new Instructor();
		try {
			String query = "SELECT * FROM SCHEDULE.USERS WHERE DEPARTMENT_ID=?";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstatement = Connection.prepareStatement(sql);	
			ResultSet rs = pstatement.executeQuery(query);
		while(rs.next()) {
			
			instructor.setEmail(rs.getString("EMAIL"));
			instructor.setFullName(rs.getString("FULL_NAME"));
			instructor.setDateOfEmployment(rs.getDate("DATE_OF_EMPLOYMENT"));
			instructor.setAcademicDegree(rs.getString("ACADEMIC_DEGREE_ID"));
			instructor.setDepartment(rs.getString("DEPARTMENT_ID"));
			
			result.add(instructor);
			
			}
		
		conn.close();
		pstatement.close();
		rs.close();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

	@Override
	public List<Instructor> getInstructors(AcademicDegree academicDegree) {
		List<Instructor> result = new ArrayList<Instructor>();
		Instructor instructor = new Instructor();
		try {
			String query = "SELECT * FROM SCHEDULE.USERS WHERE Academic_Degree=?";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstatement = Connection.prepareStatement(sql);	
			ResultSet rs = pstatement.executeQuery(query);
		while(rs.next()) {
			
			instructor.setEmail(rs.getString("EMAIL"));
			instructor.setFullName(rs.getString("FULL_NAME"));
			instructor.setDateOfEmployment(rs.getDate("DATE_OF_EMPLOYMENT"));
			instructor.setAcademicDegree(rs.getString("ACADEMIC_DEGREE_ID"));
			instructor.setDepartment(rs.getString("DEPARTMENT_ID"));
			
			result.add(instructor);
			}
		
		conn.close();
		pstatement.close();
		rs.close();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean insert(Instructor instructor) {
		try {
			String query = "INSERT INTO SCHEDULE.USERS(EMAIL,PASSWORD,FULL_NAME,DATE_OF_EMPLOYMENT,ACADEMIC_FIELD,ROLE_ID,DEPARTMENT_ID;ACADEMIC_DEGREE_ID) VALUES(?,?,?,?,?,?,?,?)";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setString(2, instructor.getEmail());
			pst.setString(3, instructor.getPassword());
			pst.setString(4,instructor.getFullName());
			pst.setString(5,instructor.getDateOfEmployment());
			pst.setString(6, instructor.getAcademicField());
			pst.setString(7, instructor.getDepartment());
			pst.setString(8, instructor.getRole());
			pst.setString(9, instructor.getAcademicDegree());

			
				
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
	public boolean exists(Instructor instructor) {
		try {
			String query = "SELECT * FROM SCHEDULE.USERS  WHERE EMAIL='\"+email+\"'";
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
				while(rs.next())
				{
					if(rs.getString(2).equals(instructor.getEmail()))
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
	public boolean update(Instructor instructor) {
		try {
			String query = "UPDATE SCHEDULE.USERS SET EMAIL=?,PASSWORD=? ,FULL_NAME=? ,DATE_OF_EMPLOYMENT=? ,ACADEMIC_FIELD=?,ROLE_ID=?,DEPARTMENT_ID=? ,ACADEMIC_DEGREE_ID=?WHERE EMAIL='\"+email+\"'";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setString(2, instructor.getEmail());
			pst.setString(3, instructor.getPassword());
			pst.setString(4,instructor.getFullName());
			pst.setString(5,instructor.getDateOfEmployment());
			pst.setString(6, instructor.getAcademicField());
			pst.setString(7, instructor.getDepartment());
			pst.setString(8, instructor.getRole());
			pst.setString(9, instructor.getAcademicDegree());



			
			
				
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
	public boolean delete(Instructor instructor) {
		try {
			String query = "DELETE FROM SCHEDULE.INSTRUCTORWHERE EMAIL='\"+email+\"'";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setString(4, instructor.getEmail());
			
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
