package fnt.hu.nl.automatischNakijken.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import fnt.hu.nl.automatischNakijken.util.URIClassLoader;
import fnt.hu.nl.opdracht.IHelloWorldApp;

public class IHelloWorldAppTest extends TestCase {
	public static String className;
	public static String pathToClass;

	/**
	 * 
	 */
	public IHelloWorldAppTest() {
		super();
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

	/**
	 * @return the pathToClass
	 */
	public String getPathToClass() {
		return pathToClass;
	}

	/**
	 * @param pathToClass
	 *            the pathToClass to set
	 */
	public void setPathToClass(String pathToClass) {
		this.pathToClass = pathToClass;
	}

	
	@Test
	public void testMethodA() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		URIClassLoader test = new URIClassLoader();
		Class loadedClass = test.loadCompiledClass(className, pathToClass);
		IHelloWorldApp ihwp = ((IHelloWorldApp) loadedClass.newInstance());
		assertEquals(ihwp.getHello(), ihwp.getHello());
	}
	
	


	
	

}
