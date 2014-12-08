package fnt.hu.nl.automatischNakijken.domain;

public abstract class Person {
	private int id;
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String surName;
	private String fullName;
	private String email;
	
	public Person(String first, String sur, String full, String email){
		this.firstName = first;
		this.surName = sur;
		this.fullName = full;
		this.email = email;
	}
	
	//Hibernate required constructor
	protected Person(){
		
	}
}
