package com.fym.cse.dao;
/**
 made by abdallah saied 2-12-2018 11:30 pm
 * this class contains factory for all Dao's
 */
public class DAOFactory {
    
    public CourseDAO createCourseDAO(){
          return new CourseDAOImpl();
    }
    public DivisionDAO createDivisionDAO(){
          return new DivisionDAOImpl();
    }
    public HallDAO createHallDAO(){
          return new HallDAOImpl();
    }
    public InstructorDAO createInstructorDAO(){
          return  new InstructorDAOImpl();
    }
    public LoginDAO createLoginDAO(){
          return new LoginDAOImpl();
    }
    public PeriodDAO createPeriodDAO(){
          return new PeriodDAOImpl();
    }
    public PreferenceDAO createPreferenceDAO(){
          return new PreferenceDAOImpl();
    }
    
    
}
