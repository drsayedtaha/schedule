package dal;


import dto.Admin;

import java.util.List;


public interface AdminDAO {
    public Admin getAdmin(String email);
    public List<Admin> getAllAdmins();
    public boolean insert(Admin admin);
    public boolean exists(Admin admin);
    public boolean update(Admin admin);
    public boolean delete(Admin admin);
}
