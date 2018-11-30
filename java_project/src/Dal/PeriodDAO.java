package 	Dal;
import DTO.Division;
import DTO.Period;
import java.util.List;

public interface PeriodDAO {
    public List<Period> getPeriods();
    public List<Period> getDivisions();

    public boolean exists(Division division);
    public boolean insert(Division division);
    public boolean update(Division division);
    public boolean delete(Division division);
}
