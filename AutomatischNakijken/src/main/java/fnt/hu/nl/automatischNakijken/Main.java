package fnt.hu.nl.automatischNakijken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import fnt.hu.nl.automatischNakijken.data.HibernateUtil;
import fnt.hu.nl.automatischNakijken.domain.Assignment;
import fnt.hu.nl.automatischNakijken.domain.AssignmentCheck;
import fnt.hu.nl.automatischNakijken.domain.AssignmentType;
import fnt.hu.nl.automatischNakijken.domain.AutomaticCheck;
import fnt.hu.nl.automatischNakijken.domain.Class;
import fnt.hu.nl.automatischNakijken.domain.Course;
import fnt.hu.nl.automatischNakijken.domain.CoursePeriod;
import fnt.hu.nl.automatischNakijken.domain.Instructor;
import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.SolutionRepository;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;
import fnt.hu.nl.automatischNakijken.domain.TeachingAssistant;
import fnt.hu.nl.automatischNakijken.domain.WorkGroup;
import fnt.hu.nl.automatischNakijken.logic.CheckStyleEvaluator;
import fnt.hu.nl.automatischNakijken.logic.JUnitEvaluator;
import fnt.hu.nl.automatischNakijken.logic.JavaConverter;
import fnt.hu.nl.automatischNakijken.logic.PMDEvaluator;
import fnt.hu.nl.automatischNakijken.logic.PlagiarismDetector;
import fnt.hu.nl.automatischNakijken.test.IHelloWorldAppTest;
import fnt.hu.nl.automatischNakijken.util.CheckStyleRunner;
import fnt.hu.nl.automatischNakijken.util.FolderChecker;
import fnt.hu.nl.automatischNakijken.util.PMDRunner;
import fnt.hu.nl.automatischNakijken.util.ReflectionUtil;
import fnt.hu.nl.automatischNakijken.util.TestRunner;
import fnt.hu.nl.automatischNakijken.util.URIClassLoader;
import fnt.hu.nl.opdracht.IHelloWorldApp;

/**
 * Main class Automatisch nakijksysteem
 * 
 */
public class Main {
	
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, CheckstyleException, IOException,
			URISyntaxException {
		runTest();
	}
	
	public static void runTest() {
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
		String filePath = "C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java";
		SolutionFile file = new SolutionFile(filePath);
		String filePath2 = "C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java";
		SolutionFile file2 = new SolutionFile(filePath2);
		String filePath3 = "C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java";
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
		CheckStyleEvaluator fcr = new CheckStyleEvaluator("CheckStyle", false, solution1, "HelloWorldApp","C:\\Users\\Berkan\\Desktop\\test\\");
		PMDEvaluator pmde = new PMDEvaluator("PMD", false, solution1, "C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java");
		JUnitEvaluator junite = new JUnitEvaluator("PMD",false, solution1, "HelloWorldApp", "C:\\Users\\Berkan\\Desktop\\test\\HelloWorldApp.java", "C:\\Users\\Berkan\\Desktop\\test\\");
		pmde.runCheck(solution1);
		fcr.runCheck(solution1);
		junite.runCheck(solution1);
		
		
	}
	
/*	private static void runJUnit() {
		TestRunner runner = new TestRunner();
		IHelloWorldAppTest instance = new IHelloWorldAppTest();
		URIClassLoader UriClassLoader = new URIClassLoader();
		FolderChecker
				.removeFilesWithClassExtension("C:\\Users\\Berkan\\Documents\\testfolder\\");
		UriClassLoader
				.compileJavaSourceFile("C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java");
		instance.setClassName("HelloWorldApp");
		instance.setPathToClass("C:\\Users\\Berkan\\Documents\\testfolder\\");
		runner.runClass(instance.getClass());
	
	}

	private static void runCheckStyle() throws FileNotFoundException,
			CheckstyleException, InstantiationException, IllegalAccessException {
		// http://stackoverflow.com/questions/11916706/slf4j-failed-to-load-class-org-slf4j-impl-staticloggerbinder-error
		URIClassLoader test = new URIClassLoader();
		java.lang.Class<?> loadedClass = test.loadCompiledClass(
				"HelloWorldApp", "C:\\Users\\Berkan\\Documents\\testfolder\\");
		IHelloWorldApp ihwp = ((IHelloWorldApp) loadedClass.newInstance());
		CheckStyleRunner csr = new CheckStyleRunner("CheckStyle", true);
		csr.run(ihwp, "C:\\Users\\Berkan\\Documents\\testfolder\\",
				"checkstyle.xml");
	}

	private static void runPMD() throws IOException {
		AutomaticCheck check = new AutomaticCheck(name, isFailable);
		check.runCheck(s)
		PMDRunner pmd = new PMDRunner("PMD", true);
		CheckStyleRunner run = new CheckStyleRunner("blabla", true);
		pmd.callPmd("C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java");
		pmd.runCheck(s)

	}*/

