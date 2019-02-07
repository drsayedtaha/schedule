package dal;




import dto.Hall;

import enums.Department;
import utils.DBUtils;
import utils.IDGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HallDAOImpl implements HallDAO {
	List<Hall> result = new ArrayList<Hall>();
	Hall hall = new Hall();
	@Override
	public List<Hall> getAllHalls() {
		List<Hall> result =null;//= new ArrayList<Hall>();
		Hall hall = null;//new Hall();
			try {
				String query = "SELECT * FROM SCHEDULE.HALLS";
				try (Connection conn = DBUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery(query)){
			while(rs.next()) {
				if(result == null)
					result = new ArrayList<Hall>();
				 hall = new Hall();
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
		List<Hall> result =null;//= new ArrayList<Hall>();
		Hall hall = null;//new Hall();
		try {
			String query = "SELECT * FROM SCHEDULE.HALLS.DEPARTEMENT";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery(query)){
				while(rs.next()) {
					if(result == null)
						result = new ArrayList<Hall>();
					 hall = new Hall();
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
			String query = "SELECT * FROM HALLS WHERE Name= '"+hall.getName()+"' AND LOCATION = '"+hall.getLocation()+"' ;";
			try (Connection conn = DBUtils.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery(query)){
				while(rs.next())
				{    
					if(rs.getString(4).equals(hall.getName())&&rs.getString(7).equals(hall.getLocation()))
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
			Integer hallId = IDGenerator.createPrimaryKey("halls");
//			String query = "INSERT INTO HALLS(hall_id,department,category,name,capacity,code) VALUES(?,?,?,?,?,?)";
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO HALLS(hall_id,department,category,name,capacity,code,location) VALUES(");
			query.append(hallId+",'"+hall.getDepartment()+"','"+hall.getCategory()+"','"+hall.getName()+"','"+ hall.getCapacity()+"','"+hall.getCode()+"','"+hall.getLocation()+"')");
			try (Connection conn = DBUtils.getConnection();
//					PreparedStatement pstmt = conn.prepareStatement(query))
					Statement pstmt = conn.createStatement();)
					{
			
/**
                pstmt.setInt(1, hallId);
				pstmt.setString(2, "hhhhh");
				pstmt.setString(3, hall.getCategory());
				pstmt.setString(4, hall.getName());
				pstmt.setInt(5, hall.getCapacity());
				pstmt.setString(6, hall.getCode());
 */
//				pstmt.setInt(1, hallId);
//				pstmt.setString(2, "hhhhh");
//				pstmt.setString(3, hall.getCategory());
//				pstmt.setString(2, hall.getName());
//				pstmt.setInt(5, hall.getCapacity());
//				pstmt.setString(6, hall.getCode());
				System.out.println(query);
				pstmt.execute(query.toString());
				return true;
			      }
		}
			catch(SQLException e) 
		    {
				e.printStackTrace();
			}catch(Exception e) 
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
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery(query))
			
					{
			
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
				PreparedStatement pstmt = conn.prepareStatement(delete);
				ResultSet rs = pstmt.executeQuery(delete))
			
					{
						pstmt.setString(1, hall.getName());
			
					}
			
			return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}

}
