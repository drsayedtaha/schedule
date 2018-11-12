package view;

import DTO.*;


public abstract class AdminOperations {
    
    
    
    // initializing objects upon saving admin's inputs
    public abstract void setInstructor();
    public abstract void setCourse();
    public abstract void setHall();
    public abstract void setPeriod();
    
    public abstract Instructor getInstructor();
    public abstract Course getCourse();
    public abstract Hall getHall();
    public abstract Period getPeriod();
    
}
