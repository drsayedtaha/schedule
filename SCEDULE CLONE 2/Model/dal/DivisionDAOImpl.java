package dal;

import dto.Division;

import enums.Department;
import enums.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import utils.DBUtils;

/**
 *
 * @author Saleh mahmoud
 * last updated on 8/12/2018 by Ahmed Fayez (Added enums instead of look-up tables)
 */
public class DivisionDAOImpl implements DivisionDAO {

	

	@Override
	public List<Division> getDivisions() {
		List<Division> result = null;
		Division division = new Division();
		Connection conn ;
		Statement stmt ;
		ResultSet rs ;
		try {
			String query = "SELECT * FROM DIVISIONS";
			 conn = DBUtils.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(query);
		while(rs.next()) {
			if(result == null)
				result = new ArrayList<Division>();
			division.setName(rs.getString(2));
			
			result.add(division);
			
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
	public boolean exists(Division division) {
		try {
		String query = "SELECT * FROM DIVISIONS";
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
			while(rs.next())
			{
				if(rs.getString(2).equals(division.getName()))
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
	public boolean insert(Division division) {
		
		try {
			String query = "INSERT INTO DIVISION(division_name,division_id) VALUES(?,?)";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setString(1, division.getName());
			pst.setInt(2, 3); // Testing id 
			pst.executeQuery();
			conn.close();
			pst.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public boolean delete(Division division) {
		try {
		String query = "DELETE FROM DIVISION WHERE DIVISION.NAME=?";
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		
		pst.setString(2, division.getName());
		
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
	public Division getDivision(Integer id) {
		
		String query = "select from DIVISIONS where division_id ="+id;
		try(Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);)
		{
			
				Division division = new Division();
				division.setId(id);
				division.setNumberOfStudents(rs.getInt(2));
				division.setName(rs.getString(3));
                    division.setGrade(Grade.valueOf(rs.getString(4)));
                    division.setDepartment(Department.valueOf(rs.getString(5)));
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		return null;
	}

	
	
}
