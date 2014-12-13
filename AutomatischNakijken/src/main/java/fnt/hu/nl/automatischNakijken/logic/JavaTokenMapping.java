package fnt.hu.nl.automatischNakijken.logic;

import java.util.HashMap;
import java.util.Map;

public class JavaTokenMapping {
	private static Map<Character, TokenType> charTokenMap;
	static{
		charTokenMap = new HashMap<Character, TokenType>();
		charTokenMap.put('{', TokenType.LACCOL);
		charTokenMap.put('}', TokenType.RACCOL);
		charTokenMap.put('<', TokenType.LCHEV);
		charTokenMap.put('>', TokenType.RCHEV);
		charTokenMap.put('(', TokenType.LPAREN);
		charTokenMap.put(')', TokenType.RPAREN);
		charTokenMap.put('.', TokenType.PUNC_PERIOD);
		charTokenMap.put(';', TokenType.PUNC_SEMICOLON);
		charTokenMap.put(',', TokenType.PUNC_COMMA);
		charTokenMap.put('+', TokenType.OP_PLUS);
		charTokenMap.put('-', TokenType.OP_MINUS);
		charTokenMap.put('=', TokenType.OP_EQUAL);
		charTokenMap.put('*', TokenType.OP_MUL);
		charTokenMap.put('/', TokenType.OP_DIV);
		charTokenMap.put('%', TokenType.OP_MOD);
	};
	
	private static Map<String, TokenType> wordTokenMap;
	static{
		wordTokenMap = new HashMap<String, TokenType>();
		wordTokenMap.put("public", TokenType.AM_PUBLIC);
		wordTokenMap.put("private", TokenType.AM_PRIVATE);
		wordTokenMap.put("protected", TokenType.AM_PROTECTED);
		wordTokenMap.put("class", TokenType.RW_CLASS);
		wordTokenMap.put("return", TokenType.KW_RETURN);
		wordTokenMap.put("extends", TokenType.RW_EXTENDS);
		wordTokenMap.put("implements", TokenType.RW_IMPLEMENTS);
		wordTokenMap.put("void", TokenType.KW_VOID);
		wordTokenMap.put("String", TokenType.KW_STRING);
		wordTokenMap.put("int", TokenType.KW_INT);
		wordTokenMap.put("List", TokenType.KW_LIST);
		wordTokenMap.put("this", TokenType.RW_THIS);
		wordTokenMap.put("boolean", TokenType.KW_BOOL);
		wordTokenMap.put("true", TokenType.KW_TRUE);
		wordTokenMap.put("false", TokenType.KW_FALSE);
		wordTokenMap.put("char", TokenType.KW_CHAR);
		wordTokenMap.put("for", TokenType.RW_FOR);
		wordTokenMap.put("for", TokenType.RW_FOR);
		wordTokenMap.put("while", TokenType.RW_WHILE);
		wordTokenMap.put("default", TokenType.RW_DEFAULT);
		wordTokenMap.put("if", TokenType.RW_IF);
		wordTokenMap.put("else", TokenType.RW_ELSE);
		wordTokenMap.put("switch", TokenType.RW_SWITCH);
		wordTokenMap.put("case", TokenType.RW_CASE);
		wordTokenMap.put("break", TokenType.RW_BREAK);
		wordTokenMap.put("static", TokenType.RW_STATIC);
		wordTokenMap.put("final", TokenType.RW_FINAL);
	};
	
	public static TokenType getCharTokenType(char c){
		return charTokenMap.get(c);
	}
	
	public static TokenType getWordTokenType(String s){
		TokenType type = wordTokenMap.get(s);
		if(type == null)
			type = TokenType.ATOM;
		return type;
	}
}
