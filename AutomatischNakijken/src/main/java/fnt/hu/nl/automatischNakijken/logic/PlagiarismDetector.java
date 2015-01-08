package fnt.hu.nl.automatischNakijken.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.emory.mathcs.backport.java.util.Collections;
import fnt.hu.nl.automatischNakijken.domain.*;
import fnt.hu.nl.automatischNakijken.util.FileUtil;
import fnt.hu.nl.automatischNakijken.util.StringSimilarityUtil;

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
		System.out.println(_sortedSimilarities);
	}
	
	//Tokenise all the solutions and all of their underlying files
	private void prepareSolutions(List<Solution> repositorySolutions) {
		for(Solution solution : repositorySolutions){
			for(SolutionFile file : solution.getFiles()){
				file.setTokenisedFile(_converter.convertSourceCode(file));
			}	
		}
	}

	//Run detection on all the files
	private List<SolutionSimilarity> detectSimilarities(){
		List<SolutionSimilarity> results = new ArrayList<SolutionSimilarity>();
		List<Solution> repositorySolutions = _repository.getSolutions();
		
		//Loop over all solutions and for each solution loop over all other solutions.
		for(Solution referenceSolution : repositorySolutions){
			for(Solution subjectSolution : repositorySolutions){
				if(referenceSolution != subjectSolution){
					SolutionSimilarity similarity = new SolutionSimilarity(referenceSolution, subjectSolution, 0.0);
					//Skip comparison if the combination has been inspected
					if(!results.contains(similarity)){
						
						List<Double> fileSimilarities = new ArrayList<Double>();
						//Compare all files of each solution
						for(SolutionFile referenceFile : referenceSolution.getFiles()){
							for(SolutionFile subjectFile : subjectSolution.getFiles()){
								//Compare the files and add to a cumulative score.
								fileSimilarities.add(getFileSimilarity(referenceFile.getTokenisedFile(), subjectFile.getTokenisedFile())); 			
							}
						}
						double similarityPercentage = calculateSolutionSimilarity(fileSimilarities);
						similarity.setSimilarityPercentage(similarityPercentage);
						results.add(similarity); 
						//Save the comparison in the referencesolution and subsequently the inverse in the subject
						referenceSolution.addSimilarity(similarity);
						
					}
				}
			}
		}
		return results;
	}
		
	private double calculateSolutionSimilarity(List<Double> fileSimilarities) {
		double sum = 0;
		for(double d : fileSimilarities){
			sum += d;
		}
		return sum/fileSimilarities.size();
	}

	//Sorts the similarities in descending order
	private List<SolutionSimilarity> sortSimilarities(List<SolutionSimilarity> results) {
		Collections.sort(results, Collections.reverseOrder());
		return results;
	}
	
	private double getFileSimilarity(File reference, File subject){
		
		String referenceContent = FileUtil.getContentFromFile(reference);
		String subjectContent = FileUtil.getContentFromFile(subject);
		
		return StringSimilarityUtil.calculateSimilarityPercentage(referenceContent, subjectContent);
	}
}
