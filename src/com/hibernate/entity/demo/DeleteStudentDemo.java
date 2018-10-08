package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				                .configure()
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
				                
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 5);
			
	         session.delete(myStudent);
			
			System.out.println("Student with id=5 deleted");
			
			//DElete using query
	        session.createQuery("Delete from Student where id=6").executeUpdate();
	        System.out.println("Student with id=6 deleted");
			session.getTransaction().commit();
			
		}
		
		finally {
			session.close();
		}
		
	}

}
