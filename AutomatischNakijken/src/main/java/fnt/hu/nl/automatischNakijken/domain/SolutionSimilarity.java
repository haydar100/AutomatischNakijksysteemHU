package fnt.hu.nl.automatischNakijken.domain;

public class SolutionSimilarity implements Comparable<SolutionSimilarity> {
	private Solution referenceSolution;
	private Solution subjectSolution;
	private double similarityPercentage;
	private int id;
	
	private SolutionSimilarity(){
		
	}
	
	public SolutionSimilarity(Solution referenceSolution, Solution subjectSolution, double similarityPercentage){
		this.referenceSolution = referenceSolution;
		this.subjectSolution = subjectSolution;
		this.similarityPercentage = similarityPercentage;
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

	@Override
	public int compareTo(SolutionSimilarity otherSimilarity) {
		Double tempPercentage = new Double(this.similarityPercentage);
		Double otherPercentage = otherSimilarity.getSimilarityPercentage();
		return tempPercentage.compareTo(otherPercentage);
	}
	
	public String toString(){
		if(referenceSolution != null && subjectSolution != null)
			return "Reference solution with id= " + referenceSolution.getId() + " is " + this.similarityPercentage 
					+ "% similar to subject solution with id= " + subjectSolution.getId(); 
		return "" + this.similarityPercentage;
	}
}
