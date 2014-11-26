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
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
}
