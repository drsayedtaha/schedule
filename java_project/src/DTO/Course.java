package DTO;

public class Course {
   
   private Instructor[] instructors;
   private Period[] periods;
   
   private Integer iD;
   private String name;
   private String code;
   private String grade; // String or DTO class , dp look-up table?
   private String department; 
   private Integer weeklyLectureHours;
   private Integer weeklySectionHours;


    public void setInstructors(Instructor[] instructors) {
        this.instructors = instructors;
    }

    public Instructor[] getInstructors() {
        return instructors;
    }

    public void setPeriods(Period[] periods) {
        this.periods = periods;
    }

    public Period[] getPeriods() {
        return periods;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getID() {
        return iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setWeeklyLectureHours(Integer weeklyLectureHours) {
        this.weeklyLectureHours = weeklyLectureHours;
    }

    public Integer getWeeklyLectureHours() {
        return weeklyLectureHours;
    }

    public void setWeeklySectionHours(Integer weeklySectionHours) {
        this.weeklySectionHours = weeklySectionHours;
    }

    public Integer getWeeklySectionHours() {
        return weeklySectionHours;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
