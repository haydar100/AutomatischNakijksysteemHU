package fnt.hu.nl.automatischNakijken.Domain;

import java.util.List;

public class Class {
	private String name;
	private int id;

	private CoursePeriod coursePeriod;
	private List<TeachingAssistant> teachingAssistants;
	private List<Instructor> instructors;
	private List<WorkGroup> groups;
	
	private Class(){
		
	}
	
	public Class(String name, CoursePeriod coursePeriod){
		this.name = name;
		this.coursePeriod = coursePeriod;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CoursePeriod getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(CoursePeriod coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
	
	public List<TeachingAssistant> getTeachingAssistants() {
		return teachingAssistants;
	}

	public void setTeachingAssistants(List<TeachingAssistant> teachingAssistants) {
		this.teachingAssistants = teachingAssistants;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public List<WorkGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<WorkGroup> groups) {
		this.groups = groups;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

}
