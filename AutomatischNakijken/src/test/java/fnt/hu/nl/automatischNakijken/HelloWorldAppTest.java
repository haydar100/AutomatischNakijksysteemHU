/*package fnt.hu.nl.automatischNakijken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class HelloWorldAppTest extends TestCase {
	
	private Class clazz;
	private Method method;

	public HelloWorldAppTest(Class clazz, Method method) {
		this.clazz = clazz;
		this.method = method;
	}
	
	

	@Parameters
	public static Collection<Object[]> classesAndMethods()
			throws NoSuchMethodException, SecurityException {
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] { HelloWorldApp.class, HelloWorldApp.class.getDeclaredMethod("getHello") });
		return list;
	}
	
	@Test
	public void testMethodA() throws NoSuchMethodException, SecurityException {
	Method m = HelloWorldApp.class.getDeclaredMethod("getHello");
	Object k;
	try {
		k = HelloWorldApp.class.newInstance();
		
		assertEquals("Hello world !", m.invoke(k));
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	
	}

}*/