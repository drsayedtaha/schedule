package view;
import DTO.*;


public abstract class InstructorOperations {
    
    private Preference preference;
    
   //Calls preference constructor to initialize its object from the web-front-page text fields
    
   public abstract void setPreference(Instructor instructor,Course course,Period period);

   public abstract Preference getPreference();
   
   
}
