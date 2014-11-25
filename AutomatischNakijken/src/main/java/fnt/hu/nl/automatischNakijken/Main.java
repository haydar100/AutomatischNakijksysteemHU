package fnt.hu.nl.automatischNakijken;

import java.util.Calendar;

import org.hibernate.*;

import fnt.hu.nl.automatischNakijken.Data.HibernateUtil;
import fnt.hu.nl.automatischNakijken.Domain.Course;
import fnt.hu.nl.automatischNakijken.Domain.CoursePeriod;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	Course course = new Course("CSCHERP", "TICT-ACS");	
    	CoursePeriod coursePeriod = new CoursePeriod(Calendar.getInstance(), Calendar.getInstance(), course);
    	
    	Calendar c= Calendar.getInstance(); 
    	c.set(2014, 3, 1);
    	Calendar c2= Calendar.getInstance(); 
    	c2.set(2014, 6, 1);
    	CoursePeriod cp2 = new CoursePeriod(c, c2, course);
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	session.save(course);
    	session.getTransaction().commit();
    	session.beginTransaction();
    	session.save(coursePeriod);
    	session.getTransaction().commit();
    	session.beginTransaction();
    	session.save(cp2);
    	session.getTransaction().commit();
        System.out.println( "Committed....." + course.getName()+ " " + course.getCode());
        session.close();
    }
}
