package 	dal;
import java.util.List;

import dto.*;
import enums.Department;
public interface HallDAO {

    public abstract List<Hall> getAllHalls();
    public abstract List<Hall> getHalls(Department department);

    public boolean insert(Hall hall);
    public boolean exists(Hall hall);
    public boolean update(Hall hall);
    public boolean delete(Hall hall);

}
