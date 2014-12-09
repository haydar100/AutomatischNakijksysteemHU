package fnt.hu.nl.automatischNakijken.logic;

import java.util.ArrayList;
import java.util.List;

public class JavaLexer implements Lexer {
	
	//Analyses the prepared source content and converts it in to tokens
	public List<Token> tokeniseSourceFile(String fileContent) {
		List<Token> results = new ArrayList<Token>();	
		char currentCharacter;
		//Loop over all characters
		for(int index = 0; index < fileContent.length(); ){
			currentCharacter = fileContent.charAt(index);
			switch(currentCharacter){
				case '(':
					results.add(new Token(TokenType.LPAREN, "("));
					index++;
					break;
				case ')':
					results.add(new Token(TokenType.RPAREN, ")"));
					index++;
					break;	
				case '{':
					results.add(new Token(TokenType.LACCOL, "{"));
					index++;
					break;	
				case '}':
					results.add(new Token(TokenType.RACCOL, "}"));
					index++;
					break;	
				case '<':
					results.add(new Token(TokenType.LCHEV, "<"));
					index++;
					break;
				case '>':
					results.add(new Token(TokenType.RCHEV, ">"));
					index++;
					break;
				case '.':
					results.add(new Token(TokenType.PUNC_PERIOD, "."));
					index++;
					break;	
				case ';':
					results.add(new Token(TokenType.PUNC_SEMICOLON, ";"));
					index++;
					break;
				case '=':
					results.add(new Token(TokenType.EQUALS, "="));
					index++;
					break;
				default:
					if(Character.isWhitespace(currentCharacter)){
						index++;
					}
					else
					{
						String atom = getAtom(fileContent, index);
	                    index += atom.length();
	                    results.add(new Token(TokenType.ATOM, atom));
					}
					break;
			}
		}
		return results;
	}
	
	 public static String getAtom(String fileContent, int startIndex) {
	        int cursor = startIndex;
	        for( ; cursor < fileContent.length(); ) {
	            if(Character.isLetter(fileContent.charAt(cursor))) {
	                cursor++;
	            } 
	            else {
	                return fileContent.substring(startIndex, cursor);
	            }
	        }
	        return fileContent.substring(startIndex, cursor);
	 }
}
