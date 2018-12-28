package dal;

import java.util.List;
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

public class HallDAOImpl implements HallDAO {
	
	
	@Override
	public List<Hall> getAllHalls() {
				List<Hall> result = null;
				Hall hall = null;
				try {
				String query = "SELECT * FROM HALLS";
				Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
					while(rs.next()) {
						if(result==null) result = new ArrayList<Hall>();
						 hall = new Hall();
						
						hall.setID(rs.getInt(1));
						hall.setName(rs.getString(4)); 
						hall.setCode(rs.getString(6));
						hall.setDepartment(Department.valueOf(rs.getString(2)));
						hall.setCapacity(rs.getInt(5));
						hall.setCategory(rs.getString(3));
						result.add(hall);
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
	public List<Hall> getHalls(Department department) {
		List<Hall> result = null;
		Hall hall=null;
		try {
			String query = "SELECT * FROM HALLS where DEPARTEMENT =?";
			Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					 pstmt.setString(1,department.toString() ); //enum
					ResultSet rs = pstmt.executeQuery(query);
				while(rs.next()) {
					if(result==null) result = new ArrayList<Hall>();
				  hall = new Hall();
					hall.setID(rs.getInt(1));
					hall.setName(rs.getString(4)); //gets data from Name column
					hall.setDepartment(Department.valueOf(rs.getString(2)));
					hall.setCode(rs.getString(6)); //gets data from third column
					hall.setCapacity(rs.getInt(5));
					hall.setCategory(rs.getString(3));
					result.add(hall);
				}
				conn.close();
	            rs.close();
	            pstmt.close();

		}
						
				catch (SQLException e) {
					e.printStackTrace();
				} 
			
				return result ;
		}
			
	  public  Hall getHall(Integer iD){
	        try {
	        String query = "SELECT * FROM HALLS WHERE HALL_ID=? ";
	        Connection conn = DBUtils.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, Integer.toString(iD));
	        ResultSet rs = pstmt.executeQuery(query);

	        Hall hall = new Hall();
	        hall.setID(iD);
	        hall.setDepartment(Department.valueOf(rs.getString(2)));
	        hall.setName(rs.getString(4));
	        hall.setCode(rs.getString(6));
	        hall.setCapacity(rs.getInt(5));
			hall.setCategory(rs.getString(3));


	        conn.close();
	        pstmt.close();
	        rs.close();
	        return hall;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	    }  
	  
	  
	  
	  
	  public Hall getHall(String code) {
		    try {
		        String query = "SELECT * FROM HALLS WHERE CODE=? ";
		        Connection conn = DBUtils.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(query);

		        pstmt.setString(1, code);
		        ResultSet rs = pstmt.executeQuery(query);
		        
		        Hall hall = new Hall();
		        hall.setID(rs.getInt(1));;
		        hall.setDepartment(Department.valueOf(rs.getString(2)));
		        hall.setName(rs.getString(4));
		        hall.setCode(code);
		        hall.setCapacity(rs.getInt(5));
				hall.setCategory(rs.getString(3));
		   
		        conn.close();
		        pstmt.close();
		        rs.close();
		        return hall;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
		    }
	  
	@Override
	public boolean exists(Hall hall) {
		try {
			String query = "SELECT * FROM HALLS WHERE code = '"+hall.getCode()+"'";
			Connection conn = DBUtils.getConnection();
		    Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(query);
		            
				while(rs.next())
				{
					if(rs.getString(4).equalsIgnoreCase(hall.getCode()))
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
 * pstmt.setInt(1, hallId);
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
			String query = "UPDATE HALLS SET NAME=?,CATEGORY=?,CAPACITY=?,DEPARTMENT=?,CODE=?"+" WHERE HALL_ID=?";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query); 
			pstmt.setInt(1,hall.getID());
			pstmt.setString(2, hall.getDepartment().toString());
			pstmt.setString(3, hall.getCategory());
			pstmt.setString(4, hall.getName());
			pstmt.setInt(5, hall.getCapacity());
			pstmt.setString(6, hall.getCode());			
			pstmt.executeQuery();
            conn.close();
            pstmt.close();

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
			String delete= "DELETE FROM HALLS WHERE CODE=?";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(delete);
			
			pstmt.setString(6, hall.getCode());
			
			 pstmt.executeQuery();
	            conn.close();
	            pstmt.close();
			return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
	

}
