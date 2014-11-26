package fnt.hu.nl.automatischNakijken.Domain;

public class TeachingAssistant extends Staff {
	private int id;
	private TeachingAssistant(){
		super();
	}
	
	public TeachingAssistant(String first, String sur, String full, String email) {
		super(first, sur, full, email);
	}
	
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

}
