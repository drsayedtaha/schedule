package view;
import dal.DAOFactory;
import dto.Hall;
//import dto.Preference;

import java.util.List;
import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//mport javax.faces.bean.ViewScoped;
//@ManagedBean(name="Halls")
//@ViewScoped


public class hallBean {
	
	 private String genre;
	    private String sortby;
	    private String test;
	    
	   
	    private List<Hall> halls;
	   @PostConstruct
	    public void init(){
		   try {
			   DAOFactory factory= new DAOFactory();
			   halls = factory.createHallDAO().getAllHalls();
					   }
		   catch (Exception e) {
				e.printStackTrace();
		   }
	        

	    }
	   public String getTest() {
			return test;
		}

		public void setTest(String test) {
			this.test = test;
		}
		public List<Hall> gethalls() {
			return halls;
		}


		public void sethalls(List<Hall> halls) {
			this.halls = halls;
		}
		
	    public void setGenre(String genre){
	        
	        this.genre=genre;
	        
	    }
	    public String getGenre(){
	        
	        return genre;
	    }
	    public void setSortby(String sortby){
	        this.sortby=sortby;
	       
	    }
	    public String getSortby(){
	        return sortby;
	    }
	   
	    }


