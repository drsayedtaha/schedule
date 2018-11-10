package DAL;

import DTO.Admin;
import DTO.Instructor;

//Model interface ( dealing with database )
public interface InstructorDAO {
    //Login credentials
    public Instructor login(String username,String password);
    public Admin login(String username,String password);
    //Admin authorities
    public boolean exists(Instructor instructor);
    public boolean insert(Instructor instructor);
    public boolean update(Instructor instructor);
    public boolean delete(Instructor instructor);
    
    
   

    
    
    
}
