package bal;

import dto.Period;

public interface PeriodBAO {
	
	public boolean savePeriod(Period period);
	public boolean updatePeriod(Period period);
	public boolean deletePeriod(Period period);

}
