package fnt.hu.nl.automatischNakijken.domain;

import java.util.List;

public class SolutionRepository {
	private int id;
	private List<AssignmentType> assignmentTypes;
	private Assignment assignment;
	private List<Solution> solutions;
	private TargetLanguage targetLanguage;
	private boolean isActive;
	
	
	public SolutionRepository(List<AssignmentType> assignmentTypes,
			Assignment assignment, List<Solution> solutions, boolean isActive, TargetLanguage language) {
		super();
		this.assignmentTypes = assignmentTypes;
		this.assignment = assignment;
		this.solutions = solutions;
		this.isActive = isActive;
		this.targetLanguage = language;
	}

	private SolutionRepository() {
	}
	

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public List<AssignmentType> getAssignmentTypes() {
		return assignmentTypes;
	}

	public void setAssignmentTypes(List<AssignmentType> assignmentTypes) {
		this.assignmentTypes = assignmentTypes;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public TargetLanguage getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(TargetLanguage targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

}
