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
			String fileContent = "";
			//Build string representation to check for multiline operations 
			while((line = br.readLine()) != null)
			{ 
				fileContent += line +"\n";
			}
			fileContent = removeCommentBlocksFromContent(fileContent);
			fileContent = removeImportStatements(fileContent);
			
			//Split in lines and execute single line operations
			String[] lines = fileContent.split("\\n");
			for(String temp : lines)
			{
				temp = removeWhiteSpaces(temp);
				if(temp != null)
					fw.write(temp + "\n");
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
	
	//This method removes import statements from the source file
	private String removeImportStatements(String fileContent) {
		String outputContent = fileContent.replaceAll("import.*;", "");
		return outputContent;
	}

	//This method will return a String if it has any content after removing whitespace and null otherwise.
	private String removeWhiteSpaces(String lineToCheck){
		lineToCheck.trim();
		//Only return a string when the line is not empty
		if(!lineToCheck.matches("\\s*")){
			String formattedLine = lineToCheck.replaceAll("\t", "");
			return formattedLine;	
		}
		return null;
	}
	
	//This method will normalise variable names to X 
	private String normaliseVariableNames(String lineToCheck){
		return null;
	}
	
	//This method removes the comments from a source file 
	private String removeCommentBlocksFromContent(String inputContent){
		String outputContent;
		outputContent = inputContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
		return outputContent;
	}
}
