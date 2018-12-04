package src.view;

import src.DTO.*;


public abstract class AdminOperations  {
    
    
    
    // initializing objects upon saving admin's inputs
    public abstract void setInstructor();
    public abstract void setCourse();
    public abstract void setHall();
    public abstract void setPeriod();
    
    public abstract Instructor getInstructorObj();
    public abstract Course getCourseObj();
    public abstract Hall getHallObj();
    public abstract Period getPeriodObj();
    
}
