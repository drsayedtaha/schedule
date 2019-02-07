package bal;

import dal.DAOFactory;
import dto.Instructor;

public class InstructorBAOImpl implements InstructorBAO {
	private DAOFactory factory = new DAOFactory();
	@Override
	public boolean saveInstructor(Instructor instructor) {
		// if ( factory.createInstructorDAO().exists(instructor))
					return factory.createInstructorDAO().insert(instructor);
				 
				 //else
				//	 return factory.createInstructorDAO().update(instructor);
	}

	@Override
	public boolean deleteInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
