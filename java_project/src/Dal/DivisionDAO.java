package 	Dal;
import DTO.*;

import java.util.List;

public interface DivisionDAO {

    public List<Division> getDivisions(Department department);
    public List<Division> getDivisions();

    public boolean exists(Division division);
    public boolean insert(Division division);
    public boolean update(Division division);
    public boolean delete(Division division);
}
