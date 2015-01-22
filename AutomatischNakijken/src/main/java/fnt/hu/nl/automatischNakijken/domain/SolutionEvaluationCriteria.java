package fnt.hu.nl.automatischNakijken.domain;

public class SolutionEvaluationCriteria {
	private int id;
	private SolutionEvaluation solutionEvaluation;
	private String name;
	private Grade grade;	
	
	public SolutionEvaluationCriteria(String name, Grade grade){
		this.name = name;
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public SolutionEvaluation getSolutionEvaluation() {
		return solutionEvaluation;
	}

	public void setSolutionEvaluation(SolutionEvaluation solutionEvaluation) {
		this.solutionEvaluation = solutionEvaluation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	
}
