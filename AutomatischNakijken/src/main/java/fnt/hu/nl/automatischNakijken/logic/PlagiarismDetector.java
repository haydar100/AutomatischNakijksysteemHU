package fnt.hu.nl.automatischNakijken.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Collections;
import fnt.hu.nl.automatischNakijken.domain.*;

public class PlagiarismDetector {
	private SourceCodeConverter _converter;
	private SolutionRepository _repository;
	private List<SolutionSimilarity> _sortedSimilarities;
	
	public PlagiarismDetector(SourceCodeConverter converter, SolutionRepository repository){
		this._converter = converter;
		this._repository = repository;
	}
	
	public void startPlagiarismDetection(){
		prepareSolutions(_repository.getSolutions());
		List<SolutionSimilarity> results = detectSimilarities();
		this._sortedSimilarities = sortSimilarities(results);
	}
	
	//Tokenise all the solutions and all of their underlying files
	private void prepareSolutions(List<Solution> repositorySolutions) {
		for(Solution solution : repositorySolutions){
			for(SolutionFile file : solution.getFiles()){
				_converter.convertSourceCode(file);
			}	
		}
	}

	//Run detection on all the files
	private List<SolutionSimilarity> detectSimilarities(){
		List<SolutionSimilarity> results = new ArrayList<SolutionSimilarity>();
		//TODO
		//Loop over all solutions and then loop over all other solutions.
		//Keep a list with possible combinations?
		for(Solution referenceSolution : _repository.getSolutions()){
			for(SolutionFile file : referenceSolution.getFiles()){
				//Remove combination from possible combinations
				//Compare the files and add to a cumulative score.
				double similarityPercentage = 0.0;
				Solution subjectSolution = null;
				SolutionSimilarity similarity = new SolutionSimilarity(referenceSolution, subjectSolution, similarityPercentage);
				results.add(similarity); 
			}
		}
		return results;
	}
		
	//Sorts the similarities in descending order
	private List<SolutionSimilarity> sortSimilarities(List<SolutionSimilarity> results) {
		Collections.sort(results, Collections.reverseOrder());
		return results;
	}
	
	private double calculateFileSimilarity(File reference, File subject){
		return 0.0;
	}
}
