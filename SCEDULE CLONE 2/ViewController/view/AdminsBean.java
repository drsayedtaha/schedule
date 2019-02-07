package view;

import bal.BaoFactory;

import dal.DAOFactory;

import dto.Admin;
import dto.Hall;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name ="Admins")
@ViewScoped

public class AdminsBean {

    private List<Hall> filteredAdmins;


    BaoFactory bfactory = new BaoFactory();
    DAOFactory dfactory = new DAOFactory();

    private List<Admin> admins;

    @PostConstruct
    public void init() {
        admins = dfactory.createAdminDAO().getAllAdmins();
    }

    public void setFilteredAdmins(List<Hall> filteredAdmins) {
        this.filteredAdmins = filteredAdmins;
    }

    public List<Hall> getFilteredAdmins() {
        return filteredAdmins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Admin> getAdmins() {
        return admins;
    }


    public String deleteAction(Admin admin) {
        if (dfactory.createAdminDAO().delete(admin)) {
            admins.remove(admin);
            FacesMessage msg = new FacesMessage("Admin Deleted Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
            }
        else {
            FacesMessage msg = new FacesMessage("Error occured refresh the page.\nAdmin not deleted");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }
    public String editAction(Admin admin){
            if(dfactory.createAdminDAO().update(admin)){      
                FacesMessage msg2 = new FacesMessage(admin.getName()+" Edited Successfully ");
             FacesContext.getCurrentInstance().addMessage(null, msg2); 
             return null;}
            else{
                FacesMessage msg2 = new FacesMessage(" Error ,admin not edited , refresh the page please ");
                FacesContext.getCurrentInstance().addMessage(null, msg2);
                return null;}
        }


   

    public void onRowEdit(RowEditEvent event) {
        try {
            FacesMessage msg = new FacesMessage("editing " + ((Admin) event.getObject()).getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Admin admin = (Admin) event.getObject();
            editAction(admin);
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
         
          }

    

   public Admin findAdmin(Integer id) {
        for(Admin admin : admins) {
            if(admin.getID().equals(id)) 
                return admin;
            
        }
        return null;}
}
    
