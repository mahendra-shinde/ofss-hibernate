package com.mahendra;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mahendra.entities.Course;
import com.mahendra.entities.Student;


public class Demo1 {
	static SessionFactory factory = MySessionFactory.getFactory();
	
	static void prepareData() {
		Session session = factory.openSession();
	
		List<Course> courses = new LinkedList<>();
		
		Course c1 = new Course();
		c1.setDuration(3);
		c1.setTitle("Java EE 8");
		
		Course c2 = new Course();
		c2.setTitle("Spring cloud");
		c2.setDuration(2);
		
		Student s1 = new Student();
		s1.setFirstName("Rajiv");
		s1.setLastName("Bhatia");

		
		Student s2 = new Student();
		s2.setFirstName("Vishal");
		s2.setLastName("Devgan");
		

		courses.add(c1);
		courses.add(c2);
		
		s2.setCourses(courses);
		s1.setCourses(courses);
		
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			session.save(c1);
			session.save(c2);
			
			session.save(s1);
			session.save(s2);
	
			tn.commit();
			System.out.println("Records created successfuly!");
		}catch(Exception ex) {
			ex.printStackTrace();
			if(tn!=null) {
				System.out.println("Exception occured, rolling back!");
				tn.rollback();
			}
		}
		session.close();
		
	}
	
	static void printAllAccounts() {
		Session session = factory.openSession();
		List<Student> students = session.createQuery("select s from Student s").getResultList();
		System.out.println("Found records : "+students.size());
		for(Student s: students) {
			System.out.println("Student details: ");
			System.out.println("\t"+s.getFirstName()+" "+s.getLastName());
			System.out.println("\tCourses registered for : "+s.getCourses().size());
			
			System.out.println("\tCourse titles: ");
			for(Course c: s.getCourses()) {
				System.out.println("\t\t "+c.getTitle());
			}
		}
		
		session.close();
	}
	
	public static void main(String[] args) {
		prepareData();
		printAllAccounts();
		factory.close();
	}

	
}
