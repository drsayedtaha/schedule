package view;

import bal.BaoFactory;

import dal.DAOFactory;

import dto.Preference;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name ="Prefs")
@ViewScoped

public class PrefsBean {

    private List<Preference> filteredPrefs;



    BaoFactory bfactory = new BaoFactory();
    DAOFactory dfactory = new DAOFactory();

    private List<Preference> prefs;
 

    @PostConstruct
    public void init() {
        prefs = dfactory.createPreferenceDAO().getAllPreferences();
    }





  
   public Preference findPref(Integer id) {
        for(Preference pref : prefs) {
            if(pref.getID().equals(id)) {
                return pref;
            }
        }
        return null;
    }

    public void setFilteredPrefs(List<Preference> filteredPrefs) {
        this.filteredPrefs = filteredPrefs;
    }

    public List<Preference> getFilteredPrefs() {
        return filteredPrefs;
    }

    public void setPrefs(List<Preference> prefs) {
        this.prefs = prefs;
    }

    public List<Preference> getPrefs() {
        return prefs;
    }


}
