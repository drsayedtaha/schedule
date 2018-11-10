package DTO;
import java.util.Date;
import java.util.List;

public class Instructor {
    
    private Course[] courses;
    
    private Integer iD;
    private String fullName;
    private  String email;
    private String password;
    private String mobileNumber;
    private Date dateOfEmployment;
    private String academicDegree; // db dependent
    private String department; // academic degree?
    private  List availableDays[];
    // private Integer maxLoad;


    public void setCourse(Course[] course) {
        this.courses = course;
    }

    public Course[] getCourse() {
        return courses;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getID() {
        return iD;
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

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    

    public void setAvailableDays(List[] availableDays) {
        this.availableDays = availableDays;
    }

    public List[] getAvailableDays() {
        return availableDays;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
