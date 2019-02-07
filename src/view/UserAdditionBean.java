package view;
import javax.annotation.ManagedBean;

import javax.faces.event.ActionEvent;


import dto.Admin;

import dto.Instructor;

import bal.BaoFactory;

@ManagedBean
public class UserAdditionBean {
	private Admin admin =new Admin();
	private Instructor instructor =new Instructor();
	   private BaoFactory db = new BaoFactory();
	   
	   public void buttonAction(ActionEvent e1) {
			try {
			db.createInstructorBAO().saveInstructor(instructor);
			System.out.println("instructor added");

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
	   public void buttonAction2(ActionEvent e2) {
			try {
			db.createAdminBAO().saveAdmin(admin);
			System.out.println("admin added");

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public BaoFactory getDb() {
		return db;
	}

	public void setDb(BaoFactory db) {
		this.db = db;
	}


}
