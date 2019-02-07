package view;

import bal.BaoFactory;

import dal.DAOFactory;

import dto.Instructor;

import enums.AcademicDegree;
import enums.Department;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name ="Users")
@ViewScoped

public class UsersBean {

    private List<Instructor> filteredInstructors;



    BaoFactory bfactory = new BaoFactory();
    DAOFactory dfactory = new DAOFactory();

    private List<Instructor> instructors;


    @PostConstruct
    public void init() {
       instructors = dfactory.createInstructorDAO().getAllInstructors();
    }



    public String deleteAction(Instructor user) {
        if (dfactory.createInstructorDAO().delete(user)) {
            instructors.remove(user);
            FacesMessage msg = new FacesMessage("User Deleted Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
            }
        else {
            FacesMessage msg = new FacesMessage("Error occured refresh the page.\nUser not deleted");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }
    public String editAction(Instructor instructor){
            if(dfactory.createInstructorDAO().update(instructor)){      
                FacesMessage msg2 = new FacesMessage(instructor.getFullName()+" Edited Successfully ");
             FacesContext.getCurrentInstance().addMessage(null, msg2); 
             return null;}
            else{
                FacesMessage msg2 = new FacesMessage(" Error ,User not edited , refresh the page please ");
                FacesContext.getCurrentInstance().addMessage(null, msg2);
                return null;}
        }


   

    public void onRowEdit(RowEditEvent event) {
        try {
            FacesMessage msg = new FacesMessage("editing " + ((Instructor) event.getObject()).getFullName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Instructor instructor = (Instructor) event.getObject();
            editAction(instructor);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
         
          }

    

   public Instructor finduser(Integer id) {
        for(Instructor instructor : instructors) {
            if(instructor.getId().equals(id)) {
                return instructor;
            }
        }
        return null;
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled " + ((Instructor) event.getObject()).getFullName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public List<Department> getDepartments() {

        return Arrays.asList(Department.values());
    }


    public void setFilteredInstructors(List<Instructor> filteredInstructors) {
        this.filteredInstructors = filteredInstructors;
    }

    public List<Instructor> getFilteredInstructors() {
        return filteredInstructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<AcademicDegree> getAcademicDegrees() {

        return Arrays.asList(AcademicDegree.values());
    }
 
}
