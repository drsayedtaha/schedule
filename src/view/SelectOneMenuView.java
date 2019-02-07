package view;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.PostConstruct;

import org.primefaces.PrimeFaces;


public class SelectOneMenuView {
	private String console; 
	
	
    
   
    private String city;  
    private Map<String,String> cities = new HashMap<String, String>();
    
    private String grade;  
    private Map<String,String> grades = new HashMap<String, String>();
    
    private String term;  
    private Map<String,String> terms = new HashMap<String, String>();
     
    private String category;  
    private Map<String,String> categories = new HashMap<String, String>();
    
    private Theme theme;   
    private List<Theme> themes;
    
    
    
    private String position;
    private Map<String,String> positions = new HashMap<String, String>();
   
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
        
       terms = new HashMap<String, String>();
        terms.put("First term", "First term");
        terms.put("Second term", "Second term");
        
        grades = new HashMap<String, String>();
        grades.put("Preparatory", "Preparatory");
        grades.put("2-First year", "First year");
        grades.put("3-Second year", "Second year");
        grades.put("4-Third year", "4-Third year");
        grades.put("Fourth year","Fourth year");
        
        positions = new HashMap<String, String>();
        positions.put("demonstrator", "demonstrator");
        positions.put("Assistant Lecturer", "Assistant Lecturer");
        positions.put("Lecturer", "Lecturer");        
        positions.put("Assistant Professor", "Assistant Professor");        
        positions.put("Professor", "Professor");        

       
    }
 
    public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Map<String, String> getPositions() {
		return positions;
	}

	public void setPositions(Map<String, String> positions) {
		this.positions = positions;
	}

	
 
    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }


	
	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public Map<String, String> getGrades() {
		return grades;
	}


	public void setGrades(Map<String, String> grades) {
		this.grades = grades;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public Map<String, String> getTerms() {
		return terms;
	}


	public void setTerms(Map<String, String> terms) {
		this.terms = terms;
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
