package fnt.hu.nl.automatischNakijken.Domain;

public class Instructor extends Staff {
	private int id;
	
	public Instructor(String first, String sur, String full, String email) {
		super(first, sur, full, email);
	}
	
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
}
