package DTO;

import java.util.ArrayList;

public class Course {
   
   private ArrayList<Instructor> instructors;
   private ArrayList<Period> periods;
   
   private Integer iD;
   private String name;
   private String code;
   private Grade grade; // String or DTO class , dp look-up table?
   private Department department;
   private Integer weeklyLectureHours;
   private Integer weeklySectionHours;
   private Division division; 
    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(ArrayList<Period> periods) {
        this.periods = periods;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Division getDivision() {
        return division;
    }

}
