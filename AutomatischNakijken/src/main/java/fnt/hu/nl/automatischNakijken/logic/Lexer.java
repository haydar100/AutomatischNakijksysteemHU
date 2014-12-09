package fnt.hu.nl.automatischNakijken.logic;

import java.util.List;

//This interface defines the behaviour of a lexical analyser used in the tokenizing proces
public interface Lexer {
	List<Token> tokeniseSourceFile(String fileContent);
}
