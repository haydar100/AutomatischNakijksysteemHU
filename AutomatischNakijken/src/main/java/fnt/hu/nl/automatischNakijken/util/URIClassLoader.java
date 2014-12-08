package fnt.hu.nl.automatischNakijken.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.tools.*;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import com.sun.org.apache.bcel.internal.util.SyntheticRepository;

public class URIClassLoader {

	public URIClassLoader() {

	}
	

	public void compileJavaSourceFile(String sourcePath) throws MalformedURLException {
		File sourceFile = new File(sourcePath);
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, sourceFile.getPath());
		if (result == 0) {
			System.out.println("Compiled...." + " " + sourceFile.getPath() + " Succesfully.");
		} else {
			System.out.println("Compile error" + " "+ sourceFile.getPath());
		}
	}
	
	
	public void executeTests() {
	
	}
	

	
	
	public Class<?> loadCompiledClass(String className, String rootFolder) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		File root = new File(rootFolder);
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
		Class<?> cls = Class.forName(className, true, classLoader);
		return cls;
		
	}
	
	
	
	/*private static void printLines(String name, InputStream ins) throws Exception {
	    String line = null;
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(ins));
	    while ((line = in.readLine()) != null) {
	        System.out.println(name + " " + line);
	    }
	  }

	public void compileJava() throws Exception {
		Process pro1 = Runtime
				.getRuntime()
				.exec("javac C:/Users/Berkan/Desktop/test/HelloWorldApp.java");
		// hardcoded.
		printLines("stdout", pro1.getInputStream());
		printLines("stderr", pro1.getErrorStream());

		System.out.println("Compiling");
		pro1.waitFor();
	}
	

	public Class<?> loadClass(String classFolder, String className) {
		Class<?> loadedClass = null;
		try {
			File f = new File(classFolder);
			URL url = f.toURI().toURL();
			URL[] urls = new URL[] { url };
			ClassLoader cl = new URLClassLoader(urls);
			loadedClass = cl.loadClass(className);
			if (loadedClass != null) {
				System.out.println(loadedClass.getName().toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return loadedClass;
	}*/
}
