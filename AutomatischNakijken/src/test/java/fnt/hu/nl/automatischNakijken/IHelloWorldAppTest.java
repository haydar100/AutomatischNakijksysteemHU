package fnt.hu.nl.automatischNakijken;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import fnt.hu.nl.automatischNakijken.Logic.URIClassLoader;
import fnt.hu.nl.opdracht.IHelloWorldApp;

public class IHelloWorldAppTest {

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
		assertEquals(aapje.getHello(), "Hello World pikkenbaas123");
	}

}
