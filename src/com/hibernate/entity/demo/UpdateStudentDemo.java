package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				                .configure()
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
				                
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 1);
			
	         myStudent.setFirstName("Sidhant");
	  
			session.getTransaction().commit();
			
			System.out.println(myStudent.firstName);
			
			
			
			//New code
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("Update Student set email='foo@nit.com'").executeUpdate();
			
		}
		
		finally {
			session.close();
		}
		
	}

}
