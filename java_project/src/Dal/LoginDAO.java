package 	Dal;

public interface LoginDAO {

    public boolean exists(String email, String password);
    public boolean isAdmin(String email);

}
