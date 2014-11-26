package fnt.hu.nl.automatischNakijken.Logic;

import java.util.List;

import fnt.hu.nl.automatischNakijken.Domain.SolutionEvaluation;
import fnt.hu.nl.automatischNakijken.Domain.SolutionSimilarity;

public interface FeedbackGenerator {
	void GenerateFeedback(SolutionEvaluation solutionEvaluation);
	void GenerateFeedback(List<SolutionSimilarity> sortedSimilarities);
}
