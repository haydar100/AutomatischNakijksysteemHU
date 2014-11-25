package fnt.hu.nl.automatischNakijken.Domain;

public abstract class Person {
	private String firstName;
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
