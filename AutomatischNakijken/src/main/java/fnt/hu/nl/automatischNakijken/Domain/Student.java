package fnt.hu.nl.automatischNakijken.Domain;

import java.util.List;

public class Student extends Person {
	private int id;
	private int number;
	private List<WorkGroup> groups;
	private List<Solution> solutions;
	
	public Student(String first, String sur, String full, String email) {
		super(first, sur, full, email);
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<WorkGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<WorkGroup> groups) {
		this.groups = groups;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

}
