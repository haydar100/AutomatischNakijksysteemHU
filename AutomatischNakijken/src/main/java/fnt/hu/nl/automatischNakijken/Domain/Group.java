package fnt.hu.nl.automatischNakijken.Domain;

import java.util.List;

public class Group {
	private int id;
	
	private int groupNumber;
	private Class theClass;
	private List<Solution> solutions;
	private List<Student> students;
	
	private Group(){
		
	}
	
	public Group(int groupNumber, Class theClass, List<Solution> solutions, List<Student> students){
		this.groupNumber = groupNumber;
		this.theClass = theClass;
		this.solutions = solutions;
		this.students = students;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id){
		this.id = id;
	}
	
	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Class getTheClass() {
		return theClass;
	}

	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
