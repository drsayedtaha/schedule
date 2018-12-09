package com.fym.cse.dao;

import DTO.Division;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;
import enums.Department;
import DTO.Division;
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
			String query = "INSERT INTO DIVISIONS VALUES(?)";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setString(1, division.getName());
			
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
		String query = "DELETE FROM DIVISIONS WHERE DIVISIONS.NAME=?";
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
		
		String query = "select * from DIVISIONS where id = '"+id.toString()+"'";
		try(Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);)
		{
			while (rs.next()) {
				Division division = new Division();
				division.setId(rs.getInt("DIVISION_ID"));
				division.setNumberOfStudents(rs.getInt("NUMBER_OF_STUDENTS"));
				division.setName(rs.getString("DIVISION_NAME"));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		return null;
	}

	
	
}
