package dal;

import java.util.List;

import dto.Course;
import dto.Hall;
import dto.Period;
import enums.Department;
import utils.DBUtils;
import utils.IDGenerator;
import enums.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HallDAOImpl implements HallDAO {
	
	
	@Override
	public List<Hall> getAllHalls() {
				List<Hall> result = null;
				String query = "SELECT * FROM HALLS";
				try (Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);)
				{
					while(rs.next()) {
						if(result==null) result = new ArrayList<>();
						Hall hall = new Hall();
						
						hall.setID(rs.getInt("hall_id"));
						hall.setName(rs.getString("name")); 
						hall.setCode(rs.getString("code"));
						hall.setDepartment(Department.valueOf(rs.getString("department")));
						hall.setCapacity(rs.getInt("capacity"));
						result.add(hall);
					}
				
				}
				
			catch (SQLException e) {
				e.printStackTrace();
			} 
	
			return result;
	}
	@Override
	public List<Hall> getHalls(Department department) {
		List<Hall> result = null;
			String query = "SELECT * FROM HALLS where DEPARTEMENT = '"+department.toString()+"'";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery(query)){
				while(rs.next()) {
					if(result==null) result = new ArrayList<Hall>();
					Hall hall = new Hall();
					hall.setID(rs.getInt("hall_id"));
					hall.setName(rs.getString("Name")); //gets data from Name column
					hall.setCode(rs.getString("code")); //gets data from third column
					hall.setCapacity(rs.getInt("Capacity"));
					hall.setCategory(rs.getString("category"));
					result.add(hall);
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
			String query = "SELECT * FROM HALLS ";
			try (Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query)){
				while(rs.next())
				{
					if(rs.getString("name").equalsIgnoreCase(hall.getName()))
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
		Integer hallId = IDGenerator.createPrimaryKey("halls");
		try {
			String query = "INSERT INTO HALLS(hall_id,department,category,name,capacity,code) VALUES(?,?,?,?,?,?)";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query))
					{
			
			pstmt.setInt(1, hallId);
			pstmt.setString(2, hall.getDepartment().toString());
			pstmt.setString(3, hall.getCategory());
			pstmt.setString(4, hall.getName());
			pstmt.setInt(5, hall.getCapacity());
			pstmt.setString(6, hall.getCode());

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
			String query = "UPDATE HALLS SET NAME=?,category=?,CAPACITY=? WHERE HALL_ID=?";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query))
			//another method
				//	ResultSet rs = null;)
					{
			//rs.updateString(HALL_NAME, hall.getName());
			//rs.updateString(LOCATION, hall.getName());
			//rs.updateInt(CAPACITY, hall.getCapacity());
			pstmt.setString(1, hall.getName());
			pstmt.setString(2, hall.getCategory());
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
			String delete= "DELETE FROM HALLS WHERE HALLS.NAME=?";
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
