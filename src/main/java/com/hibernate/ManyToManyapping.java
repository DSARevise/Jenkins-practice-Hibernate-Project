package com.hibernate;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entities.Courses;
import com.hibernate.entities.Student;

public class ManyToManyapping {
	public static void main(String[]args)
	{
		SessionFactory factory=HiernateUtil.getSessionFactory();
		Session session =factory.openSession();
		Transaction trx=session.beginTransaction();
		  Courses c1 = new Courses();
		    c1.setCourseName("Java");
		    c1.setCourseFees(25000);

		    Courses c2 = new Courses();
		    c2.setCourseName("Spring Boot");
		    c2.setCourseFees(30000);

		    // Create Students
		    Student s1 = new Student();
		    s1.setStudentName("Rajat");
		    s1.setStudentMarks(98);
		    s1.setJoiningDate(new Date());

		    Student s2 = new Student();
		    s2.setStudentName("Kanchan");
		    s2.setStudentMarks(95);
		    s1.setJoiningDate(new Date());
		    
		    

		    // Set relationships
		    s1.addCourse(c1);
		    s1.addCourse(c2);

		    s2.addCourse(c1);   // both students take Java
		    session.save(s1);
		    session.save(s2);
		    session.save(c1);
		    session.save(c2);
		    System.out.println("Data has been entered successfully");

		
		trx.commit();
		session.close();
	}

}
