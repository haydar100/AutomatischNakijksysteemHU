package fnt.hu.nl.automatischNakijken.Domain;

import java.util.List;

public class Group {
	private int id;
	
	private int groupNumber;
	private Class theClass;
	private List<Solution> solutions;
	private List<Student> students;
	
	public Group(){
		
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id){
		this.id = id;
	}
}
