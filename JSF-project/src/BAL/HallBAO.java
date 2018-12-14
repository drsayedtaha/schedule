package bal;

import dto.Hall;

public interface HallBAO {
	
	public boolean saveHall(Hall hall);
	public boolean updateHall(Hall hall);
	public boolean deleteHall(Hall hall);

}
