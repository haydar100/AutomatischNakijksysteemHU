package fnt.hu.nl.automatischNakijken.logic;

import java.io.File;
import java.io.IOException;
import java.util.List;

import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;
import fnt.hu.nl.automatischNakijken.util.FileUtil;

//Defines the code conversion methods
public abstract class SourceCodeConverter {
		protected Lexer _lexer;
		private final String _newExtension = ".tff";
		private final String _languageExtension;
		
		public SourceCodeConverter(TargetLanguage tl){
			this._languageExtension = ExtensionMapping.getExtension(tl);
		}
		//This method will steer the control flow for converting a file to its tokenised form
		public File convertSourceCode(File originalFile) {
			File tokenisedFile = null;
			tokenisedFile = createNormalisedEmptyFile(originalFile);
			writeNormalisedFile(originalFile, tokenisedFile);
			return tokenisedFile;
		}
		
		//This method will create a copied file for the tokenised form
		private File createNormalisedEmptyFile(File from){
			String filePath = from.getAbsolutePath();
			String newFilePath = filePath.replaceAll(_languageExtension, _newExtension);
			File to = new File(newFilePath); 
			
			if (!to.exists()) {
				try{
					to.createNewFile();
				}
				catch(IOException ioe){
					ioe.printStackTrace();
					System.out.println("Creating a new file for tokenising failed");
				}
			}
			return to;
		}
		
		//This method will fill in the newly created file
		private void writeNormalisedFile(File originalFile, File fileToNormalise){
			if(this._lexer == null){
				throw new IllegalStateException("Lexer must be initialized");
			}
			String fileContent = FileUtil.getContentFromFile(originalFile);
			fileContent = removeCommentBlocksFromContent(fileContent);
			fileContent = removeImportStatements(fileContent);
			fileContent = removePackageName(fileContent);
			List<Token> tokens = _lexer.tokeniseSourceFile(fileContent);
			String resultContent = "";
			//Split in lines 
			for(Token token : tokens)
				resultContent += token.toString() + "\n";
			FileUtil.writeContentToFile(fileToNormalise, resultContent);
		}
		//Define languagespecific templatemethods
		protected abstract String removeCommentBlocksFromContent(String fileContent);
		protected abstract String removeImportStatements(String fileContent);
		protected abstract String removePackageName(String fileContent);
}
