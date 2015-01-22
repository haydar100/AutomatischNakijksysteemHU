/**
 * 
 */
package fnt.hu.nl.automatischNakijken.util;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import fnt.hu.nl.automatischNakijken.domain.Grade;

/**
 * @author Berkan
 *
 */
public class TestRunner {
	Grade grade;

	public void runClass(Class testClass) {
		Result result = JUnitCore.runClasses(testClass);
		System.out.println("JUnit runner initialized the following JUnit testclass: "
				+ testClass.getName());

		for (Failure failure : result.getFailures()) {
			System.out.println("Output not correct : " + failure.toString());
			grade = Grade.O;

		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed...");
			grade = Grade.V;
		}
	}

	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
