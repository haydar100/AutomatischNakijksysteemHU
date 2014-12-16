package fnt.hu.nl.automatischNakijken.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtil {
	private final static Logger _logger = Logger.getLogger(FileUtil.class.getName());
	
	public static String getContentFromFile(File file){
		try{
			FileReader fr = new FileReader(file.getAbsolutePath()); 
			BufferedReader br = new BufferedReader(fr); 
			String line;
			String fileContent = "";
			//Build string representation of file
			while((line = br.readLine()) != null)
			{ 
				fileContent += line +"\n";
			}
			fr.close();
			br.close();
			return fileContent;
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			_logger.log(Level.WARNING, "Reading content from file at location " + file.getAbsolutePath() + " failed");
			return null;
		}
	}
	
	public static void writeContentToFile(File file, String content){
		try{
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			fw.write(content);
			fw.close();
		}
		catch(IOException ioe){
			_logger.log(Level.WARNING, "Writing content to file at location " + file.getAbsolutePath() + " failed");
		}
	}
}
