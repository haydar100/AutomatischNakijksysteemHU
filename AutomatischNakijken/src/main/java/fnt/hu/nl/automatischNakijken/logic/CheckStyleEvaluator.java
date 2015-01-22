package fnt.hu.nl.automatischNakijken.logic;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import fnt.hu.nl.automatischNakijken.domain.AutomaticCheck;
import fnt.hu.nl.automatischNakijken.domain.Grade;
import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluation;
import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluationCriteria;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.test.IHelloWorldAppTest;
import fnt.hu.nl.automatischNakijken.util.CheckStyleRunner;
import fnt.hu.nl.automatischNakijken.util.FolderChecker;
import fnt.hu.nl.automatischNakijken.util.PMDRunner;
import fnt.hu.nl.automatischNakijken.util.TestRunner;
import fnt.hu.nl.automatischNakijken.util.URIClassLoader;
import fnt.hu.nl.opdracht.IHelloWorldApp;

public class CheckStyleEvaluator extends AutomaticCheck {

	private String classNameToTest;
	private String pathToClassFolder;
	private Grade grade;
	private String name;

	public CheckStyleEvaluator(String name, boolean isFailable, Solution s,
			String classNameToTest, String pathToClassFolder) {
		super(name, isFailable);
		this.name = name;
		this.classNameToTest = classNameToTest;
		this.pathToClassFolder = pathToClassFolder;
	}

	@Override
	public SolutionEvaluationCriteria runCheck(Solution s) {
		try {
			runCheckStyle();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CheckstyleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student student : s.getStudents()) {
			System.out.println(student.getFullName());
		}
		SolutionEvaluationCriteria criteria = new SolutionEvaluationCriteria(
				name, grade);
		System.out.println(name.toString());
		return criteria;

	}

	private String runCheckStyle() throws FileNotFoundException,
			CheckstyleException, InstantiationException, IllegalAccessException {
		URIClassLoader test = new URIClassLoader();
		java.lang.Class<?> loadedClass = test.loadCompiledClass(
				classNameToTest, pathToClassFolder);
		IHelloWorldApp ihwp = ((IHelloWorldApp) loadedClass.newInstance());
		CheckStyleRunner csr = new CheckStyleRunner();
		csr.run(ihwp, pathToClassFolder, "checkstyle.xml");
		grade = csr.grade();
		System.out.println(grade.toString());
		return grade.toString();
	}

}
