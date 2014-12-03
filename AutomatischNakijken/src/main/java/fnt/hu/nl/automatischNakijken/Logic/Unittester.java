package fnt.hu.nl.automatischNakijken.Logic;

import java.net.MalformedURLException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;

public class Unittester {

	public String classFolder;
	public String className;
	public Class loadedClass;
	public Object instanceOfClass;

	URIClassLoader mcl = new URIClassLoader();

	/**
	 * @return the classFolder
	 */
	public String getClassFolder() {
		return classFolder;
	}

	/**
	 * @param classFolder
	 *            the classFolder to set
	 */
	public void setClassFolder(String classFolder) {
		this.classFolder = classFolder;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}


	public void loadClassToBeTested(String className, String rootFolder) {
		try {
			loadedClass = mcl.loadCompiledClass(className, rootFolder);
			instanceOfClass = loadedClass.newInstance();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runTestCase(Class<?> testCase) throws InstantiationException, IllegalAccessException {
		
		if (testCase != null) {
			Result result = JUnitCore.runClasses(testCase);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}

	}


}
