package fnt.hu.nl.automatischNakijken.Domain;

import java.io.File;
import java.util.List;

public class AssignmentType {
	private Course course;
	private List<Assignment> assignments;
	private List<AssignmentCheck> checks;
	private SolutionRepository solutionRepository;
	private File testTemplate;
	
	private String name;
	private String description;
	
}
