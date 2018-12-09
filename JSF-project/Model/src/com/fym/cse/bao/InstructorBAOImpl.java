package com.fym.cse.bao;

import java.util.List;
import java.util.*;
import Dal.DAOFactory;
import DTO.Course;
import DTO.Period;
import DTO.Preference;

/**
 * Author: Mohamed Osama
 * Created on Dec 12, 2018
 * Last edited on 3/12/208
 */

public class InstructorBAOImpl implements InstructorBAO {

	public DAOFactory dAOFactory = new DAOFactory();

	// This method for getting a list of courses which is available for this user and return it in a result list.
	@Override
	public List<Course> getCourses() {
		List<Course> result = new ArrayList<Course>();
		Course course = new Course();
		ListIterator listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
		result.add(listIterator.next());
		}
		return result;
	}
	// This method for getting a list of Periods which is available for this user and return it in a result list.
	@Override
	public List<Period> getPeriods() {
		List<Period> result = new ArrayList<Period>();
		Period period = new Period();
		ListIterator listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			result.add(listIterator.next());
		}
		return result;
	}
	// This method for getting a list of preferences which is chosen by him return it in a result list.
	@Override
	public List<Preference> getPreferences() {
		List<Preference> result = new ArrayList<Preference>();
		Preference preference = new Preference();
		ListIterator listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			result.add(listIterator.next());
		}
		return result;
	}

	/* these 3 methods for access on courses by the user whether save or update if it is found before
	and delete if he wants */

	@Override
	public boolean saveCourse(Course course) {

		if (dAOFactory.addCourse().exists(course))

			return false;

		else

			dAOFactory.addCourse().insert(course);
		return true;
	}

	@Override
	public boolean updateCourse (Course course) {
		dAOFactory.createCourseDAO().update(course);
		return true;
	}

	@Override
	public boolean deleteCourse(Course course) {
		dAOFactory.addCourse().delete(course);
		return true;
	}

	/* these 3 methods for access on periods by the user whether save or update if it is found before
	and delete if he wants */

	@Override
	public boolean savePeriod(Period period) {

		if (dAOFactory.createPeriodDAO().exists(period))

			return false;

		else

			dAOFactory.createPeriodDAO().insert(period);
			return true;
	}


	@Override
	public boolean updatePeriod(Period period) {
		dAOFactory.createPeriod().update(period);
		return true;
	}

	@Override
	public boolean deletePeriod(Period period) {
		dAOFactory.createPeriodDAO().delete(period);
		return true;
	}

	/* These methods for saving the preference which is inserted by the user and update it if
	it is found before */
	@Override
	public boolean savePreference(Preference preference) {
		if (dAOFactory.createPreferenceDAO().exists(preference))
		{
			return false;
		}
		else
			dAOFactory.createPreferenceDAO().insert(preference);
		return true;
	}

	


}
