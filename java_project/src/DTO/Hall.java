package DTO;

public class Hall {
    
    private Integer iD;
    private String location;
    private String name;
    private Integer capacity;
    private String department; //look-up table?


    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getID() {
        return iD;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
