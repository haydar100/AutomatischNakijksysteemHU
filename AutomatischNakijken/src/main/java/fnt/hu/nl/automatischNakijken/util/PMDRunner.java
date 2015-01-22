package fnt.hu.nl.automatischNakijken.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import fnt.hu.nl.automatischNakijken.domain.AutomaticCheck;
import net.sourceforge.pmd.PMD;

public class PMDRunner extends AutomaticCheck {
	public PMDRunner(String name, boolean isFailable) {
		super(name, isFailable);
		// TODO Auto-generated constructor stub
	}

	String codeToCheck;
	String customRuleSet;

	public void callPmd(String codeToCheck) throws IOException {
		PrintStream out = System.out;
		PrintStream err = System.err;
		ByteArrayOutputStream Byteout = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(Byteout);
		System.setOut(ps);

		String RuleSet = "rulesets/internal/all-java.xml"; // if needed you can create your own .XML file and use it
		String[] args = { "-d", codeToCheck, "-rulesets", RuleSet };
		PMD.run(args);
		System.setOut(out);
		Byteout.close();
		String linesOut[] = Byteout.toString().split("\\r?\\n"); // linesOut
																	// staat de
																	// volledige
																	// output
		List<String> rowsOut = new ArrayList<String>();
		for (String line : linesOut) {
			if (!line.isEmpty()
					&& line.indexOf("Removed misconfigured rule") == -1 // remove the package warning it is not an error that should be counted
					&& line.indexOf("suppressed by Annotation") == -1
					&& line.indexOf("No problems found!") == -1
					&& line.indexOf("Error while processing") == -1) {
				rowsOut.add(line);
			}
		}
		System.out.println("PMD Found " + rowsOut.size() + " problems in " + codeToCheck );
		for (String error : rowsOut) {
			System.out.println(error);
		}

	}

}