package fnt.hu.nl.automatischNakijken;


import java.io.File;
import java.net.URL;

import fnt.hu.nl.automatischNakijken.Logic.MyURIClassLoader;
import junit.framework.TestCase;

public class ClassLoaderTest extends TestCase {
	
	public void restCompileJava() {
		MyURIClassLoader mcl = new MyURIClassLoader();
		try {
			mcl.compileJava();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	public void testLoadClass() {
		MyURIClassLoader mcl = new MyURIClassLoader();
		mcl.loadClass("C:\\Users\\Berkan\\Documents\\testfolder", "HelloWorldApp");
		assertTrue(mcl.getClass().getName() != null);
		
		
	}

}