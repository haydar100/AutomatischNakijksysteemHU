package fnt.hu.nl.automatischNakijken.util;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FolderChecker {
	private final Logger logger = Logger.getLogger(URIClassLoader.class
			.getName());
	
	public static void removeFilesWithClassExtension(String folderUrl) {
		File folder = new File(folderUrl);
		File fileList[] = folder.listFiles();
		for (File f : folder.listFiles()) {
			if (f.getName().endsWith(".class")) {
				System.out.println("Deleting files in the following directory.." + " " + folder.getParent());
				System.out.println(f.getName()+ " has been deleted");
				f.delete();
			}
		}
	}
}
