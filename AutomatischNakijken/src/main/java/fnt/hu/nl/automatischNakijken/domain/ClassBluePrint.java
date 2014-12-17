package fnt.hu.nl.automatischNakijken.domain;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassBluePrint {
	public String className;
	public List<Method> methods = new ArrayList<Method>();

	public ClassBluePrint(String className, List<Method> methods) {
		super();
		this.className = className;
		this.methods = methods;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

}
