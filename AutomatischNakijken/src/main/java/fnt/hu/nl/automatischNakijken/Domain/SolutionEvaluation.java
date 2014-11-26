package fnt.hu.nl.automatischNakijken.Domain;

import java.util.Calendar;
import java.util.List;

public class SolutionEvaluation {
	private int id;
	private Solution solution;
	private Grade finalGrade;
	private List<SolutionEvaluationCriteria> criteria;
	private Staff evaluator;
	
	private Calendar timeOfEvaluation;
	
	private SolutionEvaluation(){
		
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public Grade getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(Grade finalGrade) {
		this.finalGrade = finalGrade;
	}

	public List<SolutionEvaluationCriteria> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<SolutionEvaluationCriteria> criteria) {
		this.criteria = criteria;
	}

	public Staff getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Staff evaluator) {
		this.evaluator = evaluator;
	}

	public Calendar getTimeOfEvaluation() {
		return timeOfEvaluation;
	}

	public void setTimeOfEvaluation(Calendar timeOfEvaluation) {
		this.timeOfEvaluation = timeOfEvaluation;
	}
	
	
}
