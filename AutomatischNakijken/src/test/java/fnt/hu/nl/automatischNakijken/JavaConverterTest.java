package fnt.hu.nl.automatischNakijken;

import java.io.File;

import fnt.hu.nl.automatischNakijken.Logic.*;
import junit.framework.Assert;
import junit.framework.TestCase;

public class JavaConverterTest extends TestCase {

	public void testConvertSourceCode() {
		//Arrange
		String filePath = "/Users/roystraub/Desktop/Class.java";
		String newFilePath = "/Users/roystraub/Desktop/Class.tff";
		File file = new File(filePath);
    	SourceCodeConverter converter = new JavaConverter();
    	
    	//Act
    	File result = converter.convertSourceCode(file);
    	
    	//Assert
    	assertTrue(result != null);
    	assertTrue(result.getPath().equals(newFilePath));
	}

}
