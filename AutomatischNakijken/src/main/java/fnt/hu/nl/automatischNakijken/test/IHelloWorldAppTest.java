package fnt.hu.nl.automatischNakijken.test;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import fnt.hu.nl.opdracht.IHelloWorldApp;
import fnt.hu.nlautomatischNakijken.util.URIClassLoader;

public class IHelloWorldAppTest extends TestCase{

	@Test
	public void testMethodA() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		URIClassLoader test = new URIClassLoader();
		/*test.compileJavaSourceFile("C:\\Users\\Berkan\\Desktop\\test\\IHelloWorldApp.java");*/
		test.compileJavaSourceFile("C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java");
		Class kaas = test.loadCompiledClass("HelloWorldApp",
				"C:\\Users\\Berkan\\Desktop\\test\\");
		
		//System.out.println(((IHelloWorldApp)kaas.newInstance()).getHello());
		IHelloWorldApp aapje = ((IHelloWorldApp)kaas.newInstance()); 
		assertEquals(aapje.getHello(), "Hello World pissdbaas123");
		
	}

}
