package fnt.hu.nl.automatischNakijken.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import fnt.hu.nl.automatischNakijken.domain.ClassBluePrint;

public class ReflectionUtil {
	private Class<?> clazz;
	private List<Method> method;
	public ClassBluePrint blueprint;

	public ReflectionUtil(Class<?> clazz, List<Method> methodsFromInstance,
			ClassBluePrint blueprint) {
		super();
		this.clazz = clazz;
		this.method = methodsFromInstance;
		this.blueprint = blueprint;
	}

	public List<Method> getMethodsFromBluePrint() {
		return blueprint.getMethods();
	}

	public List<Method> getMethodsFromInstance() {
		List<Method> allMethods = new ArrayList<Method>();
		for (Method m : clazz.getDeclaredMethods()) {
			allMethods.add(m);
		}
		return allMethods;
	}

	public boolean checkClassName() {
		if (clazz.getName().equals(blueprint.getClassName())) {
			return true;
		}
		return false;
	}

	public static boolean compareMethodLists(List<Method> methodsFromBluePrint,
			List<Method> methodsFromInstance) {
		if (methodsFromBluePrint == null && methodsFromInstance == null)
			return true;
		if (methodsFromBluePrint != null && methodsFromInstance != null) {
			if (methodsFromBluePrint.size() == methodsFromInstance.size()) {
				for (Method m : methodsFromBluePrint) {
					boolean isEqual = false;
					for (Method m1 : methodsFromInstance) {
						if (m.equals(m1)) {
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
	public List<Method> getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(List<Method> method) {
		this.method = method;
	}

	public String getNameOfClass() {
		return clazz.getName();
	}

}
