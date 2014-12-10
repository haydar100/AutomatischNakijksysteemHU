package fnt.hu.nl.automatischNakijken.logic;

//This represents the smallest still relevant information from source code
public class Token {
	public final TokenType type;
	public final String value;
	
	public Token(TokenType type, String value){
		this.type = type;
		this.value = value;
	}
	
	public Token(TokenType type){
		this.type = type;
		this.value = type.toString();
	}
	
	@Override 
	public String toString(){
		if(this.type == TokenType.ATOM)
			return "X";
		return value.toUpperCase();
	}
}
