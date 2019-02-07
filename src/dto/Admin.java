package dto;

public class Admin  {
    private int iD;
    private String email;
    private String password;
    private String fullName;


    public void setID(int iD) {
        this.iD = iD;
    }

    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getID() {
        return iD;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
