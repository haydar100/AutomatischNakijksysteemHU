package fnt.hu.nl.automatischNakijken.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluation;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.SolutionRepository;
import fnt.hu.nl.automatischNakijken.domain.SolutionSimilarity;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;
import fnt.hu.nl.automatischNakijken.domain.WorkGroup;
import fnt.hu.nl.automatischNakijken.logic.JavaConverter;
import fnt.hu.nl.automatischNakijken.logic.PlagiarismDetector;

public class PlagiarismDetectorTest {

	@Test
	public void test() {
		//Arrange
		String filePath = "/Users/roystraub/Desktop/Class.java";
		SolutionFile file = new SolutionFile(filePath);
		
		List<SolutionFile> files = new ArrayList<SolutionFile>();
		files.add(file);
		Solution solution = new Solution(null, null, null,null,null, null, null, files, Calendar.getInstance(), true);
		List<Solution> solutions = new ArrayList<Solution>();
		solutions.add(solution);
		SolutionRepository repository = new SolutionRepository(null, null, solutions, false, TargetLanguage.Java);
		PlagiarismDetector detector = new PlagiarismDetector(new JavaConverter(), repository);
		//Act
		detector.startPlagiarismDetection();
		//Assert
		String newPath = filePath.replaceAll("java", "tff");
	}

}
