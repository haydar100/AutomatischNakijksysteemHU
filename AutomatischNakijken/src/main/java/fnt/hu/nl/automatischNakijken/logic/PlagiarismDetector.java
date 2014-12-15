package fnt.hu.nl.automatischNakijken.logic;

import java.util.ArrayList;
import java.util.List;

import fnt.hu.nl.automatischNakijken.domain.*;

public class PlagiarismDetector {
	private SourceCodeConverter _converter;
	private SolutionRepository _repository;
	
	public PlagiarismDetector(SourceCodeConverter converter, SolutionRepository repository){
		this._converter = converter;
		this._repository = repository;
	}
	
	public List<SolutionSimilarity> detectSimilarities(){
		List<SolutionSimilarity> results = new ArrayList<SolutionSimilarity>();
		List<Solution> repositorySolutions = _repository.getSolutions();
		prepareSolutions(repositorySolutions);
		
		return results;
	}

	private void prepareSolutions(List<Solution> repositorySolutions) {
		for(Solution solution : repositorySolutions){
			for(SolutionFile file : solution.getFiles()){
				_converter.convertSourceCode(file);
			}	
		}
	}
}
