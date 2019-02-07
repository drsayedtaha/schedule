package dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dto.Admin;
import utils.DBUtils;
import utils.IDGenerator;

public class AdminDAOimpl implements AdminDAO {

	@Override
	public boolean insert(Admin admin) {

		Integer adminId = IDGenerator.createPrimaryKey("admins");
		try {
		
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO ADMINS(admin_id,EMAIL,PASSWORD,FULL_NAME) VALUES(");
			query.append(adminId+",'"+admin.getEmail()+"','"+admin.getPassword()+"','"+admin.getFullName()+"')");
			try (Connection conn = DBUtils.getConnection();
					Statement pstmt = conn.createStatement();)
					{
		System.out.println(query);
		pstmt.execute(query.toString());
	return true;
	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}catch(Exception e) 
{
	e.printStackTrace();
}
	return false;
}

	}


