package BAL;

public interface LoginBAO {
	public boolean login(String email,String password);
	public void authorizeAdmin();
	public void authorizeInstructor();
	
}
