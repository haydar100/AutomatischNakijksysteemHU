package fnt.hu.nl.automatischNakijken.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import junit.*;

import fnt.hu.nl.automatischNakijken.domain.ClassBluePrint;

public class ReflectionUtil {
	private Class<?> clazz;
	private List<Method> methodsFromInstance;
	public ClassBluePrint blueprint;
	public URIClassLoader classLoader;

	public ReflectionUtil(Class<?> clazz, List<Method> methodsFromInstance,
			ClassBluePrint blueprint) {
		super();
		this.clazz = clazz;
		this.methodsFromInstance = methodsFromInstance;
		this.blueprint = blueprint;
	}

	public List<String> getMethodsNamesFromBluePrint() {
		return blueprint.getMethods();
	}
	
	public static String getNameOfMethodObj(Method method) {
		return method.getName();
	}
	

	public Class<?> loadClassToReflect(String className, String rootFolder) {
		clazz = classLoader.loadCompiledClass(className, rootFolder);
		return clazz;
	}

	public List<String> getMethodsFromInstance() {
		List<String> allMethods = new ArrayList<String>();
		for (Method m : clazz.getDeclaredMethods()) {
			String name = m.getName();
			allMethods.add(name);
		}
		return allMethods;
	}

	public boolean checkClassName() {
		if (clazz.getName().equals(blueprint.getClassName())) {
			return true;
		}
		return false;
	}
	
	

	public static boolean compareMethodLists(List<String> methodsFromBluePrint,
			List<String> methodsFromInstance) {
		if (methodsFromBluePrint == null && methodsFromInstance == null)
			return true;
		if (methodsFromBluePrint != null && methodsFromInstance != null) {
			if (methodsFromBluePrint.size() == methodsFromInstance.size()) {
				for (String s : methodsFromBluePrint) {
					boolean isEqual = false;
					for (String s1 : methodsFromInstance) {
						if (s.equals(s1)) {
							isEqual = true;
							break;
						}
					}
					if (!isEqual)
						return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * @return the method
	 */
	public List<Method> getMethods() {
		return methodsFromInstance;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethods(List<Method> method) {
		this.methodsFromInstance = method;
	}

	public String getNameOfClass() {
		return clazz.getName();
	}

}
