package Dal;

import java.util.ArrayList;
import java.util.List;

import DTO.Division;
import DTO.Period;
import java.sql.*;
public class PeriodDAOImpl implements PeriodDAO {
	
	
	@Override
	public List<Period> getPeriods() {
		List<Period> result = new ArrayList<Period>();
		Period period = new Period();
		try {
			String query = "SELECT * FROM SCHEDULE.PERIODS";
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			
			period.setDay(rs.getString(2)); //gets data from second column
			period.setStartTime(rs.getString(3)); //gets data from third column
			period.setEndTime(rs.getString(4));
			result.add(period);
			
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
	public boolean exists(Period period) {
		try {
		String query = "SELECT * FROM SCHEDULE.PERIODS";
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
			while(rs.next())
			{
				if(rs.getString(3).equals(period.getStartTime())&&rs.getString(4).equals(period.getEndTime()))
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
	public boolean insert(Period period) {
		
		try {
		String query = "INSERT INTO SCHEDULE.PERIODS(PERIOD_NAME,START_TIME,END_TIME) VALUES(?,?,?)";
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		
		pst.setString(1, period.getName());
		pst.setString(2, period.getStartTime());
		pst.setString(3, period.getEndTime());
			
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
	public boolean update(Period period) {
		//TODO	
		return false;
	}

	@Override
	public boolean delete(Period period) {
		try {
		String query = "DELETE FROM SCHEDULE.PERIODS WHERE PERIODS.NAME=?";
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		
		pst.setString(1, period.getName());
		
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