	private static void setupDatabaseEntities() {

		ArrayList<Solution> solutions = new ArrayList<Solution>();
		ArrayList<Student> students = new ArrayList<Student>();
		Course course = new Course("CSCHERP", "TICT-ACS");
		TeachingAssistant teachingAssistant = new TeachingAssistant("Roy",
				"Straub", "Roy Straub", "Roy.straub@student.hu.nl");
		Instructor instructor = new Instructor("Esther", "Stappen",
				"Esther van der Stappen", "Esther.vanderstappen@hu.nl");
		CoursePeriod coursePeriod = new CoursePeriod(Calendar.getInstance(),
				Calendar.getInstance(), course);
		Class c1 = new Class("Software Engineering C1", coursePeriod);
		WorkGroup group = new WorkGroup(1, c1, solutions, null);
		List<WorkGroup> groups = new ArrayList<WorkGroup>();
		List<Assignment> assignments = new ArrayList<Assignment>();
		List<AssignmentCheck> checks = new ArrayList<AssignmentCheck>();
		List<AssignmentType> assignmentTypes = new ArrayList<AssignmentType>();
		List<Instructor> instructors = new ArrayList<Instructor>();
		instructors.add(instructor);
		File f = new File("C:/Users/lol.txt");
		SolutionRepository sr = new SolutionRepository(null, null, null, true,
				TargetLanguage.Java);
		AssignmentType at = new AssignmentType(course, assignments, checks, sr,
				f, "TestAssignmentType", "Hibernate mapping test");

		Assignment assignment = new Assignment(sr, at, coursePeriod,
				Calendar.getInstance(), true);
		sr.setAssignment(assignment);
		sr.setAssignmentTypes(assignmentTypes);
		sr.setSolutions(solutions);
		sr.setActive(true);

		Student student = new Student("Haydar", "Yilmaz", "Haydar Yilmaz",
				"haydar.yilmaz@gmail.com");
		List<Class> classes = new ArrayList<Class>();
		classes.add(c1);
		instructor.setClasses(classes);
		c1.setInstructors(instructors);

		// AssignmentType at = new AssignmentType(course, assignments, checks,
		// sr, testTemplate, "TestAssignmentType", "Hibernate mapping test");

		// Assignment assignment = new Assignment(solutionRepository,
		// assignmentType, coursePeriod, deadLine, allowTeachingAssistant)

		// Solution solution = new Solution();
		// Solution solution = new Solution(solutionRepository, nextVersion,
		// previousVersion, solutionEvaluation, similarities, group, students,
		// files, timeOfSubmission, isCurrent)
		// Solution solution = new Solution();

		students.add(student);

		// solutions.add(solution);
		Calendar startTime = Calendar.getInstance();
		groups.add(group);
		student.setGroups(groups);
		c1.setGroups(groups);
		Calendar c = Calendar.getInstance();
		c.set(2014, 3, 1);
		Calendar c2 = Calendar.getInstance();
		c2.set(2014, 6, 1);
		CoursePeriod cp2 = new CoursePeriod(c, c2, course);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(course);
		session.save(coursePeriod);
		session.save(cp2);
		session.save(student);
		session.save(instructor);
		session.save(teachingAssistant);
		session.save(cp2);
		session.save(c1);
		session.save(group);
		System.out.println("check ....");
		// session.save(at);
		// session.save(sr);
		// session.save(assignment);

		session.getTransaction().commit();
		System.out.println("Commited");
		// System.out.println("Session commited....");
		// session.close();
		// System.out.println("Session closed.... !");
		Calendar endTime = Calendar.getInstance();
		long totalTime = startTime.getTimeInMillis()
				- endTime.getTimeInMillis();
		System.out.println(totalTime);
		session.close();
		System.out.println("reached");
	}
}
