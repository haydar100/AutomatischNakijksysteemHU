package fnt.hu.nl.automatischNakijken.Logic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class MyClassLoader extends ClassLoader {
	private Hashtable classes = new Hashtable();
	
	
	public Class<?> findClass(String name) {  
	        Class result = null;  
	        result = (Class) classes.get(name); //checks in cached classes  
	        if (result != null) {  
	            return result;  
	        } 
	        return result;
	}

	
	public Class<?> loadClass(String filePath) throws ClassNotFoundException {
		Class<?> cl = null;
		File file = new File(filePath);
		File directory = file.getParentFile();
		try {
			URL url = new URL("file://" + directory.getAbsolutePath());
			URL[] classUrls = { url };
			URLClassLoader classLoader = new URLClassLoader(classUrls);
			cl = Class.forName("Foo", true, classLoader);
			Runnable foo = (Runnable) cl.newInstance();
			foo.run();
			System.out.println("classLoader loaded " + cl.getName());
			try {
				classLoader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cl ;
	
	
		
		
		
	}

}
