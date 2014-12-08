package fnt.hu.nl.automatischNakijken.logic;

import java.util.List;

import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluation;
import fnt.hu.nl.automatischNakijken.domain.SolutionSimilarity;

//Defines the feedback methods
public interface FeedbackGenerator {
	void GenerateFeedback(SolutionEvaluation solutionEvaluation);
	void GenerateFeedback(List<SolutionSimilarity> sortedSimilarities);
}
