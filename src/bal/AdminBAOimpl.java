package bal;

import dal.DAOFactory;
import dto.Admin;



public class AdminBAOimpl implements AdminBAO {
	private DAOFactory factory = new DAOFactory();
	@Override
	public boolean saveAdmin(Admin admin) {
		// if ( factory.createAdminDAO().exists(admin))
		return factory.createAdminDAO().insert(admin);
	 
	 //else
	//	 return factory.createAdminDAO().update(admin);
}
	

	@Override
	public boolean deleteAdmin(Admin admin) {
		
		return false;
	}

	

}
