package fnt.hu.nl.automatischNakijken.logic;

import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;

//This class will transform a Java source file to a tokenised form
public class JavaConverter extends SourceCodeConverter{
	
	public JavaConverter(TargetLanguage tl){
		super(tl);
		this._lexer = new JavaLexer(new JavaTokenMapping());
	}
	//This method removes the package name from the file
	protected String removePackageName(String fileContent) {
		String outputContent = fileContent.replaceAll("^package.*;", "");
		return outputContent;
	}

	//This method removes import statements from the source file
	protected String removeImportStatements(String fileContent) {
		String outputContent = fileContent.replaceAll("import.*;", "");
		return outputContent;
	}
	
	//This method removes the comments from a source file 
	protected String removeCommentBlocksFromContent(String inputContent){
		String outputContent;
		outputContent = inputContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
		return outputContent;
	}
}
