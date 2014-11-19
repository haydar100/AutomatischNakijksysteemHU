package fnt.hu.nl.automatischNakijken.Domain;

import java.util.Calendar;
import java.util.List;

public class CoursePeriod {
	private Calendar startDate, endDate;
	private Course course;
	private List<Class> classes;
	private List<Assignment> assignments;
}
