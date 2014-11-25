package fnt.hu.nl.automatischNakijken.Domain;

import java.util.List;

public class Course {
	private int id;
	private String name;
	private String code;
	
	private List<AssignmentType> assignmentTypes;
	private List<CoursePeriod> coursePeriods;
	
	private Course(){
		
	}
	
	public Course(String name, String code){
		this.name = name;
		this.code = code;
	}
	
	public int getId(){
		return this.id;
	}
	
	private void setId(int id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public List<CoursePeriod> getCoursePeriods() {
		return coursePeriods;
	}

	public void setCoursePeriods(List<CoursePeriod> coursePeriods) {
		this.coursePeriods = coursePeriods;
	}

}
