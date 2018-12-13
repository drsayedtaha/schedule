package 	dal;
import enums.Department;

import java.util.List;

import dto.*;

public interface DivisionDAO {

    
    public List<Division> getDivisions();
    public Division getDivision(Integer id);
    public boolean exists(Division division);
    public boolean insert(Division division);
    
    public boolean delete(Division division);
}
