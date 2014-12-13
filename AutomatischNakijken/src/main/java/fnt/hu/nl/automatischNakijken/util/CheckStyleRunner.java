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
	public static void run(Object testClassInstance,
			final String folderToCheck, String ruleFileName)
			throws FileNotFoundException, CheckstyleException {

		File fileFolderToCheck = new File(folderToCheck);

		List<File> files = new ArrayList<File>();
		FolderChecker.listFiles(files, fileFolderToCheck, "java");
		ByteArrayOutputStream sos = new ByteArrayOutputStream();
		AuditListener listener = new DefaultLogger(sos, false);

		InputSource inputSource = new InputSource(testClassInstance.getClass()
				.getResourceAsStream(ruleFileName));

		Configuration configuration = ConfigurationLoader.loadConfiguration(
				inputSource, new PropertiesExpander(System.getProperties()),
				false);

		Checker checker = checkerConfiguration(listener, configuration);
		int errors = checker.process(files);
		System.out.println("CheckStyle has found " + errors + "" +  " Errors");
		System.out.println(sos.toString());

		checker.destroy();

	}

	private static Checker checkerConfiguration(AuditListener listener,
			Configuration configuration) throws CheckstyleException {
		Checker checker = new Checker();
		checker.setModuleClassLoader(Checker.class.getClassLoader());
		checker.configure(configuration);
		checker.addListener(listener);
		return checker;
	}

}