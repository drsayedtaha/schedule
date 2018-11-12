package Dal;

import DTO.Course;
import DTO.Hall;
import DTO.Instructor;
import DTO.Period;

public abstract class AdminDAOImpl {
   
    public abstract boolean insertInstructor(Instructor instructor);
    public abstract boolean  insertCourse(Course course);
    public abstract boolean   insertHall(Hall hall);
    public abstract boolean  insertPeriod(Period period);

    public abstract boolean  updateInstructor(Instructor instructor);
    public abstract boolean  updateCourse(Course course);
    public abstract boolean  updateHall(Hall hall);
    public abstract boolean  updatePeriod(Period period);
    
    public abstract boolean  deleteInstructor(Instructor instructor);
    public abstract boolean  deleteCourse(Course course);
    public abstract boolean  deleteHall(Hall hall);
    public abstract boolean  deletePeriod(Period period);
   
}
