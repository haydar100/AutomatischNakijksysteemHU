package fnt.hu.nl.automatischNakijken;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import fnt.hu.nl.automatischNakijken.Data.HibernateUtil;
import fnt.hu.nl.automatischNakijken.Domain.Course;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	List result = session.createQuery("from Course as course where course.code like 'TICT%'").list();
    	List<Course> courses = new ArrayList<Course>();
    	for(Object o : result){
    		Course course = (Course) o;
    		courses.add(course);
    	}
    	session.getTransaction().commit();
    	for(Course course : courses)
    		System.out.println(course.getName() + " " + course.getCode());
        session.close();
    }
}
