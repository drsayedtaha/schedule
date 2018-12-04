package 	Dal;
import DTO.Division;
import DTO.Period;
import java.util.List;

public interface PeriodDAO {
    public List<Period> getPeriods();
   

    public boolean exists(Period period);
    public boolean insert(Period period);
    public boolean update(Period period);
    public boolean delete(Period period);
}
