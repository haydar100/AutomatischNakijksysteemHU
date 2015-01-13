package fnt.hu.nl.automatischNakijken.domain;

import java.io.File;
import java.util.ArrayList;
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
	private List<SolutionFile> files;
	
	private Calendar timeOfSubmission;
	private boolean isCurrent;
	
	
	public Solution() {
		
	}
	public Solution(SolutionRepository solutionRepository,
			Solution nextVersion, Solution previousVersion,
			SolutionEvaluation solutionEvaluation,
			List<SolutionSimilarity> similarities, WorkGroup group,
			List<Student> students, List<SolutionFile> files,
			Calendar timeOfSubmission, boolean isCurrent) {
		super();
		
		this.solutionRepository = solutionRepository;
		this.nextVersion = nextVersion;
		this.previousVersion = previousVersion;
		this.solutionEvaluation = solutionEvaluation;
		
		if(similarities != null)
			this.similarities = similarities;
		else
			this.similarities = new ArrayList<SolutionSimilarity>();
		
		this.group = group;
		this.students = students;
		this.files = files;
		this.timeOfSubmission = timeOfSubmission;
		this.isCurrent = isCurrent;
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
	
	public boolean getisCurrent() {
		return isCurrent;
	}
	
	public void setisCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	public List<SolutionFile> getFiles(){
		return this.files;
	}
	
	public void setFiles(List<SolutionFile> files){
		this.files = files;
	}
	
	//Add the comparison to the list of similarities, and to the subject as well if it does not yet know this similarity
	public void addSimilarity(SolutionSimilarity similarity){
		this.similarities.add(similarity);
		
		//Create the inverse of the Similarity to see if the other solution knows this combination
		SolutionSimilarity inverseSimilarity = new SolutionSimilarity(similarity.getSubjectSolution(), similarity.getReferenceSolution(), similarity.getSimilarityPercentage());
		
		Solution similaritySubject = similarity.getSubjectSolution();
		//If the subject does not know the similarity, add the similarity
		if(!similaritySubject.similarities.contains(similarity)){
			similaritySubject.addSimilarity(inverseSimilarity);
		}	
	}
}
