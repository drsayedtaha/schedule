package dal;

import dto.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import utils.DBUtils;

public class AdminDAOImpl implements AdminDAO {
    public AdminDAOImpl() {
        super();
    }

    @Override
    public Admin getAdmin(String email) {
        // TODO Implement this method
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> result = null;
        Admin admin = null;

        try {
            String query = "SELECT * FROM Admins";
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (result == null)
                    result = new ArrayList<>();
                admin=new Admin();
                admin.setID(rs.getInt(1));

                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));
               


                result.add(admin);
            }

            conn.close();
            stmt.close();
            rs.close(); }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean insert(Admin admin) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean exists(Admin admin) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        try {
                
                    String query = "UPDATE HALLS SET NAME=?,email=?,password=? WHERE Admin_ID=?";
                    Connection conn = DBUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, admin.getName());
                pstmt.setString(2, admin.getEmail());
                pstmt.setString(3, admin.getPassword());
                pstmt.setInt(4,admin.getID());
            pstmt.executeUpdate();
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
    public boolean delete(Admin admin) {
        try {
            String query = "DELETE FROM Admins WHERE id=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, admin.getID());

            pst.executeUpdate();
            conn.close();
            pst.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
