package fnt.hu.nl.automatischNakijken.logic;

//This represents the smallest still relevant information from source code
public class Token {
	public final TokenType type;
	public final String value;
	
	public Token(TokenType type, String value){
		this.type = type;
		this.value = value;
	}
	
	@Override 
	public String toString(){
		return value;
	}
}
