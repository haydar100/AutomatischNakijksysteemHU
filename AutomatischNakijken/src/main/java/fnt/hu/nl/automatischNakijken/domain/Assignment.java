package fnt.hu.nl.automatischNakijken.domain;

import java.util.Calendar;

public class Assignment {
	private int id;
	private SolutionRepository solutionRepository;
	private AssignmentType assignmentType;
	private CoursePeriod coursePeriod;
	private Calendar deadLine;
	private boolean allowTeachingAssistant;
	
	
	public Assignment(SolutionRepository solutionRepository,
			AssignmentType assignmentType, CoursePeriod coursePeriod,
			Calendar deadLine, boolean allowTeachingAssistant) {
		super();
		this.solutionRepository = solutionRepository;
		this.assignmentType = assignmentType;
		this.coursePeriod = coursePeriod;
		this.deadLine = deadLine;
		this.allowTeachingAssistant = allowTeachingAssistant;
	}

	
	private Assignment() {
		
	}


	public int getId() {
		return id;
	}


	private void setId(int id) {
		this.id = id;
	}

	public SolutionRepository getSolutionRepository() {
		return solutionRepository;
	}
	public void setSolutionRepository(SolutionRepository solutionRepository) {
		this.solutionRepository = solutionRepository;
	}
	public AssignmentType getAssignmentType() {
		return assignmentType;
	}
	public void setAssignmentType(AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}
	public CoursePeriod getCoursePeriod() {
		return coursePeriod;
	}
	public void setCoursePeriod(CoursePeriod coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
	public Calendar getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Calendar deadLine) {
		this.deadLine = deadLine;
	}
	public boolean isAllowTeachingAssistant() {
		return allowTeachingAssistant;
	}
	public void setAllowTeachingAssistant(boolean allowTeachingAssistant) {
		this.allowTeachingAssistant = allowTeachingAssistant;
	}
	
	
}
