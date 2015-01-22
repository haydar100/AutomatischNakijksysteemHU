package fnt.hu.nl.automatischNakijken.domain;
import java.lang.Comparable;

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
	
	@Override
	public boolean equals(Object obj){
		SolutionSimilarity otherSimilarity = (SolutionSimilarity)obj;
		//If the inverted check has taken place this one is redundant
		if(this.referenceSolution == otherSimilarity.subjectSolution && this.subjectSolution == otherSimilarity.referenceSolution){
			return true;	
		}
		return false;	
	}
	
	@Override
	public String toString(){
		if(referenceSolution != null && subjectSolution != null)
			return "Solution from " + referenceSolution.getStudents().get(0) + " is " + this.similarityPercentage 
					+ "% similar to solution from " + subjectSolution.getStudents().get(0); 
		return "" + this.similarityPercentage;
	}
}
