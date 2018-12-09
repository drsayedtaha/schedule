package com.fym.cse.dao;

import java.util.List;

import DTO.Course;
import DTO.Hall;
import DTO.Period;
import enums.Department;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HallDAOImpl implements HallDAO {
	List<Hall> result = new ArrayList<Hall>();
	Hall hall = new Hall();
	@Override
	public List<Hall> getAllHalls() {
			try {
				String query = "SELECT * FROM SCHEDULE.HALLS";
				try (Connection conn = DBUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery(query)){
			while(rs.next()) {
				
				hall.setName(rs.getString(2)); //gets data from second column
				hall.setLocation(rs.getString(3)); //gets data from third column
				hall.setCapacity(rs.getInt(4));
				result.add(hall);
			}
				}
					}
			catch (SQLException e) {
				e.printStackTrace();
			} 
	
			return result ;
	}
	@Override
	public List<Hall> getHalls(Department department) {
		try {
			String query = "SELECT * FROM SCHEDULE.HALLS.DEPARTEMENT";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery(query)){
				while(rs.next()) {
					
					hall.setName(rs.getString("Name")); //gets data from Name column
					hall.setLocation(rs.getString("Location")); //gets data from third column
					hall.setCapacity(rs.getInt("Capacity"));
					result.add(hall);
				}
					}
						}
				catch (SQLException e) {
					e.printStackTrace();
				} 
					
				
			
				return result ;
		}
			
	
	

	@Override
	public boolean exists(Hall hall) {
		try {
			String query = "SELECT * FROM SCHEDULE.HALLS.DEPARTEMENT";
			try (Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query)){
				while(rs.next())
				{
					if(rs.getString("location").equals(hall.getLocation()))
						return true;	
				}
				
				
			}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
	

	@Override
	public boolean insert(Hall hall) {
		try {
			String query = "INSERT INTO SCHEDULE.HALLS(HALL_NAME,LOCATION,CAPACITY) VALUES(?,?,?)";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query))
					{
			
			pstmt.setString(1, hall.getName());
			pstmt.setString(2, hall.getLocation());
			pstmt.setInt(3, hall.getCapacity());
			boolean flag=exists(hall);
			if(!flag)
			return true;
			else {
				update(hall);
			     }
				
			      }
			}
			catch(SQLException e) 
		    {
				e.printStackTrace();
			}
			
		return false;
	}

	@Override
	public boolean update(Hall hall) {
		try {
			String query = "UPDATE SCHEDULE.HALLS SET HALL_NAME=?,LOCATION=?,CAPACITY=? WHERE HALL_ID=?";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query))
			//another method
				//	ResultSet rs = null;)
					{
			//rs.updateString(HALL_NAME, hall.getName());
			//rs.updateString(LOCATION, hall.getName());
			//rs.updateInt(CAPACITY, hall.getCapacity());
			pstmt.setString(1, hall.getName());
			pstmt.setString(2, hall.getLocation());
			pstmt.setInt(3, hall.getCapacity());
			pstmt.setInt(4,hall.getID());
			}
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
}
	

	@Override
	public boolean delete(Hall hall) {
		try {
			String delete= "DELETE FROM SCHEDULE.HALLS WHERE HALLS.NAME=?";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(delete))
			//another method
						//	ResultSet rs=null;)
			
			
					//ResultSet rs = pstmt.executeQuery(delete))
					{
			pstmt.setString(1, hall.getName());
			// rs.absolute(hall.getID());
		//	rs.deleteRow();
					}
			
			return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
	

}
