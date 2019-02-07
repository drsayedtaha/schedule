package view;

import bal.BaoFactory;

import dal.DAOFactory;

import dto.Course;

import enums.Department;
import enums.Grade;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "Courses")
@ViewScoped

public class CoursesBean {

    private List<Course> filteredCourses;

    public void setFilteredCourses(List<Course> filteredCourses) {
        this.filteredCourses = filteredCourses;
    }

    public List<Course> getFilteredCourses() {
        return filteredCourses;
    }

    BaoFactory bfactory = new BaoFactory();
    DAOFactory dfactory = new DAOFactory();

    private List<Course> courses;

    @PostConstruct
    public void init() {
        courses = dfactory.createCourseDAO().getAllCourses();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String deleteAction(Course course) {
        if (bfactory.createCourseBAO().deleteCourse(course)) {
            courses.remove(course);
            FacesMessage msg = new FacesMessage("Course Deleted Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
            }
        else {
            FacesMessage msg = new FacesMessage("Error occured refresh the page.\nCourse not deleted");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }
    public String editAction(Course course){
            if(dfactory.createCourseDAO().update(course)){      
                FacesMessage msg2 = new FacesMessage(course.getName()+" Edited Successfully ");
             FacesContext.getCurrentInstance().addMessage(null, msg2); 
             return null;}
            else{
                FacesMessage msg2 = new FacesMessage(" Error ,course not edited , refresh the page please ");
                FacesContext.getCurrentInstance().addMessage(null, msg2);
                return null;}
        }


   

    public void onRowEdit(RowEditEvent event) {
        try {
            FacesMessage msg = new FacesMessage("editing " + ((Course) event.getObject()).getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Course course = (Course) event.getObject();
            editAction(course);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
         
          }

    

   public Course findCourse(Integer id) {
        for(Course course : courses) {
            if(course.getID().equals(id)) {
                return course;
            }
        }
        return null;
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled " + ((Course) event.getObject()).getCode());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Grade> getGrades() {

        return Arrays.asList(Grade.values());
    }

    public List<Department> getDepartments() {

        return Arrays.asList(Department.values());
    }

}
