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
		List<Student> students1 = new ArrayList<Student>();
		List<Student> students2 = new ArrayList<Student>();
		List<Student> students3 = new ArrayList<Student>();
		Student student1 = new Student("Haydar", "Yilmaz", "Haydar Yilmaz", "test@test.nl");
		Student student2 = new Student("Roy", "Straub", "Roy Straub", "test@test.nl");
		Student student3 = new Student("Test", "Testington", "Test Testington", "test@test.nl");
		students1.add(student1);
		students2.add(student2);
		students3.add(student3);
		String filePath = "/Users/roystraub/Desktop/Class.java";
		SolutionFile file = new SolutionFile(filePath);
		String filePath2 = "/Users/roystraub/Desktop/ClassPlagiarised.java";
		SolutionFile file2 = new SolutionFile(filePath2);
		List<SolutionFile> files = new ArrayList<SolutionFile>();
		files.add(file);
		List<SolutionFile> files2 = new ArrayList<SolutionFile>();
		files2.add(file2);
		Solution solution1 = new Solution(null, null, null, null, null, null, students1, files, Calendar.getInstance(), true);
		Solution solution2 = new Solution(null, null, null, null, null, null, students2, files2, Calendar.getInstance(), true);
		Solution solution3 = new Solution(null, null, null, null, null, null, students3, files, Calendar.getInstance(), true);
		List<Solution> solutions = new ArrayList<Solution>();
		solutions.add(solution1);
		solutions.add(solution2);
		solutions.add(solution3);
		SolutionRepository repository = new SolutionRepository(null, null, solutions, false, TargetLanguage.Java);
		PlagiarismDetector detector = new PlagiarismDetector(new JavaConverter(), repository);
		//Act
		detector.startPlagiarismDetection();
		//Assert
		String newPath = filePath.replaceAll("java", "tff");
	}

}
