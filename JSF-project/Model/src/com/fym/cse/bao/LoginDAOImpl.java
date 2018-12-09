package com.fym.cse.bao;
import java.sql.*;

import Dal.LoginDAO;
import utils.DBUtils;
/**
 * created by Mohamed Ezat
 * 
 */
public class LoginDAOImpl implements LoginDAO {
	
	@Override
	public boolean exists(String email, String password) {
		try {
			String query = "SELECT * FROM SCHEDULE.USERS";
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				if(rs.getString(2).equals(email)&&rs.getString(3).equals(password))
					return true;
				}
			conn.close();
			stmt.close();
			rs.close();
	}
		catch(SQLException e) {
			System.out.println("Incorrect email or password");
			
		}
		return false;
	}

	@Override
	public boolean isAdmin(String email) {
		
		try {
			String query = "SELECT SCHEDULE.ROLE_ID FROM USERS WHERE EMAIL='"+email+"'";
			
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			String roleID = rs.getString("SCHEDULE.ROLE_ID");
			String query2 = "SELECT ROLE_NAME FROM SCHEDULE.ROLES WHERE ROLE_ID = '"+roleID+"'";
			ResultSet rs2 = stmt.executeQuery(query2);
			rs2.next();
			if(rs2.getString(1).equals("admin")) {
				return true;
			}
	}
		catch(SQLException e) {
			System.out.println("Incorrect email ");

}
		return false;	
	}
	}
