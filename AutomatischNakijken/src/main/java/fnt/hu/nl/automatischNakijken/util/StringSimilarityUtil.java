package fnt.hu.nl.automatischNakijken.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import fnt.hu.nl.automatischNakijken.logic.Match;
import fnt.hu.nl.automatischNakijken.logic.StringItem;
import fnt.hu.nl.automatischNakijken.logic.StringWrapper;

public class StringSimilarityUtil {
	private static List<Match> greedyStringTiling(StringWrapper pattern, StringWrapper text, int minimumMatchLength){
		List<Match> tiles = new ArrayList<Match>();
		List<Match> matches = new ArrayList<Match>();
		int maximumMatchLength = minimumMatchLength;
		List<StringItem> patternItems = pattern.getStringItems();
		List<StringItem> textItems = text.getStringItems();
		
		//Loop over all items for the pattern and subsequently for the the text
		for(int patternIndex = 0; patternIndex < patternItems.size(); patternIndex++){
			for(int textIndex = 0; textIndex < textItems.size(); textIndex++){
				
				int count = 0;
				boolean check = false;
				
				//While the file has not yet been completely checked and the current stringitems match, mark pairs
				while(!check && patternItems.get(patternIndex + count).getContent() == textItems.get(textIndex + count).getContent()){
					//if the pair has been marked already, skip the other operations
					if(patternItems.get(patternIndex).isMarked() && textItems.get(textIndex).isMarked()){
						break;
					}
					count++;
					//Check if the end of the pattern string has been reached
					if (!((count + patternIndex) < pattern.getStringItems().size()))
	                {
						//Break loop if the end of pattern has been reached
	                    check = true;
	                }
	                else
	                {
	                    pattern.getStringItems().get(count + patternIndex).setMarked(true);
	                }
					//Check if the end of the text string has been reached
	                if (!((count + textIndex) < text.getStringItems().size()))
	                {
	                	//Break loop if the end of text as been reached
	                    check = true;
	                }
	                else
	                {
	                	text.getStringItems().get(count + textIndex).setMarked(true);
	                }
				}
				//Only add the match when it exceeds the length required for it to specify as a match
				if (count >= maximumMatchLength)
	            {
	                String value = "";
	                //Build string representation of the StringItems that make up the match
	                for (int z = 0; z < count; z++)
	                {
	                	String temp = String.valueOf(pattern.getStringItems().get(patternIndex + z).getContent());
	                    value += temp;
	                }

	                matches.add(new Match(patternIndex, textIndex, count, value));
	            }
			}
		}
			
		//Mark similar matches and add these to the tile list
		for(Match match : matches){
			for(int matchIndex = 0; matchIndex < maximumMatchLength - 1; matchIndex++){
				pattern.getStringItems().get(matchIndex).setMarked(true);
				text.getStringItems().get(matchIndex).setMarked(true);
			}
			tiles.add(match);
		}
		return tiles;
	}
	
	public static double calculateSimilarityPercentage(String pattern, String text, int minimumMatchLength){
		if(pattern.isEmpty() || text.isEmpty())
			throw new IllegalArgumentException("pattern and text must have a value");
		List<Match> tiles = greedyStringTiling(new StringWrapper(pattern), new StringWrapper(text), minimumMatchLength);
		
		double smallestStringLength;
		if(text.length() > pattern.length()){
			smallestStringLength = pattern.length();
		}
		else{
			smallestStringLength = text.length();
		}
		
		double totalMatchLength = 0.0;
		for(Match match : tiles){
			totalMatchLength += match.getLength();
		}
		return totalMatchLength/smallestStringLength * 100;
	}
	
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
