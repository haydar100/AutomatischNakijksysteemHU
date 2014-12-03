package fnt.hu.nl.automatischNakijken;

import java.net.MalformedURLException;

import junit.framework.TestCase;

import org.junit.Test;

import fnt.hu.nl.automatischNakijken.Logic.URIClassLoader;
import fnt.hu.nl.automatischNakijken.Logic.Unittester;

public class HelloWorldAppTest extends TestCase {
	public Class<?> loadedClass;

	@Test
	public void testOutput() throws MalformedURLException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Object hwp = new HelloWorldApp();
		Unittester ut = new Unittester();
		URIClassLoader uricl = new URIClassLoader();
		uricl.compileJavaSourceFile("C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java\\");
		loadedClass = uricl.loadCompiledClass("HelloWorldApp",
				"C:\\Users\\Berkan\\Desktop\\test");
		hwp = loadedClass.newInstance();
		
		System.out.println(hwp.toString());
		assertEquals("Hello World !123", hwp.toString());

	}

}