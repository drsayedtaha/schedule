package 	Dal;
import DTO.*;

import java.util.List;

public interface HallDAO {

    public abstract List<Hall> getAllHalls();
    public abstract List<Course> getHalls(Department department);

    public boolean insert(Hall hall);
    public boolean exists(Hall hall);
    public boolean update(Hall hall);
    public boolean delete(Hall hall);

}
