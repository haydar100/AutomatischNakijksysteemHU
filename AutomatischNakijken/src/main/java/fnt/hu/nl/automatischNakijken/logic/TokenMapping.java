package fnt.hu.nl.automatischNakijken.logic;

import java.util.Map;

public abstract class TokenMapping {
	protected Map<Character, TokenType> charTokenMap;
	protected Map<String, TokenType> wordTokenMap;
	
	public TokenType getCharTokenType(char c){
		return charTokenMap.get(c);
	}
	
	public TokenType getWordTokenType(String s){
		TokenType type = wordTokenMap.get(s);
		if(type == null)
			type = TokenType.ATOM;
		return type;
	}
}
