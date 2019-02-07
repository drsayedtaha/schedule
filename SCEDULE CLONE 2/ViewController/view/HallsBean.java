package view;

import bal.BaoFactory;

import dal.DAOFactory;

import dto.Hall;

import enums.Department;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name ="Halls")
@ViewScoped

public class HallsBean {

    private List<Hall> filteredHalls;
    public void setFilteredHalls(List<Hall> filteredHalls) {
        this.filteredHalls = filteredHalls;
    }

    public List<Hall> getFilteredHalls() {
        return filteredHalls;
    }



    BaoFactory bfactory = new BaoFactory();
    DAOFactory dfactory = new DAOFactory();

    private List<Hall> halls;
    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    @PostConstruct
    public void init() {
        halls = dfactory.createHallDAO().getAllHalls();
    }



    public String deleteAction(Hall hall) {
        if (dfactory.createHallDAO().delete(hall)) {
            halls.remove(hall);
            FacesMessage msg = new FacesMessage("Hall Deleted Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
            }
        else {
            FacesMessage msg = new FacesMessage("Error occured refresh the page.\nHall not deleted");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }
    public String editAction(Hall hall){
            if(dfactory.createHallDAO().update(hall)){      
                FacesMessage msg2 = new FacesMessage(hall.getName()+" Edited Successfully ");
             FacesContext.getCurrentInstance().addMessage(null, msg2); 
             return null;}
            else{
                FacesMessage msg2 = new FacesMessage(" Error ,hall not edited , refresh the page please ");
                FacesContext.getCurrentInstance().addMessage(null, msg2);
                return null;}
        }


   

    public void onRowEdit(RowEditEvent event) {
        try {
            FacesMessage msg = new FacesMessage("editing " + ((Hall) event.getObject()).getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Hall hall = (Hall) event.getObject();
            editAction(hall);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
         
          }

    

   public Hall findHall(Integer id) {
        for(Hall hall : halls) {
            if(hall.getID().equals(id)) {
                return hall;
            }
        }
        return null;
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled " + ((Hall) event.getObject()).getCode());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public List<Department> getDepartments() {

        return Arrays.asList(Department.values());
    }



}
