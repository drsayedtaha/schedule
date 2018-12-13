package dal;

import java.util.ArrayList;
import java.util.List;

import dto.Period;
import utils.DBUtils;

import java.sql.*;

/**
 * 
 * @author Ahmed Fayez
 * Created on 29/11/2018
 * Last updated on 8/12/2018
 */

public class PeriodDAOImpl implements PeriodDAO {

	@Override
	public List<Period> getPeriods() {
		List<Period> result =null;//= new ArrayList<Period>();
		Period period = null;//new Period();
		String query = "SELECT * FROM PERIODS";
		try (
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);)
		{
		while(rs.next()) 
			if(result == null)
				result = new ArrayList<Period>();
			period = new Period();
			period.setID(rs.getInt(1));
			period.setDay(rs.getString(2)); //gets data from second column
			period.setStartTime(rs.getString(3)); //gets data from third column
			period.setEndTime(rs.getString(4));
			period.setInterval(period.getStartTime(),period.getEndTime()); // The form 2:00 - 4:00
			result.add(period);
			
		
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Exception at getPeriods");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("Exception at getPeriods");

		}
		return result;
	}

	@Override
	public boolean exists(Period period) {
		String query = "SELECT * FROM PERIODS WHERE DAY = '"+period.getDay()+"' AND START_TIME = '"+period.getStartTime()
		+"' AND END_TIME = '"+period.getEndTime()+"' ;";
		try(
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);)
		{
			return rs.next();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean insert(Period period) {
		String query = "INSERT INTO PERIODS(DAY,PERIOD_NAME,START_TIME,END_TIME) VALUES(?,?,?,?)";
		try (
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);)
		{
		pst.setString(1, period.getDay());
		pst.setString(2, period.getName());
		pst.setString(3, period.getStartTime());
		pst.setString(4, period.getEndTime());
			
		return true;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public boolean delete(Period period) {
		String query = "DELETE FROM PERIODS WHERE NAME=?";
		try (
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);)
		{
			
		pst.setString(1, period.getName());
		
		
		return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Period getPeriod(Integer id) {
		return null;
	}

	@Override
	public boolean update(Period period) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	


	

}
