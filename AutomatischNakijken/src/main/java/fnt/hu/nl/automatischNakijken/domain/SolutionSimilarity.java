package fnt.hu.nl.automatischNakijken.domain;

public class SolutionSimilarity {
	private Solution referenceSolution;
	private Solution subjectSolution;
	private double similarityPercentage;
	private int id;
	
	private SolutionSimilarity(){
		
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public Solution getReferenceSolution() {
		return referenceSolution;
	}

	public void setReferenceSolution(Solution referenceSolution) {
		this.referenceSolution = referenceSolution;
	}

	public Solution getSubjectSolution() {
		return subjectSolution;
	}

	public void setSubjectSolution(Solution subjectSolution) {
		this.subjectSolution = subjectSolution;
	}

	public double getSimilarityPercentage() {
		return similarityPercentage;
	}

	public void setSimilarityPercentage(double similarityPercentage) {
		this.similarityPercentage = similarityPercentage;
	}

}
