package fnt.hu.nl.automatischNakijken.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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
	
	
	public static long getSize(File file) {
	    long size;
	    if (file.isDirectory()) {
	        size = 0;
	        for (File child : file.listFiles()) {
	            size += getSize(child);
	        }
	    } else {
	        size = file.length();
	    }
	    return size;
	}
	
	public static String getReadableSize(long size) {
	    if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups))
	            + " " + units[digitGroups];
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
