package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ahmed Fayez
 * Created on 30th, November 2018
 * Last updated on 8/12/2018
 */
public class DBUtils {
	/**
	 * A static method that returns a connection object 
	 * for further usage whenever a connection needs to be established
	 * @return Connection object
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "MYDB", "12341234");
		}
		catch (SQLException e) {
			System.out.println("Exception at DB connection");
			e.printStackTrace();
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = getConnection();
	}
	
}
