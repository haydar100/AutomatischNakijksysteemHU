package fnt.hu.nl.automatischNakijken.util;

import org.apache.commons.lang.StringUtils;

public class StringSimilarityUtil {
	public static double calculateSimilarityPercentage(String s1, String s2){
		String  longer = s1, shorter = s2;
		if (s1.length() < s2.length()) { // longer should always have greater length
			longer = s2; shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0) { 
			return 1.0;
		}
		return ((longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) / (double) longerLength)*100;
	}
}
