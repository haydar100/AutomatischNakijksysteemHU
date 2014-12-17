package fnt.hu.nl.automatischNakijken.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import fnt.hu.nl.automatischNakijken.domain.ClassBluePrint;
import fnt.hu.nl.automatischNakijken.util.PMDRunner;
import fnt.hu.nl.automatischNakijken.util.ReflectionUtil;
import fnt.hu.nl.automatischNakijken.util.URIClassLoader;
import fnt.hu.nl.opdracht.HelloWorldApp;
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
	public void testMethodBReflection() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		URIClassLoader test = new URIClassLoader();
		Class loadedClass = test.loadCompiledClass(className, pathToClass);
		List<String> methods = new ArrayList<String>();
		List<String> methods2 = new ArrayList<String>();
		Method m = loadedClass.getDeclaredMethod("getHello");
		List<Method> methodsObj = new ArrayList<Method>();
		methodsObj.add(m);

		Method m1 = loadedClass.getDeclaredMethod("getHello");
		// Method m2 = hwa.getHello();
		Object k = loadedClass.newInstance();
		ReflectionUtil.getNameOfMethodObj(m);
		methods.add(ReflectionUtil.getNameOfMethodObj(m));
		methods2.add(ReflectionUtil.getNameOfMethodObj(m));
		ClassBluePrint HelloWorldApp = new ClassBluePrint("HelloWorldApp",
				methods2);
		ReflectionUtil cheese = new ReflectionUtil(loadedClass, methodsObj,
				HelloWorldApp);
		if (cheese.checkClassName()) {
			if (ReflectionUtil.compareMethodLists(methods, methods2)) {
				assertEquals("Hey jij daar", m.invoke(k));
			}
		}

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
