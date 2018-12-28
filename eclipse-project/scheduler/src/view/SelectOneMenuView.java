package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

@ManagedBean
public class SelectOneMenuView {
	private String console; 
    
   
    private String city;  
    private Map<String,String> cities = new HashMap<String, String>();
     
    private String category;  
    private Map<String,String> categories = new HashMap<String, String>();
    
    private Theme theme;   
    private List<Theme> themes;
     
   
    @PostConstruct
    public void init() {
        //cars
       
         
        //cities
        cities = new HashMap<String, String>();
        cities.put("Civil", "Civil");
        cities.put("Electrical", "Electrical");
        cities.put("MathematicsAndPhysics", "MathematicsAndPhysics");
        cities.put("Architectural", "Architectural");
        cities.put("Mechanical", "Mechanical");
        cities.put("Industrial", "Industrial");
        
        categories = new HashMap<String, String>();
        categories.put("Lecture Hall", "Lecture Hall");
        categories.put("Section Room", "Section Room");
        //themes
    }


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Map<String, String> getCategories() {
		return categories;
	}


	public void setCategories(Map<String, String> categories) {
		this.categories = categories;
	}


	public String getConsole() {
		return console;
	}


	public void setConsole(String console) {
		this.console = console;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Map<String, String> getCities() {
		return cities;
	}


	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}


	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	public List<Theme> getThemes() {
		return themes;
	}


	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
 
   
}
