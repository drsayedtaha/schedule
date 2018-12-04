package Dal;
import java.sql.*;
/**
 * 
 * @author Ahmed Fayez
 * Launched on 30th, November 2018
 * 
 */
public class DBUtils {
	/**
	 * A static method that returns a connection object 
	 * for further usage whenever a connection needs to be created
	 * @return Connection conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try
		{
		Class.forName("oracle.jdbc.Driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "SYSTEM", "oracle");
		}
		catch (SQLException e) {
			System.out.println("SQL exception at DB connection");
			e.printStackTrace();
			
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found exception");
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
