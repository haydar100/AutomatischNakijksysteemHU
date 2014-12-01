package fnt.hu.nl.automatischNakijken.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

//This class will transform a Java source file to a tokenised form
public class JavaConverter implements SourceCodeConverter{
	private final String _javaExtension = ".java";
	private final String _newExtension = ".tff";
	private final Logger logger = Logger.getLogger(JavaConverter.class.getName());
	
	//This method will steer the control flow for converting a file to its tokenised form
	public File convertSourceCode(File originalFile) {
		File tokenisedFile = null;
		tokenisedFile = createNormalisedEmptyFile(originalFile);
		writeNormalisedFile(originalFile, tokenisedFile);
		return tokenisedFile;
	}
	
	//This method will create a copied file for the tokenised form
	private File createNormalisedEmptyFile(File from){
		String filePath = from.getAbsolutePath();
		String newFilePath = filePath.replaceAll(_javaExtension, _newExtension);
		File to = new File(newFilePath); 
		
		if (!to.exists()) {
			try{
				to.createNewFile();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
				logger.log(Level.WARNING, "Creating a new file for tokenising failed");
			}
		}
		return to;
	}
	
	//This method will remove all unnecessary whitespaces from the original file
	private void writeNormalisedFile(File originalFile, File fileToNormalise){
		try{
			FileReader fr = new FileReader(originalFile.getAbsolutePath()); 
			BufferedReader br = new BufferedReader(fr); 
			FileWriter fw = new FileWriter(fileToNormalise.getAbsolutePath()); 
			
			String line;

			while((line = br.readLine()) != null)
			{ 
				String formattedLine = checkLineForContent(line);
				if(formattedLine != null)
				
					//Replace variable names
					fw.write(formattedLine + "\n");	
			}
			fr.close();
			br.close();
			fw.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			logger.log(Level.WARNING, "Accessing files when tokenising failed");
		}
	}
	
	//This method will return a String if it has any content after removing whitespace and single line comments and null otherwise.
	private String checkLineForContent(String lineToCheck){
		lineToCheck.trim();
		String uncommentedLine = lineToCheck.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
		//Only return a string when the line is not empty
		if(!uncommentedLine.matches("\\s*")){
			String formattedLine = uncommentedLine.replaceAll("\t", "");
			return formattedLine;	
		}
		return null;
	}
}
