package fnt.hu.nl.automatischNakijken.domain;

import java.util.ArrayList;
import java.util.List;

public class ClassBluePrint {
	public String className;
	public List<String> methods = new ArrayList<String>();

	public ClassBluePrint(String className, List<String> methods) {
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

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

}
