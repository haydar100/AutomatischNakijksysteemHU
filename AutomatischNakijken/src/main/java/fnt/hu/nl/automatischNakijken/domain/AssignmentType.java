package fnt.hu.nl.automatischNakijken.domain;

import java.io.File;
import java.util.List;

public class AssignmentType {
	private int id;
	private Course course;
	private List<Assignment> assignments;
	private List<ClassBluePrint> blueprints;
	private List<AssignmentCheck> checks;
	private SolutionRepository solutionRepository;
	private File testTemplate;
	
	private String name;
	private String description;
	
	public AssignmentType(Course course, List<Assignment> assignments,
			List<AssignmentCheck> checks,
			SolutionRepository solutionRepository, File testTemplate,
			String name, String description) {
		super();
		this.course = course;
		this.assignments = assignments;
		this.checks = checks;
		this.solutionRepository = solutionRepository;
		this.testTemplate = testTemplate;
		this.name = name;
		this.description = description;
	}
	private AssignmentType() {
		
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public List<AssignmentCheck> getChecks() {
		return checks;
	}

	public void setChecks(List<AssignmentCheck> checks) {
		this.checks = checks;
	}

	public SolutionRepository getSolutionRepository() {
		return solutionRepository;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}
	public void setSolutionRepository(SolutionRepository solutionRepository) {
		this.solutionRepository = solutionRepository;
	}

	public File getTestTemplate() {
		return testTemplate;
	}

	public void setTestTemplate(File testTemplate) {
		this.testTemplate = testTemplate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the blueprints
	 */
	public List<ClassBluePrint> getBlueprints() {
		return blueprints;
	}
	/**
	 * @param blueprints the blueprints to set
	 */
	public void setBlueprints(List<ClassBluePrint> blueprints) {
		this.blueprints = blueprints;
	}

	
	
	
}
