package bal;

import dal.DAOFactory;
import dto.Period;

public class PeriodBAOImpl implements PeriodBAO {
	
	
	DAOFactory dAOFactory = new DAOFactory();
	public boolean savePeriod(Period period) {

		if (dAOFactory.createPeriodDAO().exists(period))

			return false;

		else

			dAOFactory.createPeriodDAO().insert(period);
			return true;
	}
	
	
	public boolean updatePeriod(Period period) {
		dAOFactory.createPeriodDAO().update(period);
		return true;
	}
	
	
	public boolean deletePeriod(Period period) {
		dAOFactory.createPeriodDAO().delete(period);
		return true;
	}
}
