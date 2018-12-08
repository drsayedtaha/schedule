package 	Dal;
import DTO.*;
import enums.Department;

import java.util.List;

public interface DivisionDAO {

    
    public List<Division> getDivisions();
    public Division getDivision(Integer id);
    public boolean exists(Division division);
    public boolean insert(Division division);
    
    public boolean delete(Division division);
}
