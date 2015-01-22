package fnt.hu.nl.automatischNakijken.logic;

import fnt.hu.nl.automatischNakijken.domain.AutomaticCheck;
import fnt.hu.nl.automatischNakijken.domain.Grade;
import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluationCriteria;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.test.HelloWorldAppTest;
import fnt.hu.nl.automatischNakijken.util.FolderChecker;
import fnt.hu.nl.automatischNakijken.util.TestRunner;
import fnt.hu.nl.automatischNakijken.util.URIClassLoader;

public class JUnitEvaluator extends AutomaticCheck {

	private String classNameToTest;
	private String pathToClass;
	private String pathToClassFolder;
	private Grade grade;
	private String name;

	public JUnitEvaluator(String name, boolean isFailable, Solution s,
			String classNameToTest, String pathToClass, String pathToClassFolder) {
		super(name, isFailable);
		this.name = name;
		this.classNameToTest = classNameToTest;
		this.pathToClass = pathToClass;
		this.pathToClassFolder = pathToClassFolder;
	}

	@Override
	public SolutionEvaluationCriteria runCheck(Solution s) {
		runJUnit();
		SolutionEvaluationCriteria criteria = new SolutionEvaluationCriteria(
				name, grade);
		for (Student student : s.getStudents()) {

			System.out.println("Assignment uploaded by "
					+ student.getFullName() + " " + student.getEmail()
					+ " Evaluator: " + name.toString());
			for (SolutionFile file : s.getFiles()) {
				System.out
						.println("File that got evaluated " + file.toString());
			}
			System.out.println("Evaluated on "
					+ s.getTimeOfSubmission().getTime());
			System.out.println("Result: " + grade);

		}
		return criteria;

	}

	public void runJUnit() {
		TestRunner runner = new TestRunner();
		HelloWorldAppTest instance = new HelloWorldAppTest();
		URIClassLoader UriClassLoader = new URIClassLoader();
		FolderChecker.removeFilesWithClassExtension(pathToClassFolder);
		UriClassLoader.compileJavaSourceFile(pathToClass);
		instance.setClassName(classNameToTest);
		instance.setPathToClass(pathToClassFolder);
		runner.runClass(instance.getClass());
		grade = runner.getGrade();
		

	}

}
