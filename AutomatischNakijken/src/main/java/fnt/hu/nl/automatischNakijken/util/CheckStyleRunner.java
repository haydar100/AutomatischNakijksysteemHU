package fnt.hu.nl.automatischNakijken.util;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.xml.sax.InputSource;

import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.ConfigurationLoader;
import com.puppycrawl.tools.checkstyle.DefaultLogger;
import com.puppycrawl.tools.checkstyle.PropertiesExpander;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

public abstract class CheckStyleRunner {
	public static void run(final Object testClassInstance,
			final String folderToCheck, final String ruleFileName)
			throws FileNotFoundException, CheckstyleException {

		File fileFolderToCheck = new File(folderToCheck);

		System.out.println("Starting Checkstyle on folder '"
				+ fileFolderToCheck.getAbsolutePath() + "'..");

		if (!fileFolderToCheck.exists()) {
			throw new FileNotFoundException("The folder to check '"
					+ fileFolderToCheck.getAbsolutePath() + "' does not exist.");
		}

		if (!fileFolderToCheck.isDirectory()) {
			throw new FileNotFoundException("The folder to check '"
					+ fileFolderToCheck.getAbsolutePath()
					+ "' is not a directory.");
		}

		List<File> files = new ArrayList<File>();
		listFiles(files, fileFolderToCheck, "java");
		System.out.println("Found " + files.size() + " Java source files.");

		if (files.isEmpty()) {
			Assert.fail("Found no Java source files. Configuration error?");
		}

		ByteArrayOutputStream sos = new ByteArrayOutputStream();
		AuditListener listener = new DefaultLogger(sos, false);

		InputSource inputSource = new InputSource(testClassInstance.getClass()
				.getResourceAsStream(ruleFileName));

		Configuration configuration = ConfigurationLoader.loadConfiguration(
				inputSource, new PropertiesExpander(System.getProperties()),
				false);

		Checker checker = new Checker();
		checker.setModuleClassLoader(Checker.class.getClassLoader());
		checker.configure(configuration);
		checker.addListener(listener);

		int errors = checker.process(files);
		System.out.println("Found " + errors + " check style errors.");
		System.out.println(sos.toString());

		checker.destroy();

	}

	private static void listFiles(final List<File> files, final File folder,
			final String extension) {
		if (folder.canRead()) {
			if (folder.isDirectory()) {
				for (File f : folder.listFiles()) {
					listFiles(files, f, extension);
				}
			} else if (folder.toString().endsWith("." + extension)) {
				files.add(folder);
			}
		}
	}

}