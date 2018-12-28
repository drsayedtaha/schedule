package view;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import dto.Instructor;
import enums.AcademicDegree;
import enums.Department;
import enums.Role;
import dal.DAOFactory;




public class AddUserBean {
private Instructor instructor = new Instructor();
private DAOFactory db = new DAOFactory();
public void buttonAction(ActionEvent e1) {
	try {
		db.createInstructorDAO().insert(instructor);
	System.out.println("user added");

	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
private Map<String,Department> depts;
public Map<String, Department> getDepts() {
	return depts;
}
public void setDepts(Map<String, Department> depts) {
	this.depts = depts;
}
@PostConstruct
public void init() {
	depts = new HashMap<>();
	depts.put(Department.Architectural.toString(), Department.Architectural);
	depts.put(Department.Civil.toString(), Department.Civil);
	depts.put(Department.Electrical.toString(), Department.Electrical);
	depts.put(Department.Industrial.toString(), Department.Industrial);
	depts.put(Department.Mechanical.toString(), Department.Mechanical);
	depts.put(Department.MathematicsAndPhysics.toString(), Department.MathematicsAndPhysics);
	academic = new HashMap<>();
	academic.put(AcademicDegree.Demonstrator.toString(), AcademicDegree.Demonstrator);
	academic.put(AcademicDegree.Lecturer.toString(), AcademicDegree.Lecturer);
	academic.put(AcademicDegree.AssistantLecturer.toString(), AcademicDegree.AssistantLecturer);
	academic.put(AcademicDegree.AssistantProfessor.toString(), AcademicDegree.AssistantProfessor);
	academic.put(AcademicDegree.Professor.toString(), AcademicDegree.Professor);
	role = new HashMap<>();
	role.put(Role.Instructor.toString(), Role.Instructor);
	role.put(Role.Admin.toString(), Role.Admin);
	
	}

private Map<String,AcademicDegree> academic;
public Map<String, AcademicDegree> getacademic() {
	return academic;
}


public Map<String, AcademicDegree> getAcademic() {
	return academic;
}
public void setAcademic(Map<String, AcademicDegree> academic) {
	this.academic = academic;
}

     

private Map<String,Role> role;
public Map<String, Role> getrole() {
	return role;
}
public void setrole(Map<String, Role> role) {
	this.role = role;
}




public Instructor getInstructor() {
	return instructor;
}
public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}

}
