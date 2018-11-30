package DTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Instructor  {
    
    private ArrayList<Course> courses;
    
    private Integer id;
    private String fullName;
    private  String email;
    private String password;
    private String mobileNumber;
    private Date dateOfEmployment;
    private AcademicDegree academicDegree; // db dependent
    private Department department; // academic degree?
    private  List<String> availableDays[];
    // private Integer maxLoad;


    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
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

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

	public List<String>[] getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(List<String>[] availableDays) {
		this.availableDays = availableDays;
	}

    


}
