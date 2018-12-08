package 	Dal;

import DTO.Period;
import java.util.List;

public interface PeriodDAO {
	
    public List<Period> getPeriods();
    public Period getPeriod(Integer id);
    public boolean exists(Period period);
    public boolean insert(Period period);
    public boolean delete(Period period);
    public boolean update(Period period);
}
