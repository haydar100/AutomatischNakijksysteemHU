package fnt.hu.nl.automatischNakijken.Domain;
import java.util.List;

public abstract class Staff extends Person {
	private List<SolutionEvaluation> evaluations;
	private List<Class> classes;
	
	public Staff(String first, String sur, String full, String email){
		super(first, sur, full, email);
	}
}
