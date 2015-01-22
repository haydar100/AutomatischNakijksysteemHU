package fnt.hu.nl.automatischNakijken.logic;

import fnt.hu.nl.automatischNakijken.domain.AutomaticCheck;
import fnt.hu.nl.automatischNakijken.domain.Grade;
import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluationCriteria;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.test.IHelloWorldAppTest;
import fnt.hu.nl.automatischNakijken.util.FolderChecker;
import fnt.hu.nl.automatischNakijken.util.TestRunner;
import fnt.hu.nl.automatischNakijken.util.URIClassLoader;

public class JUnitEvaluator extends AutomaticCheck {

	private String classNameToTest;
	private String pathToClass;
	private String absolutePathToClass;
	private Solution solution;
	private String testPath;
	private Grade grade;
	private String name;


	public JUnitEvaluator(String name, boolean isFailable, Solution s) {
		super(name, isFailable);
		this.solution = s;
		this.name = name;
	}



	@Override
	public SolutionEvaluationCriteria runCheck(Solution s) {
		runJUnit();
		for (Student student : s.getStudents()) {
			System.out.println(student.getFullName());
		}
		SolutionEvaluationCriteria criteria = new SolutionEvaluationCriteria(name, grade);
		System.out.println(name.toString());
		return criteria;
		
	}
	
	public String getSolutionFiles() {
		
		for (SolutionFile file : solution.getFiles()) {
			testPath = file.getFilePath();
		}
		return testPath;
	}
	
	public void runJUnit() {
	TestRunner runner = new TestRunner();
	IHelloWorldAppTest instance = new IHelloWorldAppTest();
	URIClassLoader UriClassLoader = new URIClassLoader();
	FolderChecker
			.removeFilesWithClassExtension("C:\\Users\\Berkan\\Desktop\\test\\");
	UriClassLoader
			.compileJavaSourceFile("C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java");
	instance.setClassName("HelloWorldApp");
	instance.setPathToClass("C:\\Users\\Berkan\\Desktop\\test\\");
	runner.runClass(instance.getClass());
	grade = runner.getGrade();
	System.out.println(grade);

}




}
