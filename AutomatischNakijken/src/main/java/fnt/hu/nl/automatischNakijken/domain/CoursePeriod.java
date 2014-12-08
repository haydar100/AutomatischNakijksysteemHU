package fnt.hu.nl.automatischNakijken.domain;

import java.util.Calendar;
import java.util.List;

public class CoursePeriod {
	private Calendar startDate, endDate;
	private Course course;
	private List<Class> classes;
	private List<Assignment> assignments;
	private int id;

	private CoursePeriod() {

	}
	
	public CoursePeriod(Calendar startDate, Calendar endDate, Course course) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
	}

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
