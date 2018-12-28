 package view;

import javax.annotation.ManagedBean;
import javax.faces.event.ActionEvent;


import dto.Hall;
import bal.BaoFactory;

@ManagedBean
public class AddHallsBean {
	private Hall hall =new Hall();
   private BaoFactory db = new BaoFactory();
	
	public void buttonAction(ActionEvent e1) {
		try {
		db.createHallBAO().saveHall(hall);
		System.out.println("hall added");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	
}
