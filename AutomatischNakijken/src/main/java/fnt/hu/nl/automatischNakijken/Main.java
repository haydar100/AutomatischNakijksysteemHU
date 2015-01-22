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
import fnt.hu.nl.automatischNakijken.domain.SolutionRepository;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.domain.TargetLanguage;
import fnt.hu.nl.automatischNakijken.domain.TeachingAssistant;
import fnt.hu.nl.automatischNakijken.domain.WorkGroup;
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
		runJUnit();
		runCheckStyle();
		runPMD();
		// RunPMD();
		// setupDatabaseEntities();
	}
	
	private static void runJUnit() {
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
		AutomaticCheck test = new AutomaticCheck("PMD", true);
		//test.runCheck(s)
		PMDRunner pmd = new PMDRunner("PMD", true);
		pmd.callPmd("C:\\Users\\Berkan\\Documents\\testfolder\\HelloWorldApp.java");

	}

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
