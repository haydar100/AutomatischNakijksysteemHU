/**
 * 
 */
package fnt.hu.nl.automatischNakijken.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.SolutionRepository;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;
import fnt.hu.nl.automatischNakijken.logic.CheckStyleEvaluator;
import fnt.hu.nl.automatischNakijken.logic.JUnitEvaluator;
import fnt.hu.nl.automatischNakijken.logic.PMDEvaluator;

/**
 * @author Berkan
 *
 */
public class StaticDynamicEvaluatorTest {
	
	@Test
	public void runTest() {
		//Arrange
		List<Student> students1 = new ArrayList<Student>();
		List<Student> students2 = new ArrayList<Student>();
		List<Student> students3 = new ArrayList<Student>();
		Student student1 = new Student("Haydar", "Yilmaz", "Haydar Yilmaz", "test@test.nl");
		Student student2 = new Student("Roy", "Straub", "Roy Straub", "test@test.nl");
		Student student3 = new Student("Sjaak", "Bonenstaak", "Sjaak Bonenstaak", "test@test.nl");
		students1.add(student1);
		students2.add(student2);
		students3.add(student3);
		String filePath = "C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java";
		SolutionFile file = new SolutionFile(filePath);
		String filePath2 = "C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java";
		SolutionFile file2 = new SolutionFile(filePath2);
		String filePath3 = "C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java";
		SolutionFile file3 = new SolutionFile(filePath3);
		List<SolutionFile> files = new ArrayList<SolutionFile>();
		files.add(file);
		List<SolutionFile> files2 = new ArrayList<SolutionFile>();
		files2.add(file2);
		List<SolutionFile> files3 = new ArrayList<SolutionFile>();
		files3.add(file3);
		Solution solution1 = new Solution(null, null, null, null, null, null, students1, files3, Calendar.getInstance(), true);
		Solution solution2 = new Solution(null, null, null, null, null, null, students2, files2, Calendar.getInstance(), true);
		Solution solution3 = new Solution(null, null, null, null, null, null, students3, files, Calendar.getInstance(), true);
		List<Solution> solutions = new ArrayList<Solution>();
		solutions.add(solution1);
		solutions.add(solution2);
		solutions.add(solution3);
		SolutionRepository repository = new SolutionRepository(null, null, solutions, false, TargetLanguage.Java);
		//CheckStyleEvaluator fcr = new CheckStyleEvaluator("CheckStyleEvaluator", false, solution1, , filePath3);
		CheckStyleEvaluator fcr = new CheckStyleEvaluator("CheckStyle", false, solution1, "HelloWorldApp","C:\\Users\\Berkan\\Documents\\testfolder\\");
		PMDEvaluator pmde = new PMDEvaluator("PMD", false, solution1, "C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java");
		JUnitEvaluator junite = new JUnitEvaluator("JUnit",false, solution1, "HelloWorldApp", "C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java", "C:\\Users\\Berkan\\Documents\\testfolder\\");
		pmde.runCheck(solution1);
		System.out.println("-----------------------------------------------------------------");
		fcr.runCheck(solution1);
		System.out.println("-----------------------------------------------------------------");
		junite.runCheck(solution1);
		
		
	}

}
