package fnt.hu.nl.automatischNakijken.logic;

public class JavaLexer extends Lexer {
	public JavaLexer(TokenMapping mapping) {
		super(mapping);
	}

	protected String getAtom(String fileContent, int startIndex) {
	 	char currentChar;
        int cursor = startIndex;
        //String literal or char needs to continue through punctuations until a whitespace or closing punctuation is detected
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
	            if(!Character.isWhitespace(currentChar) && !_punctuations.contains(String.valueOf(currentChar))) {
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
