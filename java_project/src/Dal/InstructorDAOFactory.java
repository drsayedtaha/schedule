package src.Dal;

public class InstructorDAOFactory {

    public InstructorDAO createInstructorDAO() {
        return new InstructorDAOImpl();
    }
}
