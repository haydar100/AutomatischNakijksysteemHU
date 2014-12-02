package fnt.hu.nl.automatischNakijken.Logic;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class MyURIClassLoader {
	
	public MyURIClassLoader() {
		
	}
	public void loadClass(String classesFolder) {
		try {
		File f = new File(classesFolder);
		URL url = f.toURI().toURL();
		URL[] urls = new URL[]{url};
		ClassLoader cl = new URLClassLoader(urls);
		Class cls = cl.loadClass("TestClass");
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}
}
