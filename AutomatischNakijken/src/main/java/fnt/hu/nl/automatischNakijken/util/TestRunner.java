/**
 * 
 */
package fnt.hu.nl.automatischNakijken.util;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Berkan
 *
 */
public class TestRunner {

	public void runClass(Class testClass) {
		Result result = JUnitCore.runClasses(testClass);
		System.out.println("JUnit runner initialized the following JUnit testclass: "
				+ testClass.getName());

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());

		}
		if (result.wasSuccessful()) {
			System.out.println("Assignment checked.. no error could be found");
		}
	}
}
