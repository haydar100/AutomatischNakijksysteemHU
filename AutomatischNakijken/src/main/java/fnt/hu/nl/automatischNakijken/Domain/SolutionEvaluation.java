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
	
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
}
