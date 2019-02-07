package bal;


public class BaoFactory {
	public CourseBAO createCourseBAO(){
        return new CourseBAOImpl();
  }
	
	public HallBAO createHallBAO(){
        return new HallBAOImpl();
  }
	
	public InstructorBAO createInstructorBAO(){
        return new InstructorBAOImpl();
  }
	public AdminBAO createAdminBAO(){
        return new AdminBAOimpl();
  }
	
	public PeriodBAO createPeriodBAO(){
        return new PeriodBAOImpl();
  }
	
	public PreferenceBAO createPreferenceBAO(){
        return new PreferenceBAOImpl();
  }
	
}
