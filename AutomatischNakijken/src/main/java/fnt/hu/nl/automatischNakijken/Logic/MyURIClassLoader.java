package fnt.hu.nl.automatischNakijken.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class MyURIClassLoader {

	public MyURIClassLoader() {

	}
	
	private static void printLines(String name, InputStream ins) throws Exception {
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
				.exec("javac C:/Users/Berkan/Documents/testfolder/HelloWorldApp.java");
		
		printLines("stdout", pro1.getInputStream());
		printLines("stderr", pro1.getErrorStream());
		pro1.waitFor();
	}
	

	public void loadClass(String classFolder, String className) {
		try {
			File f = new File(classFolder);
			URL url = f.toURI().toURL();
			URL[] urls = new URL[] { url };
			ClassLoader cl = new URLClassLoader(urls);
			Class cls = cl.loadClass(className);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
