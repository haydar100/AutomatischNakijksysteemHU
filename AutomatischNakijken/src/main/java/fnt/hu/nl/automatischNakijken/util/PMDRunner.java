package fnt.hu.nl.automatischNakijken.util;

import net.sourceforge.pmd.PMD;

public class PMDRunner {

	public static void callPmd() {

		String checkThisCode = "C:/Users/Berkan/Desktop/test/HelloWorldApp.java";
		String customRuleSet = "rulesets/internal/all-java.xml";
		String[] args = {"-d", checkThisCode, "-rulesets",
				customRuleSet };
		PMD.run(args);
		
	}
	
	public void streamOutput() {
		// TODO de stream capturen en dan laten wegschrijven
	}
}