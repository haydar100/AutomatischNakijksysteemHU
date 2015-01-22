package fnt.hu.nl.automatischNakijken.test;

import java.io.File;

import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;
import fnt.hu.nl.automatischNakijken.logic.*;
import junit.framework.Assert;
import junit.framework.TestCase;

public class JavaConverterTest extends TestCase {

	public void testConvertSourceCode() {
		//Arrange
		String filePath = "C:\\Users\\Berkan\\Documents\\testfolderRoy\\Class.java";
		String filePathPlagiarised = "C:\\Users\\Berkan\\Documents\\testfolderRoy\\ClassPlagiarised.java";
		String newFilePath = "C:\\Users\\Berkan\\Documents\\testfolderRoy\\Class.tff";
		File file = new File(filePath);
		File plagiarisedFile = new File(filePathPlagiarised);
		
    	SourceCodeConverter converter = new JavaConverter(TargetLanguage.Java);
    	
    	//Act
    	File result = converter.convertSourceCode(file);
    	File second = converter.convertSourceCode(plagiarisedFile);
    	//Assert
    	assertTrue(result != null);
    	assertTrue(result.getPath().equals(newFilePath));
	}

}
