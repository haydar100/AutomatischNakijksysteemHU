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
		for (Student student : s.getStudents()) {
			System.out.println(student.getFullName());
		}
		SolutionEvaluationCriteria criteria = new SolutionEvaluationCriteria(
				name, grade);
		System.out.println(name.toString());
		return criteria;

	}

	public void runJUnit() {
		TestRunner runner = new TestRunner();
		IHelloWorldAppTest instance = new IHelloWorldAppTest();
		URIClassLoader UriClassLoader = new URIClassLoader();
		FolderChecker.removeFilesWithClassExtension(pathToClassFolder);
		UriClassLoader.compileJavaSourceFile(pathToClass);
		instance.setClassName(classNameToTest);
		instance.setPathToClass(pathToClassFolder);
		runner.runClass(instance.getClass());
		grade = runner.getGrade();
		System.out.println(grade);

	}

}
