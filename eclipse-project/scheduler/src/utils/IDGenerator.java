package utils;
import java.sql.*;
import java.sql.SQLException;

/**
 * 
 * @author Ahmed Fayez
 * Created on 15/12/2018
 */
public class IDGenerator {
	/**
	 * This method auto generates primary keys for tables
	 * @param tableName
	 * @return primary key value
	 */
	public static Integer createPrimaryKey(String tableName) {
		
		Integer primaryKey = 1;
		
		StringBuilder columnName = new StringBuilder(tableName);
		columnName.deleteCharAt(tableName.length()-1);
		columnName.append("_id");
		
		StringBuilder query = new StringBuilder("select "+columnName+" FROM "+tableName);
		
		
		try (Connection con = DBUtils.getConnection();
				PreparedStatement pst = con.prepareStatement(query.toString());
				ResultSet rst = pst.executeQuery();)
		{
			
			while(rst.next())
			{
				primaryKey = rst.getInt(columnName.toString());
			}
			
			return primaryKey;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
        return null;
	}

}
