package fnt.hu.nl.automatischNakijken.logic;

import java.util.ArrayList;
import java.util.List;

//This class defines the template of the algorithm of a lexical analyser used in the tokenizing proces
//Any languagespecific steps can be overridden in the concrete implementations.
public abstract class Lexer {
	//Used for checking end of strings
	protected static final String _punctuations = ",.:;<>(){}!=";
	private TokenMapping _mapping;
	
	public Lexer(TokenMapping mapping){
		this._mapping = mapping;
	}
	
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
				TokenType type = _mapping.getCharTokenType(currentCharacter);
				if(type != null){
					Token token = new Token(type, String.valueOf(currentCharacter));
					results.add(token);
					index++;
				}
				else{
					String atom = getAtom(fileContent, index);
					int length = atom.length();
					if(length > 0){
						type = _mapping.getWordTokenType(atom);
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
	
	//Language specific. Checks whether something is a word. Depends on language literal notation.
	protected abstract String getAtom(String fileContent, int startIndex);
}
