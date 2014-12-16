package fnt.hu.nl.automatischNakijken.util;

import net.sourceforge.pmd.PMD;

public class PMDRunner {
	String codeToCheck;
	String customRuleSet;

	public static void callPmd(String codeToCheck) {

		//String checkThisCode = "C:/Users/Berkan/Desktop/test/HelloWorldApp.java";
		String RuleSet = "rulesets/internal/all-java.xml";
		String[] args = {"-d", codeToCheck, "-rulesets",
				RuleSet };
		PMD.run(args);
		
	}
	
	public void streamOutput() {
		// TODO de stream capturen en dan laten wegschrijven
	}
}