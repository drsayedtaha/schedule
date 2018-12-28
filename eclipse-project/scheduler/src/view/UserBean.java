package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



import dal.CourseDAO;
import dal.DAOFactory;
import dal.PeriodDAO;
import dto.Course;
import dto.Period;
import dto.Preference;

@ManagedBean(name = "userBean")
@RequestScoped





public class UserBean {
   // private NameService nameService;
	private DAOFactory coursedao= new DAOFactory();
	private PeriodDAO perioddao= new DAOFactory().createPeriodDAO();
	private List<Period> periods;
	private String department;
	private String grade;
	private String counter;
	private Period period;
	private String course;
	private List <Course> courses = null;
	private List <String> coursesName = new ArrayList<>();
	private List <String> courseName = new ArrayList<>();
	private List <Preference> preferences;

	/*
    public void onPreferenceDropped(DragDropEvent ddEvent) {
        Period period = ((Period) ddEvent.getData());
        Preference preference = new Preference();
        preference.setCourse(courses.get(0));
        
        preferences.add(preference);
        periods.remove(period);
    }
    */
    public UserBean () {
    	try {
    		periods = getPeriods();
    	}
    	catch (Exception e) {
    		
    	}
    }
	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

	public List<Period> getPeriods() {
		periods = perioddao.getPeriods();
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public void alo () {
		addMessage("aloooooo");
	}

	public List <Course> getCourses() {
		return courses;
	}

	public void setCourses(List <Course> courses) {
		this.courses = courses;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List <String> getCoursesName() {
		return coursesName;
	}

	public void setCoursesName(List <String> coursesName) {
		
		this.coursesName = coursesName;
	}

	@PostConstruct
    public void init() {
		//coursesName = nameService.list();
		periods = perioddao.getPeriods();
		courses = coursedao.createCourseDAO().getAllCourses();
		for (int i=0; i<courses.size(); i++)
		{
			System.out.println(courses.get(i).getName());
			//coursesName.add(courses.get(i).getName());
			coursesName.add(i, courses.get(i).getName());
			courseName.add(i, course);
			
			System.out.println(coursesName.get(i));
		}
			

	
	}
	
	
	
	public List <Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List <Preference> preferences) {
		this.preferences = preferences;
	}


}
