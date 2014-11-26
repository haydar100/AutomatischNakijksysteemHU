package fnt.hu.nl.automatischNakijken;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.*;

import fnt.hu.nl.automatischNakijken.Data.HibernateUtil;
import fnt.hu.nl.automatischNakijken.Domain.Course;
import fnt.hu.nl.automatischNakijken.Domain.CoursePeriod;
import fnt.hu.nl.automatischNakijken.Domain.WorkGroup;
import fnt.hu.nl.automatischNakijken.Domain.Instructor;
import fnt.hu.nl.automatischNakijken.Domain.Solution;
import fnt.hu.nl.automatischNakijken.Domain.Student;
import fnt.hu.nl.automatischNakijken.Domain.Class;
import fnt.hu.nl.automatischNakijken.Domain.TeachingAssistant;

/**
 * Main class Automatisch nakijksysteem
 *
 */
public class Main 
{
	
    public static void main( String[] args )
    {
		Course course = new Course("CSCHERP", "TICT-ACS");
    	TeachingAssistant teachingAssistant = new TeachingAssistant("Roy", "Straub", "Roy Straub", "Roy.straub@student.hu.nl");
    	Instructor instructor = new Instructor("Esther", "Stappen", "Esther van der Stappen", "Esther.vanderstappen@hu.nl");
    	Student student = new Student("Haydar", "Yilmaz", "Haydar Yilmaz", "haydar.yilmaz@gmail.com");
    	//Solution solution = new Solution();
    ArrayList<Solution> solutions = new ArrayList<Solution>();
    	ArrayList<Student> students = new ArrayList<Student>();
    	students.add(student);
    	//solutions.add(solution);
    	CoursePeriod coursePeriod = new CoursePeriod(Calendar.getInstance(), Calendar.getInstance(), course);
    	Class c1 = new Class("Software Engineering C1", coursePeriod);
    	WorkGroup group = new WorkGroup(1, c1, solutions, null);
    	List<WorkGroup> groups = new ArrayList<WorkGroup>();
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
    	session.save(cp2);
    	session.save(c1);
    	session.save(group); 
    	session.getTransaction().commit();
    	System.out.println("Commited");
    	//System.out.println("Session commited....");
       // session.close();
      //  System.out.println("Session closed.... !");
    	session.close();
    	System.out.println("reached");
    }
}
