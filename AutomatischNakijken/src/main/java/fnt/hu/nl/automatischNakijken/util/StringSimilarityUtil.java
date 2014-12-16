package fnt.hu.nl.automatischNakijken.util;

import java.util.ArrayList;
import java.util.List;

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
		
		//Detect all similar matches, loop over all items for the pattern and subsequently for the the text
		for(int patternIndex = 0; patternIndex < patternItems.size(); patternIndex++){
			for(int textIndex = 0; textIndex < textItems.size(); textIndex++){
				
				int count = 0;
				boolean check = false;
				
				while(!check && patternItems.get(patternIndex + count).getContent() == textItems.get(textIndex + count).getContent()){
					//if the pair has been marked already, skip the other operations
					if(patternItems.get(patternIndex).isMarked() && textItems.get(textIndex).isMarked()){
						break;
					}
					count++;
					
					if ((count + patternIndex) > pattern.getStringItems().size() - 1)
	                {
	                    check = true;
	                }
	                else
	                {
	                    pattern.getStringItems().get(count + patternIndex).setMarked(true);
	                }

	                if ((count + textIndex) > text.getStringItems().size() - 1)
	                {
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
}
