package fnt.hu.nl.automatischNakijken.logic;

import java.util.HashMap;
import java.util.Map;

import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;

public class ExtensionMapping {
	private static Map<TargetLanguage, String> extensionMap;
	static{
		extensionMap = new HashMap<TargetLanguage, String>();
		extensionMap.put(TargetLanguage.Java, ".java");
	};
	
	public static String getExtension(TargetLanguage tl){
		return extensionMap.get(tl);
	}
}
