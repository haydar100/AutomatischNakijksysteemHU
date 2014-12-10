package fnt.hu.nl.automatischNakijken.logic;

import java.util.ArrayList;
import java.util.List;

public class JavaLexer implements Lexer {
	//Used for checking end of strings
	private static final String _punctionations = ",.:;<>(){}!=";
	
	//Analyses the prepared source content and converts it in to tokens
	public List<Token> tokeniseSourceFile(String fileContent) {
		List<Token> results = new ArrayList<Token>();	
		char currentCharacter;
		//Loop over all characters, preserve meaningful chars 
		for(int index = 0; index < fileContent.length(); ){
			currentCharacter = fileContent.charAt(index);
			if(Character.isWhitespace(currentCharacter)){
				index++;
			}
			else{
				TokenType type = JavaTokenMapping.getCharTokenType(currentCharacter);
				if(type != null){
					Token token = new Token(type, String.valueOf(currentCharacter));
					results.add(token);
					index++;
				}
				else{
					String atom = getAtom(fileContent, index);
					int length = atom.length();
					if(length > 0){
						type = JavaTokenMapping.getWordTokenType(atom);
						Token token = new Token(type, atom);
						results.add(token);
						index += length;
					}
					//Unknow chars get skipped
					else
						index++;
				}
			}
		}
		return results;
	}
	
	 public static String getAtom(String fileContent, int startIndex) {
		 	char currentChar;
	        int cursor = startIndex;
	        //String literal or char needs to continue through punctuations until a whitespace, apostrophe or quote is detected
	        if(fileContent.charAt(startIndex) == '\"' || fileContent.charAt(startIndex) == '\''){
	        	for( ; cursor < fileContent.length(); ) {
		        	currentChar = fileContent.charAt(cursor);
		            if(Character.isWhitespace(currentChar) || (cursor > startIndex && (currentChar == '\"' || currentChar == '\''))) {
		            	cursor++;
		            	 return fileContent.substring(startIndex, cursor);
		            } 
		            else {
		               
		                cursor++;
		            }
		        }
	        }
	        //Non-literals need to stop at punctuations. I.e. "String name," -> "STRING X,"
	        else{
		        for( ; cursor < fileContent.length(); ) {
		        	currentChar = fileContent.charAt(cursor);
		            if(!Character.isWhitespace(currentChar) && !_punctionations.contains(String.valueOf(currentChar))) {
		                cursor++;
		            } 
		            else {
		                return fileContent.substring(startIndex, cursor);
		            }
		        }
	        }
	        return fileContent.substring(startIndex, cursor);
	 }
}
