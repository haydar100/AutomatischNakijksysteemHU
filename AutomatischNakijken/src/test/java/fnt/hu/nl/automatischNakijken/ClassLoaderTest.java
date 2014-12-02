package fnt.hu.nl.automatischNakijken;


import java.io.File;
import java.net.URL;

import fnt.hu.nl.automatischNakijken.Logic.MyURIClassLoader;
import junit.framework.TestCase;

public class ClassLoaderTest extends TestCase {
	
	public void testLoadClass() {
		MyURIClassLoader mcl = new MyURIClassLoader();
		mcl.loadClass("");
		
	}

}