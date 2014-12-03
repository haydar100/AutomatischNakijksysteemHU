package fnt.hu.nl.automatischNakijken;


import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;
import fnt.hu.nl.automatischNakijken.Logic.Unittester;

public class ClassLoaderTest extends TestCase {
	
	public void testOutput() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
    	
		String test = "Hello world!";
		assertEquals("Hello woasd!", "test");
	
		
	}
	

}