package fnt.hu.nl.automatischNakijken;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.*;

import fnt.hu.nl.automatischNakijken.Data.HibernateUtil;
import fnt.hu.nl.automatischNakijken.Domain.Assignment;
import fnt.hu.nl.automatischNakijken.Domain.AssignmentCheck;
import fnt.hu.nl.automatischNakijken.Domain.AssignmentType;
import fnt.hu.nl.automatischNakijken.Domain.Course;
import fnt.hu.nl.automatischNakijken.Domain.CoursePeriod;
import fnt.hu.nl.automatischNakijken.Domain.SolutionEvaluation;
import fnt.hu.nl.automatischNakijken.Domain.SolutionRepository;
import fnt.hu.nl.automatischNakijken.Domain.WorkGroup;
import fnt.hu.nl.automatischNakijken.Domain.Instructor;
import fnt.hu.nl.automatischNakijken.Domain.Solution;
import fnt.hu.nl.automatischNakijken.Domain.Student;
import fnt.hu.nl.automatischNakijken.Domain.Class;
import fnt.hu.nl.automatischNakijken.Domain.TeachingAssistant;
import fnt.hu.nl.automatischNakijken.Logic.JavaConverter;
import fnt.hu.nl.automatischNakijken.Logic.SourceCodeConverter;

/**
 * Main class Automatisch nakijksysteem
 *
 */
public class Main 
{
	
    public static void main( String[] args )
    {
    	setupDatabaseEntities();
    }
    
	private static void setupDatabaseEntities() {
		ArrayList<Solution> solutions = new ArrayList<Solution>();   	
    	ArrayList<Student> students = new ArrayList<Student>();
		Course course = new Course("CSCHERP", "TICT-ACS");
    	TeachingAssistant teachingAssistant = new TeachingAssistant("Roy", "Straub", "Roy Straub", "Roy.straub@student.hu.nl");
    	Instructor instructor = new Instructor("Esther", "Stappen", "Esther van der Stappen", "Esther.vanderstappen@hu.nl");
    	CoursePeriod coursePeriod = new CoursePeriod(Calendar.getInstance(), Calendar.getInstance(), course);
    	Class c1 = new Class("Software Engineering C1", coursePeriod);
    	WorkGroup group = new WorkGroup(1, c1, solutions, null);
    	List<WorkGroup> groups = new ArrayList<WorkGroup>();
    	List<Assignment> assignments = new ArrayList<Assignment>();
    	List<AssignmentCheck> checks = new ArrayList<AssignmentCheck>();
    	List<AssignmentType> assignmentTypes = new ArrayList<AssignmentType>();
    	File f = new File("C:/Users/lol.txt");
    	SolutionRepository sr = new SolutionRepository(null, null, null, true);
    	AssignmentType at = new AssignmentType(course, assignments, checks, sr, f, "TestAssignmentType", "Hibernate mapping test");
    	
    	Assignment assignment = new Assignment(sr, at, coursePeriod, Calendar.getInstance(), true);
    	sr.setAssignment(assignment);
    	sr.setAssignmentTypes(assignmentTypes);
    	sr.setSolutions(solutions);
    	sr.setActive(true);
    	
    	Student student = new Student("Haydar", "Yilmaz", "Haydar Yilmaz", "haydar.yilmaz@gmail.com");
    	
    	
    	
    	//AssignmentType at = new AssignmentType(course, assignments, checks, sr, testTemplate, "TestAssignmentType", "Hibernate mapping test");
    	
    	
    	//Assignment assignment = new Assignment(solutionRepository, assignmentType, coursePeriod, deadLine, allowTeachingAssistant)
    	
    	//Solution solution = new Solution();
    	//Solution solution = new Solution(solutionRepository, nextVersion, previousVersion, solutionEvaluation, similarities, group, students, files, timeOfSubmission, isCurrent)
    	//Solution solution = new Solution();
    	
    	
    	students.add(student);
    	
    //	solutions.add(solution);
    	
    	groups.add(group);
    	student.setGroups(groups);
    	Calendar c= Calendar.getInstance(); 
    	c.set(2014, 3, 1);
    	Calendar c2= Calendar.getInstance(); 
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
    	//session.save(at);
    	//session.save(sr);
    	//session.save(assignment);
    	
    	
    	session.getTransaction().commit();
    	System.out.println("Commited");
    	//System.out.println("Session commited....");
       // session.close();
      //  System.out.println("Session closed.... !");
    	session.close();
    	System.out.println("reached");
	}
}
