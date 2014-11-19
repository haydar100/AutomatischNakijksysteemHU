package fnt.hu.nl.automatischNakijken.Domain;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class Solution {
	private SolutionRepository solutionRepository;
	private Solution nextVersion;
	private Solution previousVersion;
	
	private SolutionEvaluation solutionEvaluation;
	private List<SolutionSimilarity> similarities;
	
	private Group group;
	private List<Student> students;
	private List<File> files;
	
	private Calendar timeOfSubmission;
	private boolean isCurrent;
}
