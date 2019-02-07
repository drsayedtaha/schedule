package bal;

import dto.Hall;
import dal.DAOFactory;

public class HallBAOImpl implements HallBAO {
	private DAOFactory factory = new DAOFactory();
	@Override
	public boolean saveHall(Hall hall) {
		// if ( factory.createHallDAO().exists(hall))
			return factory.createHallDAO().insert(hall);
		 
		 //else
		//	 return factory.createHallDAO().update(hall);
			 
	}

	

	@Override
	public boolean deleteHall(Hall hall) {
		
		return factory.createHallDAO().delete(hall);
	}

}
