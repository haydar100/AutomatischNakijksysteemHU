package fnt.hu.nl.automatischNakijken.Domain;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class Solution {
	private int id;
	private SolutionRepository solutionRepository;
	private Solution nextVersion;
	private Solution previousVersion;
	
	private SolutionEvaluation solutionEvaluation;
	private List<SolutionSimilarity> similarities;
	
	private WorkGroup group;
	private List<Student> students;
	private List<File> files;
	
	private Calendar timeOfSubmission;
	private boolean isCurrent;
	
	public Solution() {
		
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
	public Solution getNextVersion() {
		return nextVersion;
	}
	public void setNextVersion(Solution nextVersion) {
		this.nextVersion = nextVersion;
	}
	public Solution getPreviousVersion() {
		return previousVersion;
	}
	public void setPreviousVersion(Solution previousVersion) {
		this.previousVersion = previousVersion;
	}
	public SolutionEvaluation getSolutionEvaluation() {
		return solutionEvaluation;
	}
	public void setSolutionEvaluation(SolutionEvaluation solutionEvaluation) {
		this.solutionEvaluation = solutionEvaluation;
	}
	public List<SolutionSimilarity> getSimilarities() {
		return similarities;
	}
	public void setSimilarities(List<SolutionSimilarity> similarities) {
		this.similarities = similarities;
	}
	public WorkGroup getGroup() {
		return group;
	}
	public void setGroup(WorkGroup group) {
		this.group = group;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Calendar getTimeOfSubmission() {
		return timeOfSubmission;
	}
	public void setTimeOfSubmission(Calendar timeOfSubmission) {
		this.timeOfSubmission = timeOfSubmission;
	}
	public boolean isCurrent() {
		return isCurrent;
	}
	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

}
