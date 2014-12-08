package fnt.hu.nl.automatischNakijken.domain;
import java.util.List;

public abstract class Staff extends Person {
	private List<SolutionEvaluation> evaluations;
	private List<Class> classes;
	
	protected Staff(){
		super();
	}
	
	public Staff(String first, String sur, String full, String email){
		super(first, sur, full, email);
	}
	
	public List<SolutionEvaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<SolutionEvaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
}
