package fnt.hu.nl.automatischNakijken.Domain;

import java.util.List;

public class Student extends Person {
	private int number;
	private List<Group> groups;
	private List<Solution> solutions;
	
	public Student(String first, String sur, String full, String email) {
		super(first, sur, full, email);
	}

}
