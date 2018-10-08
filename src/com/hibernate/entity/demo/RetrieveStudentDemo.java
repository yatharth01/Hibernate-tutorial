package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Student;

public class RetrieveStudentDemo {
	
	public static void main(String[] args) {

	SessionFactory factory= new Configuration()
            .configure()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
            
	Session session= factory.getCurrentSession();
	
	try {
		session.beginTransaction();
		Student theStudent=session.get(Student.class, 5);
		session.getTransaction().commit();
		System.out.println(theStudent.firstName +" "+ theStudent.lastName);
		
	}
	finally {
		session.close();
	}
	}
}
