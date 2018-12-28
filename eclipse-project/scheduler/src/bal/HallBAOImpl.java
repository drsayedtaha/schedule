package bal;

import dto.Hall;
import dal.DAOFactory;

public class HallBAOImpl implements HallBAO {
	private DAOFactory factory = new DAOFactory();
	@Override
	public boolean saveHall(Hall hall) {
		
			
		return factory.createHallDAO().insert(hall);
	}

	

	@Override
	public boolean deleteHall(Hall hall) {
		
		return factory.createHallDAO().delete(hall);
	}



	@Override
	public boolean updateHall(Hall hall) {
		// TODO Auto-generated method stub
		return false;
	}

}
